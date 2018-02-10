package com.ucweb.common.util.h;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        this.a.a.run();
        this.a.d.post(this.a.e);
    }
}
