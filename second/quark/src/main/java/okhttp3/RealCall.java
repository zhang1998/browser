package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

/* compiled from: ProGuard */
final class RealCall implements Call {
    private final OkHttpClient client;
    private boolean executed;
    Request originalRequest;
    private final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;

    /* compiled from: ProGuard */
    final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        private AsyncCall(Callback callback) {
            super("OkHttp %s", r5.redactedUrl().toString());
            this.responseCallback = callback;
        }

        final String host() {
            return RealCall.this.originalRequest.url().host();
        }

        final Request request() {
            return RealCall.this.originalRequest;
        }

        final RealCall get() {
            return RealCall.this;
        }

        protected final void execute() {
            Throwable e;
            Object obj = 1;
            Object obj2 = null;
            try {
                Response access$100 = RealCall.this.getResponseWithInterceptorChain();
                if (RealCall.this.retryAndFollowUpInterceptor.isCanceled()) {
                    try {
                        this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (obj == null) {
                            this.responseCallback.onFailure(RealCall.this, e);
                        } else {
                            try {
                                Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                            } catch (Throwable th) {
                                RealCall.this.client.dispatcher().finished(this);
                            }
                        }
                        RealCall.this.client.dispatcher().finished(this);
                    }
                }
                this.responseCallback.onResponse(RealCall.this, access$100);
                RealCall.this.client.dispatcher().finished(this);
            } catch (IOException e3) {
                e = e3;
                obj = obj2;
                if (obj == null) {
                    Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                } else {
                    this.responseCallback.onFailure(RealCall.this, e);
                }
                RealCall.this.client.dispatcher().finished(this);
            }
        }
    }

    protected RealCall(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient);
    }

    public final Request request() {
        return this.originalRequest;
    }

    public final Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    final synchronized void setForWebSocket() {
        if (this.executed) {
            throw new IllegalStateException("Already Executed");
        }
        this.retryAndFollowUpInterceptor.setForWebSocket(true);
    }

    public final void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public final void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public final synchronized boolean isExecuted() {
        return this.executed;
    }

    public final boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    final StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    private String toLoggableString() {
        return (this.retryAndFollowUpInterceptor.isCanceled() ? "canceled call" : "call") + " to " + redactedUrl();
    }

    final HttpUrl redactedUrl() {
        return this.originalRequest.url().resolve("/...");
    }

    private Response getResponseWithInterceptorChain() throws IOException {
        List arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.retryAndFollowUpInterceptor.isForWebSocket()) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.retryAndFollowUpInterceptor.isForWebSocket()));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest).proceed(this.originalRequest);
    }
}
