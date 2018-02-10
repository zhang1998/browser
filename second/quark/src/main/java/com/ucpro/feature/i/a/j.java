package com.ucpro.feature.i.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.view.Window;

/* compiled from: ProGuard */
final class j {
    private static final b a;

    static {
        if (e.a()) {
            if (VERSION.SDK_INT >= 23) {
                a = new i();
            } else {
                a = new e();
            }
        } else if (VERSION.SDK_INT >= 23) {
            a = new a();
        } else if (Build.DISPLAY.startsWith("Flyme")) {
            a = new g();
        } else {
            a = new f();
        }
    }

    static void a(Window window, boolean z) {
        a.a(window, z);
    }
}
