package com.taobao.weex.bridge;

import java.util.List;

/* compiled from: ProGuard */
public final class o implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ s b;

    public o(s sVar, List list) {
        this.b = sVar;
        this.a = list;
    }

    public final void run() {
        this.b.a(this.a, this.b.e);
    }
}
