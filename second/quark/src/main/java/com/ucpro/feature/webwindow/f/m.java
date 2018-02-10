package com.ucpro.feature.webwindow.f;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    m(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    public final void run() {
        c.a(this.b, this.a);
    }
}
