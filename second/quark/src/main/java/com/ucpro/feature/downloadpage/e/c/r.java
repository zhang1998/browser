package com.ucpro.feature.downloadpage.e.c;

import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.base.system.b;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.i.c;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Object c;
    final /* synthetic */ n d;

    r(n nVar, s sVar, boolean z, Object obj) {
        this.d = nVar;
        this.a = sVar;
        this.b = z;
        this.c = obj;
    }

    public final void run() {
        if (this.a != null) {
            int e = this.a.e();
            if (e == -3) {
                if (b.a.c(this.a.h())) {
                    this.d.d.a(this.a.h(), this.a.i());
                    m.a("download", "click_open", new String[0]);
                    return;
                }
                this.d.d.b(this.a.a());
            } else if (this.b || e == 3 || e == 1) {
                x.a();
                if (x.e(this.a.a())) {
                    this.a.m();
                } else {
                    com.ucweb.common.util.h.m.a(2, new m(this));
                }
                m.a("download", "pause", new String[0]);
            } else {
                if (c.d()) {
                    this.a.b(com.ucpro.services.download.b.a());
                    this.a.k();
                } else {
                    com.ucweb.common.util.h.m.a(2, new a(this));
                }
                m.a("download", "continue", new String[0]);
            }
        }
    }
}
