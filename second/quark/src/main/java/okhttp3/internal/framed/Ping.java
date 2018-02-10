package okhttp3.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
public final class Ping {
    private final CountDownLatch latch = new CountDownLatch(1);
    private long received = -1;
    private long sent = -1;

    Ping() {
    }

    final void send() {
        if (this.sent != -1) {
            throw new IllegalStateException();
        }
        this.sent = System.nanoTime();
    }

    final void receive() {
        if (this.received != -1 || this.sent == -1) {
            throw new IllegalStateException();
        }
        this.received = System.nanoTime();
        this.latch.countDown();
    }

    final void cancel() {
        if (this.received != -1 || this.sent == -1) {
            throw new IllegalStateException();
        }
        this.received = this.sent - 1;
        this.latch.countDown();
    }

    public final long roundTripTime() throws InterruptedException {
        this.latch.await();
        return this.received - this.sent;
    }

    public final long roundTripTime(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.latch.await(j, timeUnit)) {
            return this.received - this.sent;
        }
        return -2;
    }
}
