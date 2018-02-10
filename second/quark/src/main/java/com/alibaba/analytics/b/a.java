package com.alibaba.analytics.b;

/* compiled from: ProGuard */
public final class a {
    private static a a = null;
    private static String b = "6.4.2.4";

    private a() {
    }

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

    public static String b() {
        return b;
    }
}
