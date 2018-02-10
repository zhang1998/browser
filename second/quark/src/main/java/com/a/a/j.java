package com.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.a.a.a.fi;

/* compiled from: ProGuard */
public final class j {
    private static String[] a = new String[2];

    public static String[] a(Context context) {
        if (!TextUtils.isEmpty(a[0]) && !TextUtils.isEmpty(a[1])) {
            return a;
        }
        if (context == null) {
            return null;
        }
        fi.a(context);
        SharedPreferences f = fi.f();
        String[] strArr = (f.getString("au_p", null) == null || f.getString("au_u", null) == null) ? null : new String[]{f.getString("au_p", null), f.getString("au_u", null)};
        if (strArr == null) {
            return null;
        }
        a[0] = strArr[0];
        a[1] = strArr[1];
        return a;
    }
}
