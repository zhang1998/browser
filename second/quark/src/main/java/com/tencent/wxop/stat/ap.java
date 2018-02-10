package com.tencent.wxop.stat;

final class ap implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ as b;

    ap(as asVar, int i) {
        this.b = asVar;
        this.a = i;
    }

    public final void run() {
        as.a(this.b, this.a, true);
        as.a(this.b, this.a, false);
    }
}
