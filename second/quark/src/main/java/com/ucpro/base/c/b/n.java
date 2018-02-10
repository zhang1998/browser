package com.ucpro.base.c.b;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ u a;

    n(u uVar) {
        this.a = uVar;
    }

    public final void run() {
        if (this.a.b.c != null) {
            this.a.b.c.setLayerType(0, null);
        }
        this.a.b.a();
        this.a.b.i.remove(this);
    }
}
