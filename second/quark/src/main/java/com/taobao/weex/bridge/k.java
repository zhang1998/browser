package com.taobao.weex.bridge;

import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ l b;

    k(l lVar, long j) {
        this.b = lVar;
        this.a = j;
    }

    public final void run() {
        ac acVar = this.b.a;
        long j = this.a;
        if (j > 0) {
            acVar.s.j = j;
        }
    }
}
