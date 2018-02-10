package com.ucpro.feature.downloadpage.e.c.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ e a;

    c(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        for (a a : this.a.a) {
            a.a(this.a.g, this.a.f);
        }
        this.a.b.postDelayed(this.a, 10000);
    }
}
