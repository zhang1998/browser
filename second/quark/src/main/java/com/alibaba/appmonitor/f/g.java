package com.alibaba.appmonitor.f;

import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.b;
import com.alibaba.appmonitor.e.c;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ d b;

    g(d dVar, Map map) {
        this.b = dVar;
        this.a = map;
    }

    public final void run() {
        for (Entry entry : this.a.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            a aVar = (UTDimensionValueSet) entry.getKey();
            List<a> list = (List) entry.getValue();
            if (list.size() != 0) {
                Integer b = aVar.b();
                if (b != null) {
                    h a = h.a(b.intValue());
                    b bVar = (b) b.a().a(b.class, new Object[0]);
                    bVar.b = b.intValue();
                    if (aVar.a != null) {
                        bVar.f.putAll(aVar.a);
                        bVar.f.remove("commitDay");
                    }
                    Object hashMap = new HashMap();
                    hashMap.put("meta", com.alibaba.appmonitor.d.g.a());
                    a aVar2 = (c) b.a().a(c.class, new Object[0]);
                    int i = 0;
                    for (a aVar3 : list) {
                        aVar2.add(aVar3.b());
                        if (i == 0) {
                            stringBuilder.append(aVar3.e);
                            stringBuilder2.append(aVar3.f);
                        } else {
                            stringBuilder.append(",");
                            stringBuilder.append(aVar3.e);
                            stringBuilder2.append(",");
                            stringBuilder2.append(aVar3.f);
                        }
                        i++;
                        b.a().a(aVar3);
                    }
                    hashMap.put("data", aVar2);
                    bVar.f.put(a.g, com.alibaba.fastjson.a.a(hashMap));
                    String stringBuilder3 = stringBuilder.toString();
                    String stringBuilder4 = stringBuilder2.toString();
                    bVar.f.put(LogField.ARG1.toString(), stringBuilder3);
                    bVar.f.put(LogField.ARG2.toString(), stringBuilder4);
                    bVar.c = stringBuilder3;
                    bVar.d = stringBuilder4;
                    com.alibaba.appmonitor.c.a.a(bVar);
                    b.a().a(aVar2);
                }
            }
            b.a().a(aVar);
        }
    }
}
