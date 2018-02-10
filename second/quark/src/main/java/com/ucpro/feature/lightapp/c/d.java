package com.ucpro.feature.lightapp.c;

import com.ucpro.base.a.g;
import com.ucpro.base.c.b.a;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.lightapp.channelpage.e;
import com.ucpro.feature.lightapp.e.f;
import com.ucpro.feature.webwindow.az;

/* compiled from: ProGuard */
public final class d implements a, f {
    private c a = null;
    private a b;

    public d(c cVar, a aVar) {
        this.a = cVar;
        this.b = aVar;
        cVar.setPresenter(this);
    }

    public final void b(int i) {
        int i2 = 3;
        switch (i) {
            case 30029:
                if (!(this.b.a() instanceof f)) {
                    i2 = this.b.a() instanceof e ? 2 : 2;
                }
                g.a().b(com.ucpro.base.a.e.g, i2);
                m.a(com.ucpro.feature.lightapp.f.a.e);
                return;
            case 30039:
                m.a(com.ucpro.feature.lightapp.f.a.d);
                g.a().b(com.ucpro.base.a.e.B, 3);
                return;
            case 30040:
                g.a().b(com.ucpro.base.a.e.bL);
                return;
            default:
                return;
        }
    }

    public final void c(int i) {
        if (i == 30039) {
            g.a().b(com.ucpro.base.a.e.H, Boolean.TRUE);
            m.a("home_tool_bar", "lon_cli_mul_b", new String[0]);
            o.a(az.p.c);
            m.a(az.p);
        }
    }

    public final void a(int i) {
        this.a.setMultiWindowNum(i);
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final void a() {
        this.a.a();
    }

    public final void b(boolean z) {
        this.a.setAddNavBtnVisibility(z);
    }
}
