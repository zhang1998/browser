package com.alibaba.analytics.core.c;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    f(c cVar, String str, String str2) {
        this.c = cVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        c.a(this.b);
    }
}
