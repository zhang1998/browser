package com.taobao.weex;

import com.taobao.weex.common.g;
import com.taobao.weex.common.p;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class s implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ ac c;

    public s(ac acVar, int i, int i2) {
        this.c = acVar;
        this.a = i;
        this.b = i2;
    }

    public final void run() {
        if (this.c.b != null && this.c.d != null) {
            this.c.b.a(this.c);
            if (this.c.A != null) {
                p pVar = new p();
                pVar.H = g.WX_SUCCESS.z;
                pVar.J = this.c.h;
            }
            if (i.c()) {
                WXLogUtils.d(WXLogUtils.WEEX_PERF_TAG, this.c.s.toString());
            }
        }
    }
}
