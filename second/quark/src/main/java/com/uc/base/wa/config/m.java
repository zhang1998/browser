package com.uc.base.wa.config;

import android.content.SharedPreferences;
import com.uc.base.wa.a.c;

/* compiled from: ProGuard */
public final class m {
    static int a = 1000;
    static long b = 70;
    static long c = 1048576;
    static long d = 10485760;
    static int e = 10;
    static long f = 409600;
    static long g = 300000;
    static long h = 900000;
    static long i = 15000;
    static long j = 345600000;
    static boolean k = false;
    static int l = 4;
    static boolean m = false;

    public static j a(String str) {
        SharedPreferences sharedPreferences = null;
        if ("4758eab57875cdf40fe7d21ca8afb18d".equals(str) || "9d3c35ea6d0c139d63ecc5a397bbec5b".equals(str)) {
            if ("4758eab57875cdf40fe7d21ca8afb18d".equals(str)) {
                sharedPreferences = t();
            } else if ("9d3c35ea6d0c139d63ecc5a397bbec5b".equals(str)) {
                sharedPreferences = c.b().getSharedPreferences(str, 0);
            }
            return new k(sharedPreferences);
        } else if ("ffc1d42b1ca5e3db2657d00b91997f6a".equals(str)) {
            return new l(c.b().getSharedPreferences(str, 4));
        } else {
            return null;
        }
    }

    private static SharedPreferences t() {
        return c.b().getSharedPreferences("4758eab57875cdf40fe7d21ca8afb18d", 4);
    }

    public static long a() {
        return t().getLong("122C3B23421B8462733328528B7C8131", 102400);
    }

    public static void a(long j) {
        t().edit().putLong("122C3B23421B8462733328528B7C8131", j).commit();
    }

    public static long b() {
        return t().getLong("9887a472042261e3a03a02f200b8d530", 0);
    }

    public static void b(long j) {
        t().edit().putLong("9887a472042261e3a03a02f200b8d530", j).commit();
    }

    public static long c() {
        return t().getLong("3289F7C32C627DCE82E4B48F5A963DEA", 0);
    }

    public static void c(long j) {
        t().edit().putLong("3289F7C32C627DCE82E4B48F5A963DEA", j).commit();
    }

    public static long d() {
        return t().getLong("dea365a5ea6d1a73bc72e356ae0e8d4e", 0);
    }

    public static void d(long j) {
        t().edit().putLong("dea365a5ea6d1a73bc72e356ae0e8d4e", j).commit();
    }

    public static void e() {
        t().edit().remove("dea365a5ea6d1a73bc72e356ae0e8d4e").commit();
    }

    public static long f() {
        return t().getLong("c99112ffb90c118d52f8c65d4352dcf7", 0);
    }

    public static void e(long j) {
        t().edit().putLong("c99112ffb90c118d52f8c65d4352dcf7", j).commit();
    }

    public static void g() {
        t().edit().remove("c99112ffb90c118d52f8c65d4352dcf7").commit();
    }

    public static long h() {
        return (long) a;
    }

    public static long i() {
        return c;
    }

    public static long j() {
        return d;
    }

    public static int k() {
        return e;
    }

    public static long l() {
        return f;
    }

    public static long m() {
        return g;
    }

    public static long n() {
        return h;
    }

    public static long o() {
        return i;
    }

    public static long p() {
        return j;
    }

    public static int q() {
        return l;
    }

    public static void r() {
        m = false;
    }

    public static boolean s() {
        return m;
    }
}
