package com.ucpro.feature.webwindow.c;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class a {
    private static int a = 0;
    private static long b = 0;
    private static long c = 0;
    private static boolean d = true;
    private static String e;

    public static void a(String str) {
        if (!TextUtils.isEmpty(e) && TextUtils.equals(str, e)) {
            long currentTimeMillis = System.currentTimeMillis();
            b = currentTimeMillis;
            if (currentTimeMillis - c < 500) {
                a++;
            } else {
                a = 0;
            }
        }
        e = str;
    }

    public static void a() {
        c = System.currentTimeMillis();
    }

    public static boolean b() {
        return a >= 3 && d;
    }

    public static void c() {
        a = 0;
    }
}
