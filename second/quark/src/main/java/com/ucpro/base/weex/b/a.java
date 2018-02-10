package com.ucpro.base.weex.b;

import com.ucpro.business.stat.m;
import com.ucpro.c.b;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class a {
    public static void a(String str, String str2, HashMap hashMap) {
        if (str != null && str2 != null) {
            if (b.b()) {
                new StringBuilder("category:").append(str).append(" eventId:").append(str2).append(" keyValue").append(hashMap);
            }
            m.a(str, str2, hashMap);
        }
    }
}
