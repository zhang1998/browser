package com.taobao.weex.c.a;

import android.widget.ScrollView;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.q;
import com.taobao.weex.common.g;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
public final class j extends a {
    private final e a;

    public j(e eVar) {
        this.a = eVar;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        a(eVar, this.a);
    }

    protected final ab a(com.taobao.weex.c.e eVar, ae aeVar) {
        return a(eVar, aeVar, null);
    }

    protected final void b(com.taobao.weex.c.e eVar, ae aeVar) {
        String a = eVar.a();
        ae.a(aeVar, WXViewUtils.c((float) WXViewUtils.a(a), ad.a(a)), WXViewUtils.c((float) WXViewUtils.b(a), ad.a(a)));
    }

    protected final g b() {
        return g.WX_ERR_DOM_CREATEBODY;
    }

    protected final String a() {
        return "createBody";
    }

    public final void a(q qVar) {
        ab a = qVar.a("_root");
        ac a2 = qVar.a();
        if (a2 == null || a2.b() == null) {
            WXLogUtils.e("instance is null or instance is destroy!");
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a.createView();
            if (i.c()) {
                WXLogUtils.renderPerformanceLog("createView", System.currentTimeMillis() - currentTimeMillis);
            }
            currentTimeMillis = System.currentTimeMillis();
            a.applyLayoutAndEvent(a);
            a.bindData(a);
            if (i.c()) {
                WXLogUtils.renderPerformanceLog("bind", System.currentTimeMillis() - currentTimeMillis);
            }
            if (a instanceof be) {
                be beVar = (be) a;
                if (beVar.d() instanceof ScrollView) {
                    a2.t = (ScrollView) beVar.d();
                    if (a2.u != null) {
                        ((WXScrollView) a2.t).a(a2.u);
                    }
                }
            }
            a2.g = a;
            a2.f.addView(a.getHostView());
            a2.a(a2.f.getWidth(), a2.f.getHeight());
            if (a2.p != com.taobao.weex.common.q.APPEND_ONCE) {
                a2.j();
            }
            a2.a("domModule", g.WX_SUCCESS);
        } catch (Throwable e) {
            WXLogUtils.e("create body failed.", e);
        }
    }
}
