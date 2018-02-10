package com.ucpro.a.c;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;

    f(d dVar, String str, boolean z) {
        this.a = dVar;
        this.b = str;
        this.c = z;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
