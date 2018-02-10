package com.uc.base.a.a.a.b;

/* compiled from: ProGuard */
public final class a {
    public static boolean a = false;

    public static String a() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        if (a) {
            str = "http://10.20.34.122:9400";
        } else {
            str = "https://access.open.uc.cn";
        }
        return stringBuilder.append(str).append("/acs.access").toString();
    }
}
