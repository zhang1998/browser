package com.taobao.weex.c.a;

import android.util.Log;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.c.e;
import com.taobao.weex.c.q;
import com.taobao.weex.common.p;
import com.taobao.weex.common.w;
import com.taobao.weex.h;
import com.taobao.weex.i;
import com.taobao.weex.s;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class l extends b {
    public final void a(e eVar) {
        super.a(eVar);
        ac d = eVar.d();
        if (d != null) {
            h hVar = d.w;
            if (hVar != null) {
                ad.a().c.a(w.a(new k(this, hVar, d)), 0);
            }
        }
    }

    public final void a(q qVar) {
        ac a = qVar.a();
        if (a.p == com.taobao.weex.common.q.APPEND_ONCE) {
            a.j();
        }
        int i = this.a;
        int i2 = this.b;
        a.l();
        long currentTimeMillis = System.currentTimeMillis() - a.q;
        WXLogUtils.renderPerformanceLog("onRenderSuccess", currentTimeMillis);
        WXLogUtils.renderPerformanceLog("   invokeCreateInstance", a.s.j);
        WXLogUtils.renderPerformanceLog("   TotalCallNativeTime", a.s.m);
        WXLogUtils.renderPerformanceLog("       TotalJsonParseTime", a.s.p);
        WXLogUtils.renderPerformanceLog("   TotalBatchTime", a.s.o);
        WXLogUtils.renderPerformanceLog("       TotalCssLayoutTime", a.s.s);
        WXLogUtils.renderPerformanceLog("       TotalApplyUpdateTime", a.s.r);
        WXLogUtils.renderPerformanceLog("       TotalUpdateDomObjTime", a.s.q);
        a.s.t = (double) currentTimeMillis;
        if (((double) a.s.l) < 0.001d) {
            a.s.l = currentTimeMillis;
        }
        a.s.C = (long) ab.mComponentNum;
        if (i.c()) {
            WXLogUtils.d(WXLogUtils.WEEX_PERF_TAG, "mComponentNum:" + ab.mComponentNum);
        }
        ab.mComponentNum = 0;
        if (!(a.b == null || a.d == null)) {
            ac.a(new s(a, i, i2));
        }
        if (!i.c()) {
            String str = WXLogUtils.WEEX_PERF_TAG;
            p pVar = a.s;
            Log.e(str, "networkTime:" + pVar.u + " actualNetworkTime:" + pVar.x + " connectionType:" + pVar.K + " requestType:" + pVar.L + " firstViewCreateTime:" + pVar.k + " firstScreenRenderTime:" + pVar.l + " firstScreenJSFExecuteTime:" + pVar.n + " componentCount:" + pVar.C + " JSTemplateSize:" + pVar.h + " SDKInitTime:" + i.u + " totalTime:" + pVar.t + " JSLibVersion:" + pVar.D + " WXSDKVersion:" + pVar.E + " UCWXSDKVersion:" + pVar.F + " jsBundleVersion:" + pVar.c + " pageName:" + pVar.e + " useScroller:" + pVar.B);
        }
    }
}
