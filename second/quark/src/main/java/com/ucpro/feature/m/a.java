package com.ucpro.feature.m;

import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.m.a.b;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a {
    private boolean a;
    private boolean b;
    private com.ucweb.common.util.h.a c = new d(this);

    public final void a(int i, Object obj) {
        if (i == 0) {
            if (!this.a) {
                b b = ((e) obj).b();
                if (a(b)) {
                    m.a(0, new f(this));
                    return;
                }
                m.c(this.c);
                this.c.f = b;
                m.a(0, this.c, 200);
            }
        } else if (1 == i) {
            m.c(this.c);
            a(false);
            this.a = true;
        } else if (2 == i) {
            this.a = false;
            if (com.ucweb.common.util.j.a.b(d.a(), "BB9F59B299184BB2", "EDCC21A017409575", false)) {
                int a = com.ucpro.model.a.a.a.a("setting_crash_recovery_type", 0);
                if (a == 1) {
                    String d = com.ucpro.ui.c.a.d((int) R.string.crash_recovery_banner_content);
                    g gVar = new g(this);
                    g.a().a(e.P, new Object[]{d, gVar});
                    com.ucpro.business.stat.m.a("crash_recovery", "show_crash_recovery_dialog", new String[0]);
                } else if (a == 2) {
                    a();
                }
            }
        }
    }

    final void a() {
        if (!this.b) {
            this.b = true;
            m.a(0, new c(this));
        }
    }

    static void a(boolean z) {
        com.ucweb.common.util.j.a.a(d.a(), "BB9F59B299184BB2", "EDCC21A017409575", z);
    }

    static boolean a(b bVar) {
        if (bVar == null || bVar.a == null || bVar.a.size() <= 0) {
            return true;
        }
        return false;
    }

    public static b b() {
        try {
            b bVar = (b) com.uc.browser.b.a("crashrecovery", "recovery_data", b.class);
            if (bVar == null) {
                return null;
            }
            ArrayList arrayList = bVar.b;
            b bVar2 = new b();
            try {
                bVar2.a = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    bVar2.a.add(((com.ucpro.feature.m.a.a) it.next()).b);
                }
                return bVar2;
            } catch (com.uc.browser.a e) {
                return bVar2;
            } catch (ArrayIndexOutOfBoundsException e2) {
                return bVar2;
            }
        } catch (com.uc.browser.a e3) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e4) {
            return null;
        }
    }
}
