package com.taobao.weex.c.a;

import com.taobao.weex.ac;
import com.taobao.weex.c.q;
import com.taobao.weex.t;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class r extends b {
    public final void a(q qVar) {
        ac a = qVar.a();
        int i = this.a;
        int i2 = this.b;
        WXLogUtils.renderPerformanceLog("onRefreshSuccess", System.currentTimeMillis() - a.r);
        if (a.b != null && a.d != null) {
            ac.a(new t(a, i, i2));
        }
    }
}
