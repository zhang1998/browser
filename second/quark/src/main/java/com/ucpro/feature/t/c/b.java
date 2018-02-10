package com.ucpro.feature.t.c;

import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.t.d;

/* compiled from: ProGuard */
public final class b implements g {
    private l a = null;

    public b(l lVar) {
        this.a = lVar;
        lVar.setPresenter(this);
    }

    public final void a(int i) {
        switch (i) {
            case 30089:
                m.a("multiwindow", "cli_cre_n_b", new String[0]);
                o.a(d.b.c);
                m.a(d.b);
                g.a().b(e.E);
                return;
            case 30090:
                o.a(d.a.c);
                m.a(d.a);
                g.a().b(e.C, 1);
                return;
            default:
                return;
        }
    }

    public final void a() {
        g.a().b(e.F);
    }
}
