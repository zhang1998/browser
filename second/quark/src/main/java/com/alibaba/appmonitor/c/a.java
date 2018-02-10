package com.alibaba.appmonitor.c;

import com.alibaba.analytics.core.f.f;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.d.g;
import com.alibaba.appmonitor.e.c;
import com.alibaba.appmonitor.f.b;
import com.alibaba.appmonitor.f.e;
import com.alibaba.appmonitor.f.h;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class a {
    public static void a(UTDimensionValueSet uTDimensionValueSet, e eVar) {
        Integer b = uTDimensionValueSet.b();
        if (b != null) {
            h a = h.a(b.intValue());
            b bVar = (b) com.alibaba.appmonitor.e.b.a().a(b.class, new Object[0]);
            bVar.b = 6699;
            bVar.c = eVar.e;
            bVar.d = eVar.f;
            if (uTDimensionValueSet.a != null) {
                bVar.f.putAll(uTDimensionValueSet.a);
                bVar.f.remove("commitDay");
            }
            Object hashMap = new HashMap();
            hashMap.put("meta", g.a());
            hashMap.put("_event_id", b);
            com.alibaba.appmonitor.e.a aVar = (c) com.alibaba.appmonitor.e.b.a().a(c.class, new Object[0]);
            aVar.add(eVar.b());
            com.alibaba.appmonitor.e.b.a().a((com.alibaba.appmonitor.e.a) eVar);
            hashMap.put("data", aVar);
            bVar.f.put(a.g, com.alibaba.fastjson.a.a(hashMap));
            bVar.f.put(LogField.EVENTID.toString(), "6699");
            a(bVar);
            com.alibaba.appmonitor.e.b.a().a(aVar);
        }
    }

    public static void a(b bVar) {
        f.a().a(new com.alibaba.analytics.core.model.b(bVar.a, String.valueOf(bVar.b), bVar.c, bVar.d, bVar.e, bVar.f));
        com.alibaba.appmonitor.e.b.a().a((com.alibaba.appmonitor.e.a) bVar);
    }
}
