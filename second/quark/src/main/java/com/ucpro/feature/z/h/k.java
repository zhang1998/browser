package com.ucpro.feature.z.h;

import com.uc.webview.export.extension.UCCore;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.e.b;
import com.ucpro.feature.z.g.b.n;
import com.ucweb.common.util.i.f;
import com.ucweb.common.util.n.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class k {
    public static void a(String str, String str2, String str3) {
        Object obj;
        o.a(a.b.c);
        Map hashMap = new HashMap();
        hashMap.put("ev_lb", str);
        hashMap.put("content", str2);
        hashMap.put("url", str3);
        hashMap.put("hostname", a.a(str3) ? "" : f.c(str3));
        hashMap.put("is_incognito", String.valueOf(b.a.a));
        String str4 = "search_engine";
        if (a.c(UCCore.OPTION_LOAD_KERNEL_TYPE, str)) {
            obj = "";
        } else {
            obj = n.b.d().b;
        }
        hashMap.put(str4, obj);
        m.a(a.b, hashMap);
    }
}
