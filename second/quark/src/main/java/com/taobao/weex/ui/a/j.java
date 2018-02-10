package com.taobao.weex.ui.a;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ k c;

    j(k kVar, int i, int i2) {
        this.c = kVar;
        this.a = i;
        this.b = i2;
    }

    public final void run() {
        this.c.a.removeMessages(this.a, Integer.valueOf(this.b));
    }
}
