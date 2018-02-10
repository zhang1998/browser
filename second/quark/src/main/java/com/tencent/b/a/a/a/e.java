package com.tencent.b.a.a.a;

import android.content.Context;
import android.provider.Settings.System;

public final class e extends f {
    public e(Context context) {
        super(context);
    }

    protected final void a(String str) {
        synchronized (this) {
            System.putString(this.a.getContentResolver(), h.c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    protected final boolean a() {
        return h.a(this.a, "android.permission.WRITE_SETTINGS");
    }

    protected final String b() {
        String string;
        synchronized (this) {
            string = System.getString(this.a.getContentResolver(), h.c("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }
}
