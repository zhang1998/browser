package com.ucpro.b.a;

import java.util.Locale;

/* compiled from: ProGuard */
public final class a {
    public static boolean a() {
        String a = com.ucpro.c.a.a();
        return a.equals("36101") || a.equals("35927");
    }

    public static boolean b() {
        if (a() && !Locale.getDefault().getLanguage().startsWith("zh")) {
            return true;
        }
        return false;
    }
}
