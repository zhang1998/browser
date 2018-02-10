package com.ucweb.common.util.h;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ d a;

    i(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        m.i.post(new c(this));
    }
}
