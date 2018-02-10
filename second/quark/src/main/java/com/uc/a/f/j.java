package com.uc.a.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: ProGuard */
public final class j {
    public SharedPreferences a;

    public j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "__dispatcher";
        }
        this.a = context.getSharedPreferences(str, 0);
    }

    public final String a(String str) {
        return this.a.getString(str, null);
    }
}
