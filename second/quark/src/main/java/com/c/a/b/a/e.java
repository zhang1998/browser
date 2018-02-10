package com.c.a.b.a;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ j a;
    private int b;
    private int c;

    private e(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        ((l) this.a.e).a(this.b, this.c);
    }

    static /* synthetic */ void a(e eVar, int i, int i2) {
        eVar.b = i;
        eVar.c = i2;
    }
}
