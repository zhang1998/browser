package com.alibaba.analytics.core.b;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.appmonitor.d.b;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class e implements com.alibaba.appmonitor.d.e {
    private static e c = new e();
    private static long f = 300000;
    public long a;
    public final AtomicInteger b;
    private ScheduledFuture d;
    private final AtomicInteger e;
    private Runnable g;

    public static e a() {
        return c;
    }

    private e() {
        this.a = System.currentTimeMillis();
        this.d = null;
        this.e = new AtomicInteger(0);
        this.b = new AtomicInteger(0);
        this.g = new d(this);
        this.a = System.currentTimeMillis();
        b.a((com.alibaba.appmonitor.d.e) this);
    }

    public final void c() {
        af.b();
        i.a();
        this.d = i.a(this.d, this.g, f);
    }

    public final void d() {
        if (this.d != null && !this.d.isDone()) {
            this.d.cancel(true);
        }
    }

    public final long b() {
        return (long) this.e.incrementAndGet();
    }
}
