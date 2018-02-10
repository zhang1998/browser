package com.ucpro.ui.b;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ e a;
    private b b;

    public c(e eVar, b bVar) {
        this.a = eVar;
        this.b = bVar;
    }

    public final void run() {
        if (this.a.g != null) {
            this.a.g();
        }
        if (this.b != null) {
            e.a(this.a, this.b);
        }
    }
}
