package com.alibaba.analytics.core.c;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b.e;
import com.alibaba.analytics.core.h.q;
import com.alibaba.fastjson.a;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b implements q {
    public static final g a = new g();
    private String b = null;

    public final void b(String str, String str2) {
        af.a(null, "key", str, "value", str2);
        if (!(str2 == null || str2.equalsIgnoreCase(this.b))) {
            Object hashMap = new HashMap();
            hashMap.put("value", str2);
            hashMap.put("arrival_time", Long.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("app_start_time", Long.valueOf(e.a().a));
            a.a(i.a(i.f, a.a(hashMap), Double.valueOf(1.0d)));
            af.a(null, "json", a.a(hashMap));
        }
        this.b = str2;
    }
}
