package com.taobao.weex.c.a;

import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;

/* compiled from: ProGuard */
public final class s implements d, p {
    private final String a;

    public s(String str) {
        this.a = str;
    }

    public final void a(e eVar) {
        ac d = eVar.d();
        ae c = eVar.c(this.a);
        if (c != null) {
            ae aeVar = c.v;
            if (aeVar != null) {
                c.a(eVar.e());
                aeVar.b(c);
                eVar.a(this.a);
                eVar.a((p) this);
                if (d != null) {
                    d.a("domModule", g.WX_SUCCESS);
                }
            } else if (d != null) {
                d.a("domModule", g.WX_ERR_DOM_REMOVEELEMENT);
            }
        } else if (d != null) {
            d.a("domModule", g.WX_ERR_DOM_REMOVEELEMENT);
        }
    }

    public final void a(q qVar) {
        ab a = qVar.a(this.a);
        if (a != null && a.getParent() != null) {
            bv parent = a.getParent();
            a(qVar, a);
            parent.a(a, true);
            qVar.b(this.a);
        }
    }

    private void a(q qVar, ab abVar) {
        ab b = qVar.b(abVar.getDomObject().b_());
        if (b != null) {
            b.removeAllEvent();
            b.removeStickyStyle();
        }
        if (abVar instanceof bv) {
            bv bvVar = (bv) abVar;
            for (int j = bvVar.j() - 1; j >= 0; j--) {
                a(qVar, bvVar.h(j));
            }
        }
    }
}
