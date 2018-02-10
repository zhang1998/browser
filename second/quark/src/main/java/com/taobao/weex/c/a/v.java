package com.taobao.weex.c.a;

import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.d;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;

/* compiled from: ProGuard */
public final class v implements d, p {
    private final String a;
    private final e b;

    public v(String str, e eVar) {
        this.a = str;
        this.b = eVar;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        ac d = eVar.d();
        ae c = eVar.c(this.a);
        if (c != null) {
            c.a(this.b);
            eVar.a((p) this);
            if (d != null) {
                d.a("domModule", g.WX_SUCCESS);
            }
        } else if (d != null) {
            d.a("domModule", g.WX_ERR_DOM_UPDATEATTRS);
        }
    }

    public final void a(q qVar) {
        ab a = qVar.a(this.a);
        if (a != null) {
            a.updateProperties(this.b);
        }
    }
}
