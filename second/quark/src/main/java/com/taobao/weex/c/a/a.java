package com.taobao.weex.c.a;

import com.taobao.weex.c.ae;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.common.g;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.ac;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
abstract class a implements d, p {
    protected abstract ab a(e eVar, ae aeVar);

    protected abstract String a();

    protected abstract g b();

    protected abstract void b(e eVar, ae aeVar);

    a() {
    }

    protected final ab a(e eVar, ae aeVar, bv bvVar) {
        if (aeVar == null) {
            return null;
        }
        ab a = ac.a(eVar.d(), aeVar, bvVar);
        eVar.b(aeVar.q, a);
        if (!(a instanceof bv)) {
            return a;
        }
        bv bvVar2 = (bv) a;
        int u = aeVar.u();
        for (int i = 0; i < u; i++) {
            ae b = aeVar.b(i);
            if (b != null) {
                bvVar2.g(a(eVar, b, bvVar2));
            }
        }
        return a;
    }

    protected final void a(e eVar, com.alibaba.fastjson.e eVar2) {
        com.taobao.weex.ac d = eVar.d();
        if (d != null) {
            g b = b();
            if (eVar2 == null) {
                d.a("domModule", b);
            }
            ae a = ae.a(eVar2, d);
            if (a == null || eVar.c(a.q) != null) {
                if (i.c()) {
                    WXLogUtils.e("[DOMActionContextImpl] " + a() + " error,DOM object is null or already registered!!");
                }
                d.a("domModule", b);
                return;
            }
            b(eVar, a);
            a.a(eVar.b(), eVar.c());
            ab a2 = a(eVar, a);
            if (a2 != null) {
                eVar.a(a.q, a2);
                eVar.a((p) this);
                c(eVar, a);
                d.a("domModule", g.WX_SUCCESS);
            }
        }
    }

    private void c(e eVar, ae aeVar) {
        eVar.a(aeVar.q, aeVar.g());
        for (int i = 0; i < aeVar.u(); i++) {
            c(eVar, aeVar.b(i));
        }
    }
}
