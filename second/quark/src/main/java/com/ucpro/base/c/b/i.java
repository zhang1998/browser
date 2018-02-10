package com.ucpro.base.c.b;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ q a;

    i(q qVar) {
        this.a = qVar;
    }

    public final void run() {
        this.a.b.a(this.a.p == p.b);
        if (this.a.c != null) {
            this.a.c.destroyDrawingCache();
            this.a.c = null;
        }
    }
}
