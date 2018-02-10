package com.ucpro.ui.widget.tablayout;

import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class z {
    static final f a = new ac();
    private static final l b;

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new n();
        } else {
            b = new s();
        }
    }

    static x a() {
        return a.a();
    }
}
