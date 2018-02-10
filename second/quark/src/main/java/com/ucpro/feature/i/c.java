package com.ucpro.feature.i;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class c {
    private static Method a;
    private static Method b;
    private static Field c;
    private static int d;

    static {
        d = 0;
        try {
            a = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            b = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
        try {
            c = LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
        }
        try {
            d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (NoSuchFieldException e4) {
        } catch (IllegalAccessException e5) {
        }
    }

    private static boolean b(Window window, boolean z) {
        try {
            LayoutParams attributes = window.getAttributes();
            Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            if (z) {
                i |= i2;
            } else {
                i = (i ^ -1) & i2;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        } catch (IllegalAccessException e2) {
            return false;
        } catch (IllegalArgumentException e3) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(Window window) {
        LayoutParams attributes = window.getAttributes();
        if (c == null) {
            return false;
        }
        try {
            if (c.getInt(attributes) != 0) {
                c.set(attributes, Integer.valueOf(0));
                window.setAttributes(attributes);
            }
            return true;
        } catch (IllegalAccessException e) {
            return false;
        }
    }

    public static boolean a(Window window, boolean z) {
        if (VERSION.SDK_INT < 23) {
            return b(window, z);
        }
        View decorView = window.getDecorView();
        if (decorView == null) {
            return false;
        }
        int i;
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            i = d | systemUiVisibility;
        } else {
            i = (d ^ -1) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            decorView.setSystemUiVisibility(i);
        }
        return a(window);
    }
}
