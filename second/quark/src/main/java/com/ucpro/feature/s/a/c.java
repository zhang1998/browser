package com.ucpro.feature.s.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    c(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.b.d == null) {
            this.b.b.f();
        }
        this.b.b.d.a(this.a);
    }
}
