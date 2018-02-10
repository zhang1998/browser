package com.ucpro.feature.i;

import android.app.Activity;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.ucweb.common.util.b.a;
import com.ucweb.common.util.d.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class e {
    private static int a = 1000;
    private static boolean b;

    public static int a(Activity activity) {
        return f(activity);
    }

    private static boolean d(Activity activity) {
        if (!(activity == null || activity.getWindow() == null)) {
            try {
                LayoutParams attributes = activity.getWindow().getAttributes();
                Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField.getInt(null);
                declaredField2.getInt(attributes);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static boolean e(Activity activity) {
        if (!d.e() || d.a("7.7.13")) {
            return false;
        }
        if (!(activity == null || activity.getWindow() == null)) {
            try {
                Class cls = activity.getWindow().getClass();
                Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
                cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static int f(Activity activity) {
        boolean z = true;
        if (b) {
            return a;
        }
        b = true;
        a = 1000;
        if (VERSION.SDK_INT >= 19) {
            if (e(activity)) {
                a = 2;
            } else if (d(activity)) {
                a = 1;
            } else {
                String str = VERSION.RELEASE;
                String str2 = Build.BRAND;
                if (str == null || str2 == null) {
                    z = false;
                } else {
                    boolean z2;
                    if (str2.equalsIgnoreCase("Letv")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (Build.MANUFACTURER != null && Build.MANUFACTURER.equalsIgnoreCase("Letv")) {
                        z2 = true;
                    }
                    if (!z2 || 19 > VERSION.SDK_INT) {
                        z = false;
                    }
                }
                if (z) {
                    a = 3;
                } else if (!a()) {
                    if (VERSION.SDK_INT >= 23) {
                        a = 0;
                    } else if (VERSION.SDK_INT < 21 || d.g()) {
                        a = 5;
                    } else {
                        a = 4;
                    }
                }
            }
        }
        return a;
    }

    public static boolean a() {
        return Build.MODEL != null && Build.MODEL.startsWith("ZUK");
    }

    public static void b(Activity activity) {
        int f = f(activity);
        Window window = activity.getWindow();
        switch (f) {
            case 0:
                a(window, true);
                if (d.e()) {
                    d(window, true);
                    return;
                }
                return;
            case 1:
                c(window, true);
                return;
            case 2:
                d(window, true);
                return;
            case 3:
                b(window, true);
                return;
            default:
                return;
        }
    }

    private static void a(Window window, boolean z) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
            } else {
                systemUiVisibility &= -8193;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }

    public static void c(Activity activity) {
        int f = f(activity);
        Window window = activity.getWindow();
        switch (f) {
            case 0:
                a(window, false);
                if (d.e()) {
                    d(window, false);
                    return;
                }
                return;
            case 1:
                c(window, false);
                return;
            case 2:
                d(window, false);
                return;
            case 3:
                b(window, false);
                return;
            default:
                return;
        }
    }

    private static boolean b(Window window, boolean z) {
        if (window != null) {
            int i = z ? -16777216 : -1;
            try {
                a.a(window, "setStatusBarIconColor", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static boolean c(Window window, boolean z) {
        boolean z2 = false;
        if (window != null) {
            try {
                z2 = c.a(window, z);
            } catch (Exception e) {
            }
        }
        return z2;
    }

    private static boolean d(Window window, boolean z) {
        try {
            Class cls = window.getClass();
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            if (z) {
                method.invoke(window, new Object[]{Integer.valueOf(i | i2), Integer.valueOf(i2 | i)});
                return true;
            }
            method.invoke(window, new Object[]{Integer.valueOf(0), Integer.valueOf(i2)});
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
