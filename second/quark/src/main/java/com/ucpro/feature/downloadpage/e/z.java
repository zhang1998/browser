package com.ucpro.feature.downloadpage.e;

import com.quark.browser.R;
import com.uc.quark.n;
import com.uc.quark.x;
import com.ucpro.business.e.d.g;
import com.ucpro.business.stat.m;
import com.ucpro.feature.downloadpage.a.c;
import com.ucpro.services.download.b;
import com.ucpro.ui.b.e;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;
import com.ucweb.common.util.l.d;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class z implements l {
    final /* synthetic */ boolean a;
    final /* synthetic */ af b;

    z(af afVar, boolean z) {
        this.b = afVar;
        this.a = z;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == u.c) {
            int progress;
            long j;
            if (this.a) {
                c cVar = this.b.c;
                progress = cVar.z ? cVar.B.getProgress() : cVar.A;
            } else {
                progress = (com.ucpro.services.download.l.a(this.b.b.a) || com.ucpro.services.download.l.a(this.b.b.b)) ? this.b.b.f >= 32505856 ? g.a().a("download_baiduyun_threads", 21) : 0 : 0;
            }
            boolean a = b.a();
            af afVar = this.b;
            String k = this.b.c.k();
            String a2 = d.a(d.d(d.a(afVar.b.a, afVar.b.c, afVar.b.d)));
            n nVar = new n();
            nVar.a = afVar.b.a;
            nVar.d = k;
            nVar.b = afVar.b.b;
            nVar.k = afVar.b.i;
            if (a.a(a2)) {
                a2 = afVar.b.d;
            }
            nVar.c = a2;
            nVar.o = progress;
            if (afVar.b.f > 0) {
                j = afVar.b.f;
            } else {
                j = -1;
            }
            nVar.p = j;
            nVar.m = a;
            x.a().a(nVar.a()).k();
            af afVar2 = this.b;
            if (!b.a() || com.ucweb.common.util.i.c.d()) {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.task_downloading), com.ucpro.ui.c.a.d((int) R.string.click_to_see), new ai(afVar2));
            } else {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.download_add_task_not_wifi_tips), 1);
            }
            m.a("download", "c_e_toast", new String[0]);
        }
        return false;
    }
}
