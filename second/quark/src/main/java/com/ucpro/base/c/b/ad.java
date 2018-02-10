package com.ucpro.base.c.b;

/* compiled from: ProGuard */
final class ad implements Runnable {
    final /* synthetic */ d a;

    ad(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.b.c != null) {
            this.a.b.c.setLayerType(0, null);
        }
        this.a.b.b();
        this.a.b.i.remove(this);
    }
}
