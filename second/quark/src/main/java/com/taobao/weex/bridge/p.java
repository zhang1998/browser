package com.taobao.weex.bridge;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ s b;

    p(s sVar, String str) {
        this.b = sVar;
        this.a = str;
    }

    public final void run() {
        this.b.a(this.a, this.b.n);
    }
}
