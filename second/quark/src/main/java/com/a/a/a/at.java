package com.a.a.a;

import android.os.Build;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class at extends as {
    public at() {
        super("serial");
    }

    public final String b() {
        if (VERSION.SDK_INT >= 9) {
            return Build.SERIAL;
        }
        return null;
    }
}
