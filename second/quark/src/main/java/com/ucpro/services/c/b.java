package com.ucpro.services.c;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;
    final /* synthetic */ e d;

    b(e eVar, d dVar, String str, Object obj) {
        this.d = eVar;
        this.a = dVar;
        this.b = str;
        this.c = obj;
    }

    public final void run() {
        this.a.a(this.b, this.d.a(this.b), this.c);
    }
}
