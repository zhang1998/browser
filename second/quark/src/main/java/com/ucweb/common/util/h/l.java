package com.ucweb.common.util.h;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ h a;

    l(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        this.a.a.run();
        this.a.d.post(this.a.e);
    }
}
