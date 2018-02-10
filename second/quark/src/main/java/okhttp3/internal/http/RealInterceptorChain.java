package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Connection;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.StreamAllocation;

/* compiled from: ProGuard */
public final class RealInterceptorChain implements Chain {
    private int calls;
    private final Connection connection;
    private final HttpStream httpStream;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request request;
    private final StreamAllocation streamAllocation;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpStream httpStream, Connection connection, int i, Request request) {
        this.interceptors = list;
        this.connection = connection;
        this.streamAllocation = streamAllocation;
        this.httpStream = httpStream;
        this.index = i;
        this.request = request;
    }

    public final Connection connection() {
        return this.connection;
    }

    public final StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public final HttpStream httpStream() {
        return this.httpStream;
    }

    public final Request request() {
        return this.request;
    }

    public final Response proceed(Request request) throws IOException {
        return proceed(request, this.streamAllocation, this.httpStream, this.connection);
    }

    public final Response proceed(Request request, StreamAllocation streamAllocation, HttpStream httpStream, Connection connection) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        if (this.httpStream != null && !sameConnection(request.url())) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        } else if (this.httpStream == null || this.calls <= 1) {
            Object realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation, httpStream, connection, this.index + 1, request);
            Interceptor interceptor = (Interceptor) this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(realInterceptorChain);
            if (httpStream != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
            } else if (intercept != null) {
                return intercept;
            } else {
                throw new NullPointerException("interceptor " + interceptor + " returned null");
            }
        } else {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
    }

    private boolean sameConnection(HttpUrl httpUrl) {
        return httpUrl.host().equals(this.connection.route().address().url().host()) && httpUrl.port() == this.connection.route().address().url().port();
    }
}
