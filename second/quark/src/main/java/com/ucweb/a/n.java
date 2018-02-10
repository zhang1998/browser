package com.ucweb.a;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ u a;
    final /* synthetic */ r b;

    n(r rVar, u uVar) {
        this.b = rVar;
        this.a = uVar;
    }

    public final void run() {
        if (this.b.a != null) {
            this.b.a.a(this.a, true);
        }
    }
}
