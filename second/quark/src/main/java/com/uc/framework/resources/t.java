package com.uc.framework.resources;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: ProGuard */
public final class t {
    public static Context a;
    static Resources b;
    public static String c;

    static float a(int i) {
        float f = 0.0f;
        try {
            return (float) b.getDimensionPixelSize(i);
        } catch (Throwable th) {
            return f;
        }
    }

    static String b(int i) {
        String str = null;
        try {
            str = b.getString(i);
        } catch (Throwable th) {
        }
        return str;
    }
}
