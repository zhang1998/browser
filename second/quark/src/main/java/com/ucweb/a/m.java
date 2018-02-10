package com.ucweb.a;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ r b;

    m(r rVar, s sVar) {
        this.b = rVar;
        this.a = sVar;
    }

    public final void run() {
        r.a(this.b, this.a);
    }
}
