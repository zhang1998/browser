package com.a.a.a;

import android.content.Context;
import android.provider.Settings.Secure;

/* compiled from: ProGuard */
public final class ba extends as {
    private Context d;

    public ba(Context context) {
        super("android_id");
        this.d = context;
    }

    public final String b() {
        String str = null;
        try {
            str = Secure.getString(this.d.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        return str;
    }
}
