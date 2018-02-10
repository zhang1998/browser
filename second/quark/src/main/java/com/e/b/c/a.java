package com.e.b.c;

import com.alibaba.analytics.a.af;
import com.e.b.b;
import java.util.Map;

/* compiled from: ProGuard */
public final class a {
    private static a a = null;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public static void a(Map<String, String> map) {
        af.a("UTTeamWork", "", map.entrySet().toArray());
        b.a();
        b.a(map);
    }
}
