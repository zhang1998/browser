package com.taobao.weex.c.a;

import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.s;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class d extends a {
    private final String a;
    private final int b;
    private final e c;
    private String d;

    public d(e eVar, String str, int i) {
        this.a = str;
        this.b = i;
        this.c = eVar;
    }

    protected final ab a(com.taobao.weex.c.e eVar, ae aeVar) {
        ab b = eVar.b(this.a);
        if (b != null && (b instanceof bv)) {
            return a(eVar, aeVar, (bv) b);
        }
        if (b == null) {
            try {
                eVar.d().a("domModule", g.WX_ERR_DOM_ADDELEMENT, "Error parent ref: " + this.a);
            } catch (Throwable e) {
                WXLogUtils.e("[AddElementAction] exception: ", e);
            }
        } else if (!(b instanceof bv)) {
            s a = s.a();
            String a2 = eVar.a();
            String str = this.a;
            String str2 = aeVar.q;
            a.a("fireEvent", a2, str, "domErrorJSON", str2);
            a.a(a2);
        }
        return null;
    }

    protected final String a() {
        return "addDom";
    }

    protected final g b() {
        return g.WX_ERR_DOM_ADDELEMENT;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        a(eVar, this.c);
    }

    public final void a(q qVar) {
        ab a = qVar.a(this.d);
        ac a2 = qVar.a();
        if (a2 == null || a2.b() == null) {
            WXLogUtils.e("instance is null or instance is destroy!");
            return;
        }
        try {
            bv bvVar = (bv) qVar.a(this.a);
            if (bvVar != null && a != null) {
                bvVar.a(a, this.b);
                bvVar.g(this.b);
                a.applyLayoutAndEvent(a);
                a.bindData(a);
            }
        } catch (Throwable e) {
            WXLogUtils.e("add component failed.", e);
        }
    }

    protected final void b(com.taobao.weex.c.e eVar, ae aeVar) {
        this.d = aeVar.q;
        ae c = eVar.c(this.a);
        if (c == null) {
            eVar.d().a("domModule", g.WX_ERR_DOM_ADDELEMENT);
        } else {
            c.a(aeVar, this.b);
        }
    }
}
