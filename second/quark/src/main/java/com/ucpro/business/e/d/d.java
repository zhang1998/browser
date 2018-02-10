package com.ucpro.business.e.d;

import com.ucpro.business.c.a.e;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ g b;

    d(g gVar, e eVar) {
        this.b = gVar;
        this.a = eVar;
    }

    public final void run() {
        if (!this.b.b.a("us", "ucparam", this.a, true)) {
            c.a("save fail, UcparamFileExisted = " + this.b.d);
        }
        this.b.d = true;
    }
}
