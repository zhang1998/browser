package okhttp3.internal.http;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private boolean forWebSocket;
    private StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public final void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public final boolean isCanceled() {
        return this.canceled;
    }

    public final OkHttpClient client() {
        return this.client;
    }

    public final void setForWebSocket(boolean z) {
        this.forWebSocket = z;
    }

    public final boolean isForWebSocket() {
        return this.forWebSocket;
    }

    public final StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public final Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        this.streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()));
        int i = 0;
        Request request2 = request;
        Response response = null;
        while (!this.canceled) {
            try {
                Response proceed = ((RealInterceptorChain) chain).proceed(request2, this.streamAllocation, null, null);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                }
                request2 = followUpRequest(proceed);
                if (request2 == null) {
                    if (!this.forWebSocket) {
                        this.streamAllocation.release();
                    }
                    return proceed;
                }
                Util.closeQuietly(proceed.body());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.streamAllocation.release();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (request2.body() instanceof UnrepeatableRequestBody) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                } else {
                    if (!sameConnection(proceed, request2.url())) {
                        this.streamAllocation.release();
                        this.streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request2.url()));
                    } else if (this.streamAllocation.stream() != null) {
                        throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                    }
                    i = i2;
                    response = proceed;
                }
            } catch (RouteException e) {
                if (!recover(e.getLastConnectException(), true, request2)) {
                    throw e.getLastConnectException();
                }
            } catch (IOException e2) {
                if (!recover(e2, false, request2)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.streamAllocation.streamFailed(null);
                this.streamAllocation.release();
            }
        }
        this.streamAllocation.release();
        throw new IOException("Canceled");
    }

    private Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner = null;
        if (httpUrl.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            hostnameVerifier = null;
            sslSocketFactory = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean recover(IOException iOException, boolean z, Request request) {
        this.streamAllocation.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((z || !(request.body() instanceof UnrepeatableRequestBody)) && isRecoverable(iOException, z) && this.streamAllocation.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if ((iOException instanceof SocketTimeoutException) && z) {
                return true;
            }
            return false;
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        } else {
            return true;
        }
    }

    private Request followUpRequest(Response response) throws IOException {
        if (response == null) {
            throw new IllegalStateException();
        }
        Connection connection = this.streamAllocation.connection();
        Route route = connection != null ? connection.route() : null;
        int code = response.code();
        String method = response.request().method();
        switch (code) {
            case SecExceptionCode.SEC_ERROR_STA_ENC /*300*/:
            case SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM /*301*/:
            case SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH /*302*/:
            case SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE /*303*/:
                break;
            case 307:
            case 308:
                if (!(method.equals(SpdyRequest.GET_METHOD) || method.equals("HEAD"))) {
                    return null;
                }
            case 401:
                return this.client.authenticator().authenticate(route, response);
            case SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_MISMATCH_KEY_DATA /*407*/:
                Proxy proxy;
                if (route != null) {
                    proxy = route.proxy();
                } else {
                    proxy = this.client.proxy();
                }
                if (proxy.type() == Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                if (response.request().body() instanceof UnrepeatableRequestBody) {
                    return null;
                }
                return response.request();
            default:
                return null;
        }
        if (!this.client.followRedirects()) {
            return null;
        }
        String header = response.header("Location");
        if (header == null) {
            return null;
        }
        HttpUrl resolve = response.request().url().resolve(header);
        if (resolve == null) {
            return null;
        }
        if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            if (HttpMethod.redirectsToGet(method)) {
                newBuilder.method(SpdyRequest.GET_METHOD, null);
            } else {
                newBuilder.method(method, null);
            }
            newBuilder.removeHeader("Transfer-Encoding");
            newBuilder.removeHeader("Content-Length");
            newBuilder.removeHeader("Content-Type");
        }
        if (!sameConnection(response, resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }
}
