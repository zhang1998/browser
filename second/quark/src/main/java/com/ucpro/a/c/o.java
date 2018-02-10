package com.ucpro.a.c;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ String b;
    final /* synthetic */ float c;

    o(d dVar, String str, float f) {
        this.a = dVar;
        this.b = str;
        this.c = f;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
