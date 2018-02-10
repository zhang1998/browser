package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.StreamResetException;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.Http2xStream;
import okhttp3.internal.http.HttpStream;

/* compiled from: ProGuard */
public final class StreamAllocation {
    public final Address address;
    private boolean canceled;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    private int refusedStreamCount;
    private boolean released;
    private Route route;
    private final RouteSelector routeSelector;
    private HttpStream stream;

    public StreamAllocation(ConnectionPool connectionPool, Address address) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.routeSelector = new RouteSelector(address, routeDatabase());
    }

    public final HttpStream newStream(OkHttpClient okHttpClient, boolean z) {
        int connectTimeoutMillis = okHttpClient.connectTimeoutMillis();
        int readTimeoutMillis = okHttpClient.readTimeoutMillis();
        int writeTimeoutMillis = okHttpClient.writeTimeoutMillis();
        try {
            HttpStream http2xStream;
            RealConnection findHealthyConnection = findHealthyConnection(connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, okHttpClient.retryOnConnectionFailure(), z);
            if (findHealthyConnection.framedConnection != null) {
                http2xStream = new Http2xStream(okHttpClient, this, findHealthyConnection.framedConnection);
            } else {
                findHealthyConnection.socket().setSoTimeout(readTimeoutMillis);
                findHealthyConnection.source.timeout().timeout((long) readTimeoutMillis, TimeUnit.MILLISECONDS);
                findHealthyConnection.sink.timeout().timeout((long) writeTimeoutMillis, TimeUnit.MILLISECONDS);
                http2xStream = new Http1xStream(okHttpClient, this, findHealthyConnection.source, findHealthyConnection.sink);
            }
            synchronized (this.connectionPool) {
                this.stream = http2xStream;
            }
            return http2xStream;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        RealConnection findConnection;
        while (true) {
            findConnection = findConnection(i, i2, i3, z);
            synchronized (this.connectionPool) {
                if (findConnection.successCount != 0) {
                    if (findConnection.isHealthy(z2)) {
                        break;
                    }
                    noNewStreams();
                } else {
                    break;
                }
            }
        }
        return findConnection;
    }

    private RealConnection findConnection(int i, int i2, int i3, boolean z) throws IOException {
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new IllegalStateException("released");
            } else if (this.stream != null) {
                throw new IllegalStateException("stream != null");
            } else if (this.canceled) {
                throw new IOException("Canceled");
            } else {
                realConnection = this.connection;
                if (realConnection == null || realConnection.noNewStreams) {
                    realConnection = Internal.instance.get(this.connectionPool, this.address, this);
                    if (realConnection != null) {
                        this.connection = realConnection;
                    } else {
                        Route route;
                        Route route2 = this.route;
                        if (route2 == null) {
                            route2 = this.routeSelector.next();
                            synchronized (this.connectionPool) {
                                this.route = route2;
                                this.refusedStreamCount = 0;
                            }
                            route = route2;
                        } else {
                            route = route2;
                        }
                        realConnection = new RealConnection(route);
                        acquire(realConnection);
                        synchronized (this.connectionPool) {
                            Internal.instance.put(this.connectionPool, realConnection);
                            this.connection = realConnection;
                            if (this.canceled) {
                                throw new IOException("Canceled");
                            }
                        }
                        realConnection.connect(i, i2, i3, this.address.connectionSpecs(), z);
                        routeDatabase().connected(realConnection.route());
                    }
                }
            }
        }
        return realConnection;
    }

    public final void streamFinished(boolean z, HttpStream httpStream) {
        synchronized (this.connectionPool) {
            if (httpStream != null) {
                if (httpStream == this.stream) {
                    if (!z) {
                        RealConnection realConnection = this.connection;
                        realConnection.successCount++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.stream + " but was " + httpStream);
        }
        deallocate(z, false, true);
    }

    public final HttpStream stream() {
        HttpStream httpStream;
        synchronized (this.connectionPool) {
            httpStream = this.stream;
        }
        return httpStream;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public final synchronized RealConnection connection() {
        return this.connection;
    }

    public final void release() {
        deallocate(false, true, false);
    }

    public final void noNewStreams() {
        deallocate(true, false, false);
    }

    private void deallocate(boolean z, boolean z2, boolean z3) {
        RealConnection realConnection = null;
        synchronized (this.connectionPool) {
            if (z3) {
                this.stream = null;
            }
            if (z2) {
                this.released = true;
            }
            if (this.connection != null) {
                if (z) {
                    this.connection.noNewStreams = true;
                }
                if (this.stream == null && (this.released || this.connection.noNewStreams)) {
                    release(this.connection);
                    if (this.connection.allocations.isEmpty()) {
                        this.connection.idleAtNanos = System.nanoTime();
                        if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                            realConnection = this.connection;
                        }
                    }
                    this.connection = null;
                }
            }
        }
        if (realConnection != null) {
            Util.closeQuietly(realConnection.socket());
        }
    }

    public final void cancel() {
        synchronized (this.connectionPool) {
            this.canceled = true;
            HttpStream httpStream = this.stream;
            RealConnection realConnection = this.connection;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public final void streamFailed(IOException iOException) {
        boolean z;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.refusedStreamCount > 1) {
                    this.route = null;
                }
                z = false;
            } else {
                if (!(this.connection == null || this.connection.isMultiplexed())) {
                    if (this.connection.successCount == 0) {
                        if (!(this.route == null || iOException == null)) {
                            this.routeSelector.connectFailed(this.route, iOException);
                        }
                        this.route = null;
                    }
                }
                z = false;
            }
            z = true;
        }
        deallocate(z, false, true);
    }

    public final void acquire(RealConnection realConnection) {
        realConnection.allocations.add(new WeakReference(this));
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) realConnection.allocations.get(i)).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final boolean hasMoreRoutes() {
        return this.route != null || this.routeSelector.hasNext();
    }

    public final String toString() {
        return this.address.toString();
    }
}
