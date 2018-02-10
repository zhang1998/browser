package com.ucpro.base.system;

import android.content.Context;
import android.os.Build.VERSION;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
final class g {
    private static g a = new g();
    private static Context b = null;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static final String[] g = new String[]{"M040", "M045"};
    private String h = null;

    public static g a() {
        return a;
    }

    public static String b() {
        int i = 0;
        String str = VERSION.RELEASE;
        if (str != null && str.length() > 0) {
            if (Character.getNumericValue(str.trim().charAt(0)) >= 4) {
                i = 1;
            }
            if (!(i == 0 || f.c())) {
                return "2.2.2";
            }
        }
        return str == null ? "" : str;
    }

    public static String c() {
        return null;
    }

    public static String d() {
        if (VERSION.SDK_INT < 14 || f.c()) {
            return String.valueOf(VERSION.SDK_INT);
        }
        return "8";
    }
}
