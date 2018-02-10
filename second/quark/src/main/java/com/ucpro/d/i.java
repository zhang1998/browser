package com.ucpro.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.uc.base.wa.x;
import com.uc.translate.j;
import com.uc.translate.n;
import com.ucpro.business.e.d.e;
import com.ucpro.business.e.d.f;
import com.ucpro.business.e.d.g;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.m.h;
import com.ucpro.feature.r.b.a;
import com.ucpro.feature.r.b.b;
import com.ucpro.patch.PatchService;
import com.ucweb.a.a.c;
import com.ucweb.common.util.d;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        boolean z = true;
        Activity activity = this.a.a;
        c.a(d.a(), new b(), new a(), com.ucweb.a.a.b.c, com.ucpro.c.b.b());
        j bVar = new com.ucpro.feature.v.a.b();
        n dVar = new com.ucpro.feature.v.a.d();
        com.uc.translate.i.a = bVar;
        com.uc.translate.i.b = dVar;
        com.ucpro.business.e.g.d.a().a(false);
        com.ucpro.business.e.a.a a = com.ucpro.business.e.a.a.a();
        if (com.ucpro.b.d.a.b.a().k != 2) {
            z = false;
        }
        a.a(z);
        e.a("fdf2");
        g a2 = g.a();
        synchronized (g.class) {
            if (a2.c) {
            } else {
                com.ucpro.business.e.d.i.a.a("test", new com.ucpro.business.e.d.a());
                com.ucpro.business.e.d.i.a.a("ad_block_rule_url", new f());
                a2.a.a.a(a2.b.a("us", "ucparam"));
                a2.c = true;
                for (Entry entry : a2.a.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    e a3 = a2.a(str);
                    if (a3 != null) {
                        a3.a(com.ucpro.business.e.d.j.LOAD_HARDCODE, str, str2);
                    }
                }
            }
        }
        e.a("fdf3");
        com.ucpro.business.e.a.a.a().a("js_inject", com.ucpro.feature.webwindow.f.c.a());
        e.a("fdf4");
        Context a4 = d.a();
        m.a("patch", "trig", new String[0]);
        x.a(4);
        m.a("patch", "triga", new String[0]);
        Intent intent = new Intent(a4, PatchService.class);
        intent.setPackage(a4.getPackageName());
        a4.startService(intent);
        e.a("fdf5");
        com.uc.base.wa.e eVar = new com.uc.base.wa.e();
        eVar.a(com.uc.base.wa.a.c.a().n());
        x.b("system", eVar, new String[0]);
        o.b("1010");
        e.a("fdf");
        h.a.a(2, activity);
        e.a("cr");
        e.e();
        e.a(d.a());
    }
}
