package com.e.b.d;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b.f;
import com.alibaba.analytics.core.c.a;
import com.alibaba.analytics.core.c.g;
import com.alibaba.analytics.core.c.i;
import com.alibaba.analytics.core.h.t;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.b;
import java.util.Map;

/* compiled from: ProGuard */
public final class e implements c {
    private static e e = new e();
    public volatile boolean a = false;
    public b b = null;
    public Object c = new Object();
    public g d = new g();

    private e() {
    }

    public static e a() {
        return e;
    }

    public final void b(Map<String, String> map) {
        if (map != null) {
            try {
                int i;
                String str = (String) map.get(LogField.EVENTID.toString());
                if (a.a().a.contains(str)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    this.d.a(i.a(i.a, str, Double.valueOf(1.0d)));
                }
                if (!t.a().a(map)) {
                    af.c("log discard", "aLogMap", map);
                } else if (map != null) {
                    str = (String) map.get(LogField.EVENTID.toString());
                    if (!map.containsKey("_priority")) {
                        if ("2201".equalsIgnoreCase(str)) {
                            map.put("_priority", "4");
                        }
                        if ("2202".equalsIgnoreCase(str)) {
                            map.put("_priority", "6");
                        }
                    }
                    String str2 = "3";
                    if (map.containsKey("_priority")) {
                        str2 = (String) map.remove("_priority");
                    }
                    CharSequence a = f.a().a(str);
                    if (!TextUtils.isEmpty(a)) {
                        str2 = a;
                    }
                    if (map.containsKey("_sls")) {
                        map.remove("_sls");
                        i = 1;
                    } else {
                        i = 0;
                    }
                    b bVar = new b(str2, str, map);
                    if (i != 0) {
                        com.alibaba.analytics.core.f.f a2 = com.alibaba.analytics.core.f.f.a();
                        a2.a(bVar);
                        a2.b();
                        return;
                    }
                    com.alibaba.analytics.core.f.f.a().a(bVar);
                }
            } catch (Throwable th) {
                af.b(null, th, new Object[0]);
            }
        }
    }

    public final void a(Map<String, String> map) {
        if (map != null) {
            b(map);
        }
    }
}
