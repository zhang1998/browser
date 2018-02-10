package com.f.a.b.a;

/* compiled from: ProGuard */
public final class c {
    public static boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int b(String str) {
        int i = 0;
        if (str.length() <= 0) {
            return 0;
        }
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i < toCharArray.length) {
            i2 = (i2 * 31) + toCharArray[i];
            i++;
        }
        return i2;
    }
}
