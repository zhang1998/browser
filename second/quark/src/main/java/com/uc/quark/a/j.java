package com.uc.quark.a;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class j {
    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("data:") == 0;
    }

    public static String b(String str) {
        if (a(str)) {
            return str.substring(5, str.indexOf(";"));
        }
        return "";
    }
}
