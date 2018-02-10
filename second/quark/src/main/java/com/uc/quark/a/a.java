package com.uc.quark.a;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ d a;

    a(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        m.h.post(new p(this));
    }
}
