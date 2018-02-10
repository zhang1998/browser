package com.ucpro.base.weex;

import com.alibaba.fastjson.e;
import com.taobao.weex.utils.v;
import com.uc.base.jssdk.h;
import com.uc.base.jssdk.j;
import com.uc.base.jssdk.m;
import com.uc.base.jssdk.u;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class c implements m {
    final ConcurrentHashMap<String, com.taobao.weex.bridge.c> a = new ConcurrentHashMap();
    h b = u.a.a((m) this, hashCode());
    int c = 0;

    public final void a(String str, String str2, com.taobao.weex.bridge.c cVar) {
        new StringBuilder("onJsApiInvoke: method: ").append(str).append(" params: ").append(str2);
        com.ucweb.common.util.h.m.a(1, new j(this, str, cVar, str2));
    }

    static void a(com.taobao.weex.bridge.c cVar, Object obj, boolean z) {
        try {
            e eVar = new e();
            eVar.a("success", Boolean.valueOf(z));
            eVar.a("data", obj);
            cVar.a(v.a(eVar, false));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void a(Object obj, String str) {
    }

    public final String getCallerUrl() {
        return "http://stark.uc.cn";
    }

    public final void a(String str, int i, String str2) {
        new StringBuilder("sendCallback: callbackId: ").append(str).append(" status: ").append(i).append(" result: ").append(str2);
        com.taobao.weex.bridge.c cVar = (com.taobao.weex.bridge.c) this.a.get(str);
        if (i == j.a - 1) {
            a(cVar, (Object) str2, true);
        } else {
            a(cVar, (Object) str2, false);
        }
        this.a.remove(str);
    }
}
