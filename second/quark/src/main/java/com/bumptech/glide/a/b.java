package com.bumptech.glide.a;

import java.util.concurrent.ThreadFactory;

/* compiled from: ProGuard */
final class b implements ThreadFactory {
    private b() {
    }

    public final synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, "glide-disk-lru-cache-thread");
        thread.setPriority(1);
        return thread;
    }
}
