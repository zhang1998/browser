package com.taobao.weex.ui.a;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ k e;

    i(k kVar, int i, int i2, int i3, int i4) {
        this.e = kVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final void run() {
        this.e.a(this.a, this.b, this.c, this.d);
    }
}
