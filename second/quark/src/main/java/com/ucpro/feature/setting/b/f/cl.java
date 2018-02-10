package com.ucpro.feature.setting.b.f;

import com.ucpro.feature.setting.b.b.a;
import com.ucpro.feature.webwindow.f.c;
import com.ucpro.feature.webwindow.f.h;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class cl {
    public static a a(String str) {
        Map b = c.a().b(str);
        a aVar = new a(str + "注入", com.ucpro.feature.setting.b.a.a.b);
        if (!(b == null || b.isEmpty())) {
            for (Entry entry : b.entrySet()) {
                aVar.a(a((String) entry.getKey(), (List) entry.getValue()));
            }
        }
        return aVar;
    }

    private static a a(String str, List<h> list) {
        a aVar = new a(str + "注入", com.ucpro.feature.setting.b.a.a.b);
        if (!(list == null || list.isEmpty())) {
            for (h hVar : list) {
                aVar.a(new com.ucpro.feature.setting.b.b.c("SrcName: " + hVar.b + ", Priority: " + String.valueOf(hVar.a), com.ucpro.feature.setting.b.a.a.b, com.ucpro.feature.setting.b.a.c.c, new bb(hVar)));
            }
        }
        return aVar;
    }
}
