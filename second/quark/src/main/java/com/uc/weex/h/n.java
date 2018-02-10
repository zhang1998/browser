package com.uc.weex.h;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ o c;

    n(o oVar, String str, String str2) {
        this.c = oVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        this.c.b(this.a, this.b);
    }
}
