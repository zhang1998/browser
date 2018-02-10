package com.taobao.weex.c.b;

/* compiled from: ProGuard */
public final class o {
    public static boolean a(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            if (Float.isNaN(f) && Float.isNaN(f2)) {
                return true;
            }
            return false;
        } else if (Math.abs(f2 - f) >= 1.0E-5f) {
            return false;
        } else {
            return true;
        }
    }
}
