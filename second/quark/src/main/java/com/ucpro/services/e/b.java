package com.ucpro.services.e;

import com.ucpro.b.d.a;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ f a;

    b(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        if (a.c()) {
            boolean z = com.ucweb.common.util.g.a.b("com.tencent.mtt") || com.ucweb.common.util.g.a.b("com.UCMobile");
            com.ucweb.common.util.j.a.a(d.a(), "29076939917A5F78", "89DA0C8B436AFF56", z);
            m.a(2, this.a.e);
            com.ucpro.business.stat.m.a("clipboard", "clipboard_sb", "enable", String.valueOf(z));
        }
    }
}
