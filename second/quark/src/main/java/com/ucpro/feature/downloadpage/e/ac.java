package com.ucpro.feature.downloadpage.e;

/* compiled from: ProGuard */
final class ac implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ah c;

    ac(ah ahVar, int i, boolean z) {
        this.c = ahVar;
        this.a = i;
        this.b = z;
    }

    public final void run() {
        this.c.c.b(this.a, this.b);
    }
}
