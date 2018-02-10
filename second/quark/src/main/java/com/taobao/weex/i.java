package com.taobao.weex;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.k;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class i {
    private static boolean A = true;
    private static Map<String, String> B = new HashMap();
    public static final String a = VERSION.RELEASE;
    public static final String b = Build.MODEL;
    public static String c = "0.15.2";
    public static String d = "0.13.60.1";
    public static Application e;
    public static Context f;
    public static a g;
    public static final String h;
    @Deprecated
    public static int i = 750;
    public static volatile boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "";
    public static boolean n = true;
    public static boolean o = false;
    public static String p = "";
    public static long q = 0;
    public static long r = 0;
    public static long s = 0;
    public static long t = 0;
    public static long u = 0;
    public static k v = k.DEBUG;
    public static boolean w = false;
    public static boolean x = true;
    public static boolean y = false;
    public static String z = "";

    static {
        String str;
        if (e == null) {
            str = "";
        } else {
            str = ((TelephonyManager) e.getSystemService("phone")).getDeviceId();
        }
        h = str;
    }

    public static Map<String, String> a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("os", "android");
        hashMap.put("appVersion", f());
        hashMap.put("devId", h);
        hashMap.put("sysVersion", a);
        hashMap.put("sysModel", b);
        hashMap.put("weexVersion", String.valueOf(d));
        hashMap.put("logLevel", v.h);
        try {
            B.put("scale", Float.toString(e.getResources().getDisplayMetrics().density));
        } catch (Throwable e) {
            WXLogUtils.e("WXEnvironment scale Exception: ", e);
        }
        hashMap.putAll(B);
        if (hashMap.get("appName") == null && e != null) {
            hashMap.put("appName", e.getPackageName());
        }
        return hashMap;
    }

    private static String f() {
        String str = "";
        try {
            return e.getPackageManager().getPackageInfo(e.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            WXLogUtils.e("WXEnvironment getAppVersionName Exception: ", e);
            return str;
        }
    }

    public static Map<String, String> b() {
        return B;
    }

    public static boolean c() {
        if (!A || e == null || w) {
            return false;
        }
        try {
            boolean z;
            if ((e.getApplicationInfo().flags & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            A = z;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean d() {
        return w;
    }

    public static Application e() {
        return e;
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        }
        return context.getCacheDir().getPath();
    }
}
