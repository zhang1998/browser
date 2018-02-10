package com.taobao.weex;

import com.taobao.weex.common.g;

/* compiled from: ProGuard */
final class x implements Runnable {
    final /* synthetic */ g a;
    final /* synthetic */ String b;
    final /* synthetic */ ac c;

    x(ac acVar, g gVar, String str) {
        this.c = acVar;
        this.a = gVar;
        this.b = str;
    }

    public final void run() {
        if (this.c.c != null && this.a != g.WX_SUCCESS) {
            this.c.c.a(this.c.e, this.a.z, this.b);
        }
    }
}
