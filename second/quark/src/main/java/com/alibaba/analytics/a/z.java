package com.alibaba.analytics.a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: ProGuard */
public final class z {
    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ut_setting", 4);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, null);
        }
        return null;
    }
}
