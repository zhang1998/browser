package com.ucpro.feature.q;

import com.quark.browser.R;
import com.uc.p;
import com.uc.quark.s;
import com.ucpro.business.stat.m;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ e b;

    b(e eVar, s sVar) {
        this.b = eVar;
        this.a = sVar;
    }

    public final void run() {
        e.a().a(a.d((int) R.string.p2p_play_so_verifi), 0);
        if (p.a(e.b, d.a())) {
            if (this.b.a != null) {
                this.b.a.a();
            }
            m.a("p2p_video", "xigua_so_succ", new String[0]);
            return;
        }
        e.a().a(a.d((int) R.string.p2p_play_so_verifi_fail), 0);
    }
}
