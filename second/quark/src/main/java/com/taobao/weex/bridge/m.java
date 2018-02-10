package com.taobao.weex.bridge;

/* compiled from: ProGuard */
public final class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ s b;

    public m(s sVar, String str) {
        this.b = sVar;
        this.a = str;
    }

    public final void run() {
        this.b.h.a(this.a);
        s.b(this.b, this.a);
    }
}
