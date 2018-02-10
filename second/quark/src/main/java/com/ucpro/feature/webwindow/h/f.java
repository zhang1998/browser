package com.ucpro.feature.webwindow.h;

import android.text.TextUtils;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.o;
import com.ucpro.feature.webwindow.az;
import com.ucpro.feature.webwindow.m;

/* compiled from: ProGuard */
public final class f implements a {
    public g a = null;
    public m b = null;
    public String c = null;
    private String d = null;
    private boolean e = false;
    private String f = null;

    public f(g gVar) {
        this.a = gVar;
        this.a.setPresenter(this);
    }

    public final void a() {
        com.ucpro.business.stat.m.a("web_address_bar", "cli_mul_b", new String[0]);
        o.a(az.a.c);
        com.ucpro.business.stat.m.a(az.a);
        g.a().b(e.B, 2);
    }

    public final void b() {
        com.ucpro.business.stat.m.a("web_address_bar", "lon_cli_mul_b", new String[0]);
        o.a(az.p.c);
        com.ucpro.business.stat.m.a(az.p);
        g.a().b(e.H, Boolean.TRUE);
    }

    public final void c() {
        com.ucpro.business.stat.m.a("web_address_bar", "cli_men_b", new String[0]);
        com.ucpro.business.stat.m.a(az.b);
        g.a().b(e.g, 1);
    }

    public final void d() {
        com.ucpro.business.stat.m.a("web_address_bar", "cli_url", new String[0]);
        if (this.e && this.c != null && this.c.contains(this.d)) {
            g.a().b(e.aq, this.f);
        } else {
            g.a().b(e.aq, this.c);
        }
    }

    public final void e() {
        com.ucpro.business.stat.m.a("web_address_bar", "cli_sto_b", new String[0]);
        com.ucpro.business.stat.m.b("web_address_bar_ut", "cli_sto_b", new String[0]);
        com.ucpro.business.stat.m.a(az.d);
        if (this.b != null) {
            this.b.f();
        }
    }

    public final void f() {
        com.ucpro.business.stat.m.a("web_address_bar", "cli_bac_b", new String[0]);
        o.a(az.e.c);
        com.ucpro.business.stat.m.a(az.e);
        if (this.b != null) {
            this.b.a();
        }
    }

    public final void g() {
        com.ucpro.business.stat.m.a("web_address_bar", "cli_hom_b", new String[0]);
        com.ucpro.business.stat.m.b("web_address_bar_ut", "cli_hom_b", new String[0]);
        o.a(az.c.c);
        com.ucpro.business.stat.m.a(az.c);
        g.a().b(e.q);
    }

    public final void h() {
        if (this.b != null) {
            this.b.b();
        }
    }

    public final void a(int i) {
        this.a.a(i);
    }

    public final void a(String str, boolean z, String str2) {
        Object obj;
        this.d = str;
        this.e = z;
        this.f = str2;
        com.ucweb.common.util.i.f.b(str);
        if (TextUtils.isEmpty(str) || str.startsWith("javascript") || str.equals("ext:lp:home")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return;
        }
        if (str.length() <= 6 || !str.startsWith("ext:a:")) {
            this.a.a(str);
        } else {
            this.a.a(str.substring(6));
        }
    }
}
