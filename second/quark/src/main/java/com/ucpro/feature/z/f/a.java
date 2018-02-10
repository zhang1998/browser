package com.ucpro.feature.z.f;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class a {
    private static final String[] d = new String[]{"淘宝", "天气"};
    public boolean a;
    public boolean b;
    public boolean c;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String equalsIgnoreCase : d) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
