package com.taobao.weex.d;

import com.taobao.weex.common.s;
import java.util.Map;

/* compiled from: ProGuard */
final class f implements h {
    final /* synthetic */ String a;
    final /* synthetic */ j b;

    f(j jVar, String str) {
        this.b = jVar;
        this.a = str;
    }

    public final void a(s sVar, Map<String, String> map) {
        if (this.a != null && this.b.b != null) {
            Object obj;
            com.taobao.weex.bridge.s a = com.taobao.weex.bridge.s.a();
            String str = this.b.b.e;
            String str2 = this.a;
            if (sVar == null || sVar.b == null) {
                obj = "{}";
            } else {
                obj = j.a(sVar.b, map != null ? j.a((Map) map, "Content-Type") : "");
            }
            a.a(str, str2, obj, false);
        }
    }
}
