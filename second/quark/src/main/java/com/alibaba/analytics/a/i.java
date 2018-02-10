package com.alibaba.analytics.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class i {
    public static i a;
    private static ScheduledExecutorService b;
    private static int c = 1;
    private static final AtomicInteger d = new AtomicInteger();

    private static synchronized ScheduledExecutorService c() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (i.class) {
            if (b == null) {
                b = Executors.newScheduledThreadPool(3, new x(c));
            }
            scheduledExecutorService = b;
        }
        return scheduledExecutorService;
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i();
            }
            iVar = a;
        }
        return iVar;
    }

    public static ScheduledFuture a(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (!(scheduledFuture == null || scheduledFuture.isDone())) {
            scheduledFuture.cancel(true);
        }
        return c().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture b(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (!(scheduledFuture == null || scheduledFuture.isDone())) {
            scheduledFuture.cancel(false);
        }
        return c().scheduleAtFixedRate(runnable, 1000, j, TimeUnit.MILLISECONDS);
    }

    public static void a(Runnable runnable) {
        try {
            c().submit(runnable);
        } catch (Throwable th) {
        }
    }
}
