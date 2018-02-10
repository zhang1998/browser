package com.taobao.weex.c.a;

import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.c.d;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;

/* compiled from: ProGuard */
public final class u implements d, p {
    private final e a;
    private final String b;

    public u(String str, e eVar) {
        this.b = str;
        this.a = eVar;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        ac d = eVar.d();
        eVar.a((p) this);
        if (d != null) {
            d.a("domModule", g.WX_SUCCESS);
        }
    }

    public final void a(q qVar) {
        ab a = qVar.a(this.b);
        if (a != null) {
            com.taobao.weex.ui.component.p parentScroller = a.getParentScroller();
            if (parentScroller != null) {
                parentScroller.a(a, this.a);
            }
        }
    }
}
