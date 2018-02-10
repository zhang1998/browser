package com.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.a.a.a.ey;
import com.a.a.a.fi;
import com.a.a.a.fw;

/* compiled from: ProGuard */
public final class b {
    public static String a = null;
    public static String b = null;
    public static String c = "";
    public static String d = "";
    public static boolean e = true;
    public static boolean f = true;
    public static long g = 30000;
    public static boolean h = false;
    public static int i;
    static double[] j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static int n = 0;

    public static void a(Context context, String str) {
        if (context == null) {
            k = str;
            return;
        }
        String l = ey.l(context);
        if (TextUtils.isEmpty(l)) {
            fi.a(context);
            Object a = fi.a();
            if (TextUtils.isEmpty(a)) {
                fi.a(context);
                fi.a(str);
            } else if (!a.equals(str)) {
                fw.c("Appkey和上次配置的不一致 ");
                fi.a(context);
                fi.a(str);
            }
            k = str;
            return;
        }
        k = l;
        if (!l.equals(str)) {
            fw.c("Appkey和AndroidManifest.xml中配置的不一致 ");
        }
    }

    public static void a(String str) {
        l = str;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(k)) {
            CharSequence l = ey.l(context);
            k = l;
            if (TextUtils.isEmpty(l)) {
                fi.a(context);
                k = fi.a();
            }
        }
        return k;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(l)) {
            l = ey.o(context);
        }
        return l;
    }

    public static double[] a() {
        return j;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(m)) {
            fi.a(context);
            m = fi.b();
        }
        return m;
    }

    public static void a(Context context, int i) {
        n = i;
        fi.a(context);
        fi.a(n);
    }

    public static int d(Context context) {
        if (n == 0) {
            fi.a(context);
            n = fi.c();
        }
        return n;
    }

    public static String b() {
        return "6.1.3";
    }
}
