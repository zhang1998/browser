package com.taobao.weex.c.a;

import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;

/* compiled from: ProGuard */
public final class q implements d, p {
    private final String a;
    private final String b;
    private final int c;
    private int d;

    public q(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i;
    }

    public final void a(e eVar) {
        ac d = eVar.d();
        ae c = eVar.c(this.a);
        ae c2 = eVar.c(this.b);
        if (c != null && c.v != null && c2 != null && !c2.f_()) {
            int i = this.c;
            if (c.v.equals(c2)) {
                if (c2.c(c) == i) {
                    return;
                }
                if (c.v.c(c) < i) {
                    i--;
                }
            }
            this.d = i;
            c.v.b(c);
            c2.a(c, this.d);
            eVar.a((p) this);
            if (d != null) {
                d.a("domModule", g.WX_SUCCESS);
            }
        } else if (d != null) {
            d.a("domModule", g.WX_ERR_DOM_MOVEELEMENT);
        }
    }

    public final void a(com.taobao.weex.c.q qVar) {
        ab a = qVar.a(this.a);
        ab a2 = qVar.a(this.b);
        if (a != null && a.getParent() != null && a2 != null && (a2 instanceof bv)) {
            a.getParent().a(a, false);
            ((bv) a2).a(a, this.d);
        }
    }
}
