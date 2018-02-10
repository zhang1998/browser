package com.alibaba.analytics.core.b;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.a = System.currentTimeMillis();
        this.a.e.set(0);
        this.a.b.set(0);
    }
}
