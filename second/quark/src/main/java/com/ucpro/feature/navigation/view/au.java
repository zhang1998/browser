package com.ucpro.feature.navigation.view;

/* compiled from: ProGuard */
final class au implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ k c;

    au(k kVar, l lVar, Runnable runnable) {
        this.c = kVar;
        this.a = lVar;
        this.b = runnable;
    }

    public final void run() {
        if (this.a.d != null) {
            this.a.d.setVisibility(0);
        }
        l lVar = this.a;
        aj ajVar = lVar.j;
        ajVar.a.remove(lVar.b);
        lVar.j.invalidate();
        this.c.b.a(this.a);
        if (this.b != null) {
            this.b.run();
        }
    }
}
