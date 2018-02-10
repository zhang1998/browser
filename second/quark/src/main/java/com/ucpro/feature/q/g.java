package com.ucpro.feature.q;

import android.content.Context;
import com.quark.browser.R;
import com.uc.b;
import com.uc.h;
import com.uc.k;
import com.uc.l;
import com.uc.m;
import com.uc.p;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    g(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void run() {
        this.b.c = this.a;
        if (p.a(this.a, this.b.b)) {
            e.a().a(this.b.b.getString(R.string.p2p_play_tips), 0);
        } else {
            e.a().a(String.format(this.b.b.getString(R.string.p2p_play_soloading_tips), new Object[]{""}), 0);
        }
        h eVar = new e(this.a);
        Context b = this.b.b;
        String str = this.a;
        Runnable dVar = new d(this);
        String b2 = eVar.b();
        if (p.a(str, b)) {
            l.a(b, str, b2, dVar);
        } else {
            com.uc.g kVar = new k(b, str, b2, dVar);
            m.a = b;
            for (b bVar : b.values()) {
                if (!bVar.a()) {
                    eVar.a().a(bVar.c, bVar.b, bVar.d, kVar.a());
                }
            }
        }
        com.ucpro.business.stat.m.a("p2p_video", "xigua_play", new String[0]);
    }
}
