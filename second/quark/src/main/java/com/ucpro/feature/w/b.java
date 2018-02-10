package com.ucpro.feature.w;

import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public final class b {
    public static boolean a() {
        String str = "";
        if (!a.b(str)) {
            return false;
        }
        for (String d : str.split("\\|")) {
            if (a.d(d, com.ucpro.c.a.a())) {
                return true;
            }
        }
        return false;
    }
}
