package com.ucweb.common.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.ucweb.common.util.d.c;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: ProGuard */
public class f {
    private static Runnable a = new g();
    private static Handler b;
    private static boolean c = false;
    private static int d = 1;
    private static int e;
    private static boolean f;
    private static boolean g = false;
    private static boolean h = true;
    private static HashMap<String, SimpleDateFormat> i = new HashMap();

    public static void a(long j) {
        j();
        b.postDelayed(a, j);
    }

    public static void a() {
        j();
        b.removeCallbacks(a);
    }

    private static void j() {
        if (b == null) {
            b = new e(f.class.getName(), m.a());
        }
    }

    public static void a(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(100);
        }
    }

    public static int b() {
        if (c) {
            return d;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new k());
            if (listFiles != null) {
                d = listFiles.length;
            }
        } catch (Throwable th) {
            c.a(th.toString());
        }
        if (d <= 0) {
            d = 1;
        }
        c = true;
        return d;
    }

    public static int b(Context context) {
        if (f) {
            return e;
        }
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            e = context.getResources().getDimensionPixelSize(((Integer) cls.getField("status_bar_height").get(cls.newInstance())).intValue());
            f = true;
        } catch (Exception e) {
            e = d(context);
            f = true;
            c.a(e.toString());
        }
        return e;
    }

    private static int d(Context context) {
        if (context != null) {
            try {
                return Math.round(context.getResources().getDisplayMetrics().density * 25.0f);
            } catch (Exception e) {
                c.a(e.toString());
            }
        }
        return 0;
    }

    public static boolean c() {
        if (g) {
            return h;
        }
        boolean z = Character.getNumericValue(VERSION.RELEASE.trim().charAt(0)) >= 4;
        int i = VERSION.SDK_INT;
        if (!z || i < 14) {
            h = false;
        } else if (i < 20) {
            Class cls = null;
            try {
                cls = Class.forName("android.view.DisplayList");
            } catch (Throwable th) {
            }
            if (cls == null) {
                h = false;
            }
        }
        g = true;
        return h;
    }

    public static boolean d() {
        if (VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static void a(Context context, LayoutParams layoutParams) {
        Object obj = null;
        if (layoutParams instanceof WindowManager.LayoutParams) {
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
            if (layoutParams2.type > 0 && layoutParams2.type <= 99) {
                layoutParams2.token = null;
            }
            if (layoutParams2.type == 2) {
                if ((context instanceof Activity) && (((Activity) context).getWindow().getAttributes().flags & 1024) != 1024) {
                    obj = 1;
                }
                if (obj == null) {
                    layoutParams2.flags &= -2049;
                    layoutParams2.flags |= 1024;
                    return;
                }
                layoutParams2.flags &= -1025;
                layoutParams2.flags |= 2048;
            }
        }
    }

    public static void a(Context context, View view) {
        if (context != null && view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static void c(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 1);
    }

    public static SimpleDateFormat a(String str) {
        if (!m.c()) {
            return new SimpleDateFormat(str, Locale.CHINA);
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) i.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
        i.put(str, simpleDateFormat);
        return simpleDateFormat;
    }

    public static boolean e() {
        return "Xiaomi".equals(Build.BRAND);
    }

    public static boolean f() {
        return a.d("smartisan", Build.BRAND);
    }

    public static boolean g() {
        return a.d("huawei", Build.BRAND) || a.d("honor", Build.BRAND);
    }

    public static boolean h() {
        return a("ro.miui.ui.version.name", "V5");
    }

    public static boolean i() {
        return a("ro.miui.ui.version.name", "V6", "V7", "V8");
    }

    private static boolean a(String str, String... strArr) {
        try {
            String a = c.a().a(str, "");
            for (String equalsIgnoreCase : strArr) {
                if (equalsIgnoreCase.equalsIgnoreCase(a)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
