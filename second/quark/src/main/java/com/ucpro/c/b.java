package com.ucpro.c;

/* compiled from: ProGuard */
public final class b {
    private static int a;

    public static boolean a() {
        return a != e.a;
    }

    public static boolean b() {
        return a == e.b;
    }

    static {
        String str = "release";
        int i = e.b;
        if ("debug".equalsIgnoreCase(str)) {
            i = e.b;
        } else if ("release".equalsIgnoreCase(str)) {
            i = e.a;
        }
        a = i;
    }
}
