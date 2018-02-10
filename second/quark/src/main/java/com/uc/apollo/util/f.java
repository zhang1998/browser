package com.uc.apollo.util;

import android.os.Looper;
import android.util.DisplayMetrics;
import com.uc.apollo.base.Config;
import com.uc.imagecodec.export.IPictureView;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class f {
    private static float a = IPictureView.DEFAULT_MIN_SCALE;
    private static int b = 1;
    private static int c = 1;
    private static int d = 50;

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void b() {
        a(a(), "must be in main thread!");
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw new RuntimeException(str);
        }
    }

    public static String a(int i) {
        return (i & 1) == 1 ? Integer.toString(i) : "0x" + Integer.toHexString(i).toUpperCase();
    }

    public static String b(int i) {
        return a(i, false);
    }

    public static String a(int i, boolean z) {
        if (i < 0) {
            return Integer.toString(i);
        }
        if (i == 0) {
            return z ? "00:00" : "00:00.000";
        } else {
            int i2 = i / 1000;
            int i3 = i2 % 60;
            int i4 = (i2 / 60) % 60;
            int i5 = i % 1000;
            if (i2 / 3600 != 0) {
                if (z) {
                    return String.format(Locale.getDefault(), "%d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
                }
                return String.format(Locale.getDefault(), "%d:%02d:%02d.%03d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5)});
            } else if (z) {
                return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
            } else {
                return String.format(Locale.getDefault(), "%02d:%02d.%03d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5)});
            }
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append((String) entry.getKey()).append(": ").append((String) entry.getValue()).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(String str) {
        return (str == null || str.length() == 0) ? false : true;
    }

    public static int c() {
        return b;
    }

    public static int d() {
        return c;
    }

    public static boolean e() {
        return Config.getContext().getResources().getConfiguration().orientation == 2;
    }

    public static int f() {
        return d;
    }

    public static void g() {
        DisplayMetrics displayMetrics = Config.getContext().getResources().getDisplayMetrics();
        a = displayMetrics.density;
        b = displayMetrics.widthPixels;
        c = displayMetrics.heightPixels;
        int identifier = Config.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            d = Config.getContext().getResources().getDimensionPixelSize(identifier);
        }
    }

    public static int c(int i) {
        return (int) ((((float) i) * a) + 0.5f);
    }
}
