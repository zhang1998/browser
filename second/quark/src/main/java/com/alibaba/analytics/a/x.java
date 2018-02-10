package com.alibaba.analytics.a;

import java.util.concurrent.ThreadFactory;

/* compiled from: ProGuard */
final class x implements ThreadFactory {
    private int a;

    public x(int i) {
        this.a = i;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppMonitor:" + i.d.getAndIncrement());
        thread.setPriority(this.a);
        return thread;
    }
}
