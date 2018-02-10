package com.taobao.weex;

import com.taobao.weex.common.g;
import com.taobao.weex.common.p;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class y implements Runnable {
    final /* synthetic */ g a;
    final /* synthetic */ String b;
    final /* synthetic */ ac c;

    y(ac acVar, g gVar, String str) {
        this.c = acVar;
        this.a = gVar;
        this.b = str;
    }

    public final void run() {
        if (!(this.c.c == null || this.a == g.WX_SUCCESS)) {
            this.c.c.a(this.c.e, this.a.z, this.a.a());
        }
        p pVar = new p();
        pVar.H = this.a.z;
        pVar.J = this.a.A;
        if (this.a != g.WX_SUCCESS) {
            pVar.I = this.a.a();
            if (i.c()) {
                WXLogUtils.d(pVar.toString());
            }
        }
    }
}
