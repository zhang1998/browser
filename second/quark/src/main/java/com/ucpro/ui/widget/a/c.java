package com.ucpro.ui.widget.a;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: ProGuard */
public final class c {
    static final t a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new p();
        } else if (VERSION.SDK_INT >= 9) {
            a = new h();
        } else {
            a = new b();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }
}
