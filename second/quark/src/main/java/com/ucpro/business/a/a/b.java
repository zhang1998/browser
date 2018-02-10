package com.ucpro.business.a.a;

import com.ucweb.common.util.d;
import com.ucweb.common.util.j.a;

/* compiled from: ProGuard */
public final class b {
    private static boolean a = false;
    private static boolean b = false;
    private static long c = 0;
    private static long d = 0;
    private static boolean e = false;
    private static long f = 0;
    private static long g = 0;

    public static boolean a() {
        boolean z;
        if (!a) {
            b = a.b(d.a(), "75766F5CC857E09B", "enable", true);
            c = a.b(d.a(), "75766F5CC857E09B", "starttime", 1502632800000L);
            d = a.b(d.a(), "75766F5CC857E09B", "endtime", 1503331140000L);
            a = true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < c) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (currentTimeMillis > d) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || !b || r3) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        boolean z;
        if (!e) {
            f = a.b(d.a(), "75766F5CC857E09B", "startTime", 0);
            g = a.b(d.a(), "75766F5CC857E09B", "endTime", 0);
            e = true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < f) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (currentTimeMillis > g) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || r3) {
            return false;
        }
        return true;
    }

    public static void c() {
        a = false;
        e = false;
    }
}
