package com.ucpro.feature.navigation;

import android.text.TextUtils;
import android.view.View;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.o;
import com.ucpro.feature.navigation.b.h;
import com.ucpro.feature.navigation.b.q;
import com.ucpro.feature.navigation.view.ax;
import com.ucpro.feature.navigation.view.d;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public final class p implements k {
    final m a;
    q b;
    private final a c;

    public p(a aVar, m mVar) {
        this.c = aVar;
        this.a = mVar;
    }

    public final void a() {
        this.a.b();
    }

    public final void a(ax axVar) {
        if (this.b != null) {
            Object obj;
            this.b.a(axVar);
            ArrayList a = this.b.a();
            if (a != null) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    if (((ax) it.next()).b == 0) {
                        obj = null;
                        break;
                    }
                }
            }
            int i = 1;
            if (obj != null) {
                m.a(2, new c(this));
            }
        }
    }

    public final void a(ax axVar, int i) {
        if (this.b != null) {
            this.b.a(axVar, i);
        }
    }

    public final void b(ax axVar) {
        int i;
        Object ajVar;
        Object obj;
        String str;
        int i2 = 1;
        a aVar = this.c;
        if (aVar.f != null) {
            if (aVar.f.d) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                i = 1;
                if (i != 0) {
                    if (a.a(axVar)) {
                        ajVar = new aj();
                        if (axVar.d == null && axVar.d.contains("uc_wx_init_params")) {
                            ajVar.o = axVar.d;
                        } else {
                            obj = axVar.d;
                            if (!TextUtils.isEmpty(obj)) {
                                for (String equalsIgnoreCase : h.a()) {
                                    if (equalsIgnoreCase.equalsIgnoreCase(obj)) {
                                        break;
                                    }
                                }
                            }
                            i2 = 0;
                            if (i2 == 0) {
                                ajVar.o = "ext:a:" + f.k(axVar.d);
                            } else {
                                ajVar.o = f.k(axVar.d);
                            }
                        }
                        g.a().a(e.k, ajVar);
                    } else {
                        str = axVar.d;
                        if (aVar.e == null) {
                            aVar.e = new g();
                        }
                        g.a(str);
                    }
                    str = axVar.d;
                    Map hashMap = new HashMap();
                    hashMap.put("url", str);
                    com.ucpro.business.stat.m.a("navigation", "ck_widget", (HashMap) hashMap);
                    o.a(com.ucpro.feature.y.o.q.c);
                    com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.q, hashMap);
                } else if (axVar.b == 0 && !a.a(axVar)) {
                    com.ucpro.business.stat.m.a("navigation", "show_widget_editbox", new String[0]);
                    return;
                }
            }
        }
        i = 0;
        if (i != 0) {
            if (a.a(axVar)) {
                ajVar = new aj();
                if (axVar.d == null) {
                }
                obj = axVar.d;
                if (TextUtils.isEmpty(obj)) {
                    while (i < r6) {
                        if (equalsIgnoreCase.equalsIgnoreCase(obj)) {
                            break;
                        }
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    ajVar.o = f.k(axVar.d);
                } else {
                    ajVar.o = "ext:a:" + f.k(axVar.d);
                }
                g.a().a(e.k, ajVar);
            } else {
                str = axVar.d;
                if (aVar.e == null) {
                    aVar.e = new g();
                }
                g.a(str);
            }
            str = axVar.d;
            Map hashMap2 = new HashMap();
            hashMap2.put("url", str);
            com.ucpro.business.stat.m.a("navigation", "ck_widget", (HashMap) hashMap2);
            o.a(com.ucpro.feature.y.o.q.c);
            com.ucpro.business.stat.m.a(com.ucpro.feature.y.o.q, hashMap2);
        } else if (axVar.b == 0) {
        }
    }

    public final void a(View view) {
        com.ucpro.base.e.e eVar = this.c;
        Object dVar = new d(eVar.b);
        eVar.f = new f(eVar, dVar, eVar.d);
        dVar.setPresenter(eVar.f);
        f fVar = eVar.f;
        fVar.c.setEnableGesture(false);
        fVar.b.a(fVar.c.getNavigationView());
        fVar.a.a.b().a((View) fVar.b);
        fVar.a.c.a.a(view);
    }
}
