package com.UCMobile.Apollo.util;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class e {
    public static final int a;
    public static final String b = Build.DEVICE;
    public static final String c = Build.MANUFACTURER;
    public static final String d = Build.MODEL;
    private static final Pattern e = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern f = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern g = Pattern.compile("%([A-Fa-f0-9]{2})");

    static {
        int i = (VERSION.SDK_INT == 23 && VERSION.CODENAME.charAt(0) == 'N') ? 24 : VERSION.SDK_INT;
        a = i;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public static int a(long j) {
        return (int) (j >>> 32);
    }

    public static int b(long j) {
        return (int) j;
    }

    public static long a(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }
}
