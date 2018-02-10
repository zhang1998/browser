package okhttp3.internal.connection;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedConnection.Builder;
import okhttp3.internal.framed.FramedConnection.Listener;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* compiled from: ProGuard */
public final class RealConnection extends Listener implements Connection {
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(Route route) {
        this.route = route;
    }

    public final void connect(int i, int i2, int i3, List<ConnectionSpec> list, boolean z) {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        if (this.route.address().sslSocketFactory() == null) {
            if (list.contains(ConnectionSpec.CLEARTEXT)) {
                String host = this.route.address().url().host();
                if (!Platform.get().isCleartextTrafficPermitted(host)) {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
                }
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
        }
        RouteException routeException = null;
        while (this.protocol == null) {
            try {
                if (this.route.requiresTunnel()) {
                    buildTunneledConnection(i, i2, i3, connectionSpecSelector);
                } else {
                    buildConnection(i, i2, i3, connectionSpecSelector);
                }
            } catch (IOException e) {
                Util.closeQuietly(this.socket);
                Util.closeQuietly(this.rawSocket);
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.addConnectException(e);
                }
                if (!z || !connectionSpecSelector.connectionFailed(e)) {
                    throw routeException;
                }
            }
        }
    }

    private void buildTunneledConnection(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
            connectSocket(i, i2);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
            } else {
                establishProtocol(i2, i3, connectionSpecSelector);
                return;
            }
        }
    }

    private void buildConnection(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        connectSocket(i, i2);
        establishProtocol(i2, i3, connectionSpecSelector);
    }

    private void connectSocket(int i, int i2) throws IOException {
        Proxy proxy = this.route.proxy();
        Socket createSocket = (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) ? this.route.address().socketFactory().createSocket() : new Socket(proxy);
        this.rawSocket = createSocket;
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.rawSocket));
            this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        } catch (ConnectException e) {
            throw new ConnectException("Failed to connect to " + this.route.socketAddress());
        }
    }

    private void establishProtocol(int i, int i2, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            connectTls(i, i2, connectionSpecSelector);
        } else {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.rawSocket;
        }
        if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(0);
            FramedConnection build = new Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).protocol(this.protocol).listener(this).build();
            build.start();
            this.allocationLimit = build.maxConcurrentStreams();
            this.framedConnection = build;
            return;
        }
        this.allocationLimit = 1;
    }

    private void connectTls(int i, int i2, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Throwable th;
        Socket socket;
        Throwable th2;
        String str = null;
        Address address = this.route.address();
        try {
            Socket socket2 = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(socket2);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(socket2, address.url().host(), address.protocols());
                }
                socket2.startHandshake();
                Handshake handshake = Handshake.get(socket2.getSession());
                if (address.hostnameVerifier().verify(address.url().host(), socket2.getSession())) {
                    address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(socket2);
                    }
                    this.socket = socket2;
                    this.source = Okio.buffer(Okio.source(this.socket));
                    this.sink = Okio.buffer(Okio.sink(this.socket));
                    this.handshake = handshake;
                    this.protocol = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                    if (socket2 != null) {
                        Platform.get().afterHandshake(socket2);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
            } catch (Throwable e) {
                th = e;
                socket = socket2;
                th2 = th;
                try {
                    if (Util.isAndroidGetsocknameError(th2)) {
                        throw new IOException(th2);
                    }
                    throw th2;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (Throwable e2) {
                th = e2;
                socket = socket2;
                th2 = th;
                if (socket != null) {
                    Platform.get().afterHandshake(socket);
                }
                Util.closeQuietly(socket);
                throw th2;
            }
        } catch (AssertionError e3) {
            th2 = e3;
            if (Util.isAndroidGetsocknameError(th2)) {
                throw new IOException(th2);
            }
            throw th2;
        }
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        Response build;
        do {
            Http1xStream http1xStream = new Http1xStream(null, null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(request.headers(), str);
            http1xStream.finishRequest();
            build = http1xStream.readResponse().request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1xStream.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            switch (build.code()) {
                case 200:
                    if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_MISMATCH_KEY_DATA /*407*/:
                    request = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (request != null) {
                        break;
                    }
                    throw new IOException("Failed to authenticate with proxy");
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        } while (!"close".equalsIgnoreCase(build.header("Connection")));
        return request;
    }

    private Request createTunnelRequest() {
        return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    public final Route route() {
        return this.route;
    }

    public final void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public final Socket socket() {
        return this.socket;
    }

    public final boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection != null || !z) {
            return true;
        }
        try {
            soTimeout = this.socket.getSoTimeout();
            this.socket.setSoTimeout(1);
            if (this.source.exhausted()) {
                this.socket.setSoTimeout(soTimeout);
                return false;
            }
            this.socket.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    public final void onStream(FramedStream framedStream) throws IOException {
        framedStream.close(ErrorCode.REFUSED_STREAM);
    }

    public final void onSettings(FramedConnection framedConnection) {
        this.allocationLimit = framedConnection.maxConcurrentStreams();
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final boolean isMultiplexed() {
        return this.framedConnection != null;
    }

    public final Protocol protocol() {
        if (this.framedConnection == null) {
            return this.protocol != null ? this.protocol : Protocol.HTTP_1_1;
        } else {
            return this.framedConnection.getProtocol();
        }
    }

    public final String toString() {
        return "Connection{" + this.route.address().url().host() + ":" + this.route.address().url().port() + ", proxy=" + this.route.proxy() + " hostAddress=" + this.route.socketAddress() + " cipherSuite=" + (this.handshake != null ? this.handshake.cipherSuite() : "none") + " protocol=" + this.protocol + '}';
    }
}
