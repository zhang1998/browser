package com.taobao.weex.c.a;

import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.common.g;

/* compiled from: ProGuard */
abstract class b implements d, p {
    protected int a;
    protected int b;

    b() {
    }

    public void a(e eVar) {
        ae c = eVar.c("_root");
        this.b = (int) c.p();
        this.a = (int) c.o();
        eVar.a((p) this);
        ac d = eVar.d();
        if (d != null) {
            d.a("domModule", g.WX_SUCCESS);
        }
    }
}
