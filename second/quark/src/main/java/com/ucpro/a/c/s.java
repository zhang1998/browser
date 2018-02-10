package com.ucpro.a.c;

/* compiled from: ProGuard */
final class s implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;

    s(d dVar, String str, int i) {
        this.a = dVar;
        this.b = str;
        this.c = i;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
