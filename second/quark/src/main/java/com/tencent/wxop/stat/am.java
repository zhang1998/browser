package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.d;

final class am implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ k b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ as e;

    am(as asVar, d dVar, k kVar, boolean z, boolean z2) {
        this.e = asVar;
        this.a = dVar;
        this.b = kVar;
        this.c = z;
        this.d = z2;
    }

    public final void run() {
        this.e.b(this.a, this.b, this.c, this.d);
    }
}
