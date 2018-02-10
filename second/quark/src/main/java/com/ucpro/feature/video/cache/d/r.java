package com.ucpro.feature.video.cache.d;

/* compiled from: ProGuard */
public final class r implements v {
    private long a;

    public final void a(Runnable runnable) {
        this.a++;
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.a + ")");
        thread.start();
    }
}
