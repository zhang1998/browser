package com.ucpro.feature.w;

import com.ucpro.base.a.e;
import com.ucpro.business.e.d.g;
import com.ucpro.services.a.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (g.a().c("tips_dot_prizes_switch")) {
            boolean b = a.a.b("ECC3F137B865BDEDBB09172B0652773C");
            boolean b2 = a.a.b("56DB53DAD2D33272456868E88138FD31");
            if (b && b2) {
                com.ucpro.base.a.g.a().a(e.cr, Boolean.valueOf(true));
            } else if (!b) {
                String str = "";
                if (com.ucweb.common.util.n.a.b(str)) {
                    for (String d : str.split("\\|")) {
                        if (com.ucweb.common.util.n.a.d(d, com.ucpro.c.a.a())) {
                            a.a.a("ECC3F137B865BDEDBB09172B0652773C");
                            a.a.a("56DB53DAD2D33272456868E88138FD31");
                            break;
                        }
                    }
                    if (a.a.b("56DB53DAD2D33272456868E88138FD31")) {
                        com.ucpro.base.a.g.a().a(e.cr, Boolean.valueOf(true));
                    }
                }
            }
        }
    }
}
