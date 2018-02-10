package com.ucpro.a;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class at {
    private static String a;
    private static final String b = null;

    public static String a() {
        return TextUtils.isEmpty(a) ? b : a;
    }

    public static void a(String str) {
        a = str;
    }
}
