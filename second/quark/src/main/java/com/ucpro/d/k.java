package com.ucpro.d;

import android.app.Activity;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.business.stat.i;
import com.ucpro.feature.webwindow.f.c;
import com.ucpro.feature.webwindow.f.l;
import com.ucpro.feature.z.g.b.n;
import com.ucpro.services.e.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class k implements Runnable {
    final /* synthetic */ Activity a;

    public k(Activity activity) {
        this.a = activity;
    }

    public final void run() {
        c a = c.a();
        new StringBuilder("mHasInit = ").append(String.valueOf(c.a));
        if (!c.a) {
            m.a(0, new l(a));
            c.a = true;
        }
        f.a().a(j.r, 0, null);
        m.a(0, e.a.f);
        com.ucpro.feature.u.c.d();
        m.a(0, new i(), 5000);
        m.a(0, new com.ucpro.feature.i.j(com.ucpro.feature.i.f.a), 1000);
        n nVar = n.b;
        n.a();
    }
}
