package com.ucpro.feature.g.e;

import com.uc.sync.e.h;
import com.ucpro.feature.g.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class b {
    private static String a = "naviAnchor";

    public static b a() {
        return c.a;
    }

    public static void a(h hVar) {
        a.b(hVar);
    }

    public static void a(int i) {
        d.a().getSharedPreferences("__anchor", 0).edit().putInt(a, i).apply();
    }
}
