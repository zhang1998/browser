package com.ucpro.feature.n;

import android.os.Message;
import com.uc.framework.resources.aa;
import com.uc.framework.resources.b;
import com.uc.framework.resources.f;
import com.uc.framework.resources.r;
import com.uc.framework.resources.x;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;

/* compiled from: ProGuard */
public class a extends e {
    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.T == i) {
            r.a(this.b.getApplicationContext());
            r.d();
            r.b();
            f fVar = r.a().a;
            b.b = "zh-cn";
            fVar.d = false;
            x.a();
            aa.a();
            String str = "zh-cn";
            r.a().a.e = str;
            x.b(str);
            aa.a(str);
            com.uc.framework.resources.e.b(str);
            c(com.ucpro.model.a.a.a.a("setting_night_mode", false) ? "theme/night/" : e());
            d();
        } else if (com.ucpro.base.a.e.V == i) {
            a(e());
        } else if (com.ucpro.base.a.e.U == i) {
            a("theme/night/");
        } else if (com.ucpro.base.a.e.W == i) {
            a("theme/transparent/");
            b("theme/transparent/");
        } else if (com.ucpro.base.a.e.X == i) {
            a("theme/default/");
            b("theme/default/");
        }
    }

    private static void d() {
        g.a().b(com.ucpro.base.a.e.Y);
    }

    private static void a(String str) {
        c(str);
        d();
        com.ucpro.base.a.f.a().a(j.f, 0, null, false);
        com.ucweb.common.util.f.a(0);
    }

    private static void c(String str) {
        r.a().a.a(str);
    }

    public final void b(int i, Message message) {
        if (i == j.g) {
            if (com.ucpro.model.a.a.a.a("setting_night_mode", false)) {
                a("theme/night/");
            } else {
                a(e());
            }
        } else if (i == j.f) {
            if (com.ucpro.ui.b.e.c()) {
                com.ucpro.ui.b.e a = com.ucpro.ui.b.e.a();
                if (a.a != null) {
                    a.a.a();
                }
            }
            com.ucpro.feature.i.f.a.a(this.b, com.ucpro.ui.c.a.c("status_bar_color"));
        }
    }

    private String e() {
        return com.ucweb.common.util.j.a.b(this.b, "17559D239201FC83", "472A0366C15AD605", "theme/default/");
    }

    private void b(String str) {
        com.ucweb.common.util.j.a.a(this.b, "17559D239201FC83", "472A0366C15AD605", str);
    }
}
