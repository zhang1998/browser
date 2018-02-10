package com.raizlabs.android.dbflow.config;

/* compiled from: ProGuard */
public class t {
    public static final String a = t.class.getSimpleName();
    private static s b = s.e;

    public static void a(s sVar, String str) {
        a(sVar, str, null);
    }

    public static void a(s sVar, String str, Throwable th) {
        a(sVar, a, str, th);
    }

    public static void a(Throwable th) {
        a(s.e, th);
    }

    public static void a(s sVar, Throwable th) {
        a(sVar, a, "", th);
    }

    private static void a(s sVar, String str, String str2, Throwable th) {
        Object obj;
        if (sVar.ordinal() >= b.ordinal()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            sVar.a(str, str2, th);
        }
    }
}
