package com.uc.weex.d.a;

import java.net.URL;

/* compiled from: ProGuard */
public final class a {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.indexOf("://") < 0) {
            str = "http://" + str;
        }
        try {
            return new URL(str).getHost();
        } catch (Throwable th) {
            return "";
        }
    }
}
