package com.taobao.weex;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ ac c;

    u(ac acVar, String str, String str2) {
        this.c = acVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        if (this.c.b != null && this.c.d != null) {
            this.c.b.a(this.c, this.a, this.b);
        }
    }
}
