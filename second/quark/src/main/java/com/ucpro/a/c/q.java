package com.ucpro.a.c;

/* compiled from: ProGuard */
public final class q {
    public static float a(String str) {
        float f = 0.0f;
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                try {
                    f = Float.parseFloat(trim);
                } catch (Exception e) {
                }
            }
        }
        return f;
    }

    public static int a(String str, int i) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                try {
                    i = Integer.parseInt(trim, 10);
                } catch (Exception e) {
                }
            }
        }
        return i;
    }
}
