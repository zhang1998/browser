package com.ucpro.business.a.a;

import com.ucweb.common.util.d;
import com.ucweb.common.util.j.a;

/* compiled from: ProGuard */
public final class c {
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;

    public static boolean a() {
        return e() || c();
    }

    public static int b() {
        if (e()) {
            return 1;
        }
        if (c()) {
            return 2;
        }
        return 0;
    }

    private static boolean e() {
        if (a) {
            return b;
        }
        b = false;
        long b = a.b(d.a(), "EF56CBD4C21765A2", "741A34F18FDD73CF", 0);
        long b2 = a.b(d.a(), "EF56CBD4C21765A2", "A9BACB8AB50784F2", 0);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (a.b(d.a(), "EF56CBD4C21765A2", "7C720197557B1F90", true) && currentTimeMillis > b && currentTimeMillis < b2) {
            b = true;
        }
        a = true;
        return b;
    }

    public static boolean c() {
        if (c) {
            return d;
        }
        d = false;
        long b = a.b(d.a(), "CCB980D06D447B10", "B411CA4761F80005", 0);
        long b2 = a.b(d.a(), "CCB980D06D447B10", "3E5817A5ED67410E", 0);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (a.b(d.a(), "CCB980D06D447B10", "C6044F3BF55BFA78", true) && currentTimeMillis > b && currentTimeMillis < b2) {
            d = true;
        }
        c = true;
        return d;
    }

    public static void d() {
        a = false;
        b = false;
        c = false;
        d = false;
    }
}
