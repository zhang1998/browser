package com.uc.weex.a;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;
    final /* synthetic */ y c;

    r(y yVar, String str, e eVar) {
        this.c = yVar;
        this.a = str;
        this.b = eVar;
    }

    public final void run() {
        n nVar = (n) this.c.d.get(this.a);
        if (nVar != null) {
            this.c.a(this.b, nVar, y.a(nVar), ab.d);
        } else if (this.c.g == null) {
            this.c.a(this.b, new n(this.a), null, ab.d);
        } else {
            this.c.c.post(new t(this.c, this.a, this.b));
        }
    }
}
