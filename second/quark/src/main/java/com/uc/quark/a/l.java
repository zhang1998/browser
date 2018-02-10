package com.uc.quark.a;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ f a;

    l(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        this.a.a.run();
        this.a.d.post(this.a.e);
    }
}
