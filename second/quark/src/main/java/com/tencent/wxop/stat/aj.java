package com.tencent.wxop.stat;

import java.util.List;

final class aj implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ int b = 1;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ as e;

    aj(as asVar, List list, boolean z) {
        this.e = asVar;
        this.a = list;
        this.c = z;
        this.d = true;
    }

    public final void run() {
        this.e.a(this.a, this.b, this.c);
        if (this.d) {
            this.a.clear();
        }
    }
}
