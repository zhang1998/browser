package com.taobao.android.binding.core;

/* compiled from: ProGuard */
final class az implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ ba e;

    az(ba baVar, int i, int i2, int i3, int i4) {
        this.e = baVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final void run() {
        bb.a(this.e.c, this.e.a, this.e.b, this.a, this.b, this.c, this.d);
    }
}
