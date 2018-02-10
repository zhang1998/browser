package com.uc.weex.a;

import com.uc.weex.j.c;

/* compiled from: ProGuard */
public final class af {
    private static c a = c.a(b.a);
    private static c b = c.a(b.b);

    public static int a(String str, String str2) {
        c a = c.a(str);
        c a2 = c.a(str2);
        if (a == null) {
            return str2 == null ? 0 : -1;
        } else {
            return a.a(a2);
        }
    }

    public static boolean a(String str) {
        c a = c.a(str);
        if (a != null && b.a(a) <= 0 && a.a(a) >= 0) {
            return true;
        }
        return false;
    }
}
