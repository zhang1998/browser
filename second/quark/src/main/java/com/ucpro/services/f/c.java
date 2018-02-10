package com.ucpro.services.f;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ f b;

    c(f fVar, Object obj) {
        this.b = fVar;
        this.a = obj;
    }

    public final void run() {
        if (this.b.a.b != null) {
            this.b.a.b.a(this.a);
        }
    }
}
