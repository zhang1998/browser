package com.uc.weex.a;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ n b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ y e;

    p(y yVar, e eVar, n nVar, String str, int i) {
        this.e = yVar;
        this.a = eVar;
        this.b = nVar;
        this.c = str;
        this.d = i;
    }

    public final void run() {
        this.a.a(this.b, this.c, this.d);
    }
}
