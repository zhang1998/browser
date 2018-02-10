package com.ucpro.feature.webwindow.m;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("ext:a:")) {
            String substring = str.substring(6);
            int indexOf = substring.indexOf("market://");
            if (indexOf != -1) {
                substring = substring.substring(indexOf);
            }
            return substring;
        } else if (!str.startsWith("ext:as:")) {
            return str;
        } else {
            int indexOf2 = str.indexOf(":", 7);
            if (indexOf2 != -1) {
                str = str.substring(indexOf2 + 1);
            }
            indexOf2 = str.indexOf("market://");
            if (indexOf2 != -1) {
                return str.substring(indexOf2);
            }
            return str;
        }
    }
}
