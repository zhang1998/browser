package com.tencent.wxop.stat;

import java.util.List;

final class ak implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c = true;
    final /* synthetic */ as d;

    ak(as asVar, List list, boolean z) {
        this.d = asVar;
        this.a = list;
        this.b = z;
    }

    public final void run() {
        this.d.a(this.a, this.b);
        if (this.c) {
            this.a.clear();
        }
    }
}
