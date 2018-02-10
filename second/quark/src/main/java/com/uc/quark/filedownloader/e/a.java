package com.uc.quark.filedownloader.e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
final class a implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final String b;
    private final ThreadGroup c = Thread.currentThread().getThreadGroup();
    private final AtomicInteger d = new AtomicInteger(1);

    a(String str) {
        this.b = b.j(str);
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.c, runnable, this.b + this.d.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
