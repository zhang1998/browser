package com.ucpro.feature.webwindow.o;

import com.ucpro.b.d.a;
import com.ucpro.business.stat.d;
import com.ucpro.business.stat.m;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b {
    public static void a(boolean z, boolean z2) {
        boolean c = a.c();
        HashMap hashMap = new HashMap();
        hashMap.put("is_first_run", c ? "yes" : "no");
        hashMap.put("is_available", z ? "success" : "fail");
        m.a(d.FORCED, "core", z2 ? "pre_core_available" : "core_available", hashMap);
    }
}
