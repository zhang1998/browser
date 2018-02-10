package com.uc.apollo.media.base;

/* compiled from: ProGuard */
public final class g {
    private static int a = 1;

    public static int a() {
        int i = a;
        a += 2;
        if ((i & 1) == 0 || i == -1) {
            a = 1;
        }
        return i;
    }

    public static boolean a(int i) {
        return i == -1 || i == 0;
    }

    public static boolean b(int i) {
        return (i & 1) == 1;
    }
}
