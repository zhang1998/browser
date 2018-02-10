package com.alibaba.analytics.core.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

/* compiled from: ProGuard */
public final class a {
    String a = "";
    SharedPreferences b = null;
    Editor c = null;
    Context d = null;

    public a(Context context, String str) {
        this.a = str;
        this.d = context;
        if (context != null) {
            this.b = context.getSharedPreferences(str, 0);
        }
    }

    public final String a(String str) {
        if (this.b != null) {
            Object string = this.b.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return "";
    }

    public final void a(String str, String str2) {
        if (this.c == null && this.b != null) {
            this.c = this.b.edit();
        }
        if (this.c != null) {
            this.c.putString(str, str2);
        }
    }
}
