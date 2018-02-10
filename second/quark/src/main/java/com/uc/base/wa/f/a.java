package com.uc.base.wa.f;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ Runnable a;

    a(Runnable runnable) {
        this.a = runnable;
    }

    public final void run() {
        e.a = System.currentTimeMillis();
        this.a.run();
        e.a = 0;
    }
}
