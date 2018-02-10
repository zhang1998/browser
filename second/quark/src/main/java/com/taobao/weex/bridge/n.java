package com.taobao.weex.bridge;

import java.util.Map;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ s b;

    n(s sVar, Map map) {
        this.b = sVar;
        this.a = map;
    }

    public final void run() {
        this.b.a(this.a, this.b.e);
    }
}
