package com.taobao.weex;

import android.net.Uri;
import android.text.TextUtils;
import com.taobao.weex.a.i;
import com.taobao.weex.common.g;
import com.taobao.weex.common.p;
import com.taobao.weex.common.q;
import com.taobao.weex.common.s;
import com.taobao.weex.utils.WXLogUtils;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class ab implements i {
    ac a;
    final /* synthetic */ ac b;
    private String c;
    private Map<String, Object> d;
    private String e;
    private q f;
    private long g;

    private ab(ac acVar, String str, Map<String, Object> map, String str2, q qVar, long j) {
        this.b = acVar;
        this.c = str;
        this.d = map;
        this.e = str2;
        this.f = qVar;
        this.g = j;
    }

    public final void a() {
    }

    public final void a(int i, Map<String, List<String>> map) {
    }

    public final void a(int i) {
    }

    public final void a(s sVar) {
        long j = 0;
        this.b.s.u = System.currentTimeMillis() - this.g;
        if (sVar.e != null) {
            long longValue;
            Object obj = sVar.e.get("actualNetworkTime");
            this.b.s.x = obj instanceof Long ? ((Long) obj).longValue() : 0;
            WXLogUtils.renderPerformanceLog("actualNetworkTime", this.b.s.x);
            obj = sVar.e.get("pureNetworkTime");
            p b = this.b.s;
            if (obj instanceof Long) {
                longValue = ((Long) obj).longValue();
            } else {
                longValue = 0;
            }
            b.v = longValue;
            WXLogUtils.renderPerformanceLog("pureNetworkTime", this.b.s.v);
            obj = sVar.e.get("connectionType");
            this.b.s.K = obj instanceof String ? (String) obj : "";
            obj = sVar.e.get("packageSpendTime");
            b = this.b.s;
            if (obj instanceof Long) {
                longValue = ((Long) obj).longValue();
            } else {
                longValue = 0;
            }
            b.y = longValue;
            obj = sVar.e.get("syncTaskTime");
            p b2 = this.b.s;
            if (obj instanceof Long) {
                j = ((Long) obj).longValue();
            }
            b2.z = j;
            Object obj2 = sVar.e.get("requestType");
            this.b.s.L = obj2 instanceof String ? (String) obj2 : "";
            if ("network".equals(obj2) && this.b.A != null) {
                p pVar = new p();
                if (!TextUtils.isEmpty(this.b.h)) {
                    try {
                        pVar.J = Uri.parse(this.b.h).buildUpon().clearQuery().toString();
                    } catch (Exception e) {
                        pVar.J = this.c;
                    }
                }
                if (!"200".equals(sVar.a)) {
                    pVar.H = g.WX_ERR_JSBUNDLE_DOWNLOAD.z;
                    pVar.a(sVar.c);
                    pVar.a("|");
                    pVar.a(sVar.d);
                } else if (!"200".equals(sVar.a) || (sVar.b != null && sVar.b.length > 0)) {
                    pVar.H = g.WX_SUCCESS.z;
                } else {
                    pVar.H = g.WX_ERR_JSBUNDLE_DOWNLOAD.z;
                    pVar.a(sVar.a);
                    pVar.a("|template is null!");
                }
                if (this.b.A != null) {
                    this.b.b();
                }
            }
        }
        WXLogUtils.renderPerformanceLog("networkTime", this.b.s.u);
        if (sVar.b != null && TextUtils.equals("200", sVar.a)) {
            this.b.a(this.c, new String(sVar.b), this.d, this.e, this.f);
        } else if (TextUtils.equals("wx_user_intercept_error", sVar.a)) {
            WXLogUtils.d("user intercept");
            this.b.a("wx_user_intercept_error", sVar.d);
        } else {
            this.b.a("wx_network_error", sVar.d);
        }
    }
}
