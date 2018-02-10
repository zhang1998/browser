package com.ucpro.feature.i;

import android.app.Activity;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class d {
    private static boolean a = false;
    private static boolean b = false;
    private static final String[] c = new String[]{"GT-N7100", "GT-9300", "GT-I9300"};
    private g d;

    private static boolean a(Window window) {
        LayoutParams attributes = window.getAttributes();
        return (attributes == null || (attributes.flags & 512) == 0) ? false : true;
    }

    public final void b(Activity activity) {
        if (a(activity.getWindow())) {
            a(activity, true);
        }
    }

    final void c(Activity activity) {
        if (a(activity.getWindow())) {
            a(activity, false);
        }
    }

    private void a(Activity activity, boolean z) {
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        if (this.d == null) {
            this.d = new g();
        }
        decorView.removeCallbacks(this.d);
        if (z) {
            this.d.a = new WeakReference(activity);
            decorView.postDelayed(this.d, 500);
            return;
        }
        window.clearFlags(512);
    }

    public final void a(Activity activity) {
        if (!a) {
            a = true;
            String str = Build.MODEL;
            if (VERSION.SDK_INT == 16 && str != null && str.length() > 0) {
                for (String str2 : c) {
                    if (str2 != null && str2.equalsIgnoreCase(str.trim())) {
                        b = true;
                        break;
                    }
                }
            }
        }
        if (!b) {
            Window window = activity.getWindow();
            if (!a(window)) {
                window.addFlags(512);
            } else if (this.d != null) {
                window.getDecorView().removeCallbacks(this.d);
            }
        }
    }
}
