package com.alibaba.analytics.a;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.analytics.core.h.e;
import com.taobao.a.a.a;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class af {
    private static String a = "Analytics";
    private static String b = "Analytics.";
    private static boolean c = false;
    private static HashMap<String, Integer> d = new HashMap();
    private static File e = new File(Environment.getExternalStorageDirectory().getPath() + "/ut-analytics.txt");
    private static boolean f = false;

    static {
        d.put("V", Integer.valueOf(5));
        d.put("D", Integer.valueOf(4));
        d.put("I", Integer.valueOf(3));
        d.put("W", Integer.valueOf(2));
        d.put("E", Integer.valueOf(1));
        d.put("L", Integer.valueOf(0));
    }

    public static void a(boolean z) {
        f = z;
    }

    public static boolean a() {
        return f || SettingsConst.TRUE.equalsIgnoreCase(e.a().a("enablelog"));
    }

    private static boolean a(String str) {
        try {
            if (((Integer) d.get(str)).intValue() <= ((Integer) d.get(a.a("Analytics"))).intValue()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void b() {
        if (a.a() && a("D")) {
            a.a(d(), e(null, new Object[0]));
        } else if (a()) {
            d();
            e(null, new Object[0]);
        }
    }

    public static void c() {
        if (a.a() && a("E")) {
            a.d(d(), e(null, new Object[0]));
        } else if (a()) {
            Log.e(d(), e(null, new Object[0]));
        }
    }

    public static void a(String str, Map<String, String> map) {
        if (a.a() && a("D")) {
            a.a(d(), b(str, (Map) map));
        } else if (a()) {
            d();
            b(str, (Map) map);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a.a() && a("D")) {
            a.a(d(), e(str, objArr));
        } else if (a()) {
            try {
                String e = e(str, objArr);
                if (TextUtils.isEmpty(e) || e.length() <= 2048) {
                    d();
                    return;
                }
                int length = e.length();
                int i = 0;
                int i2 = 2048;
                while (true) {
                    d();
                    e.substring(i, i2);
                    i = i2 + 2048 > length ? length : i2 + 2048;
                    if (i2 != i) {
                        int i3 = i;
                        i = i2;
                        i2 = i3;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void b(String str, Object... objArr) {
        if (a.a() && a("I")) {
            a.b(d(), e(str, objArr));
        } else if (a()) {
            d();
            e(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (a.a() && a("W")) {
            a.c(d(), e(str, objArr));
        } else if (a()) {
            Log.w(d(), e(str, objArr));
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        if (a.a() && a("W")) {
            a.a(d(), e(str, objArr), th);
        } else if (a()) {
            Log.w(d(), e(str, objArr), th);
        }
    }

    public static void d(String str, Object... objArr) {
        if (a.a() && a("E")) {
            a.d(d(), e(str, objArr));
        } else if (a()) {
            Log.e(d(), e(str, objArr));
        }
    }

    public static void b(String str, Throwable th, Object... objArr) {
        if (a.a() && a("E")) {
            a.b(d(), e(str, objArr), th);
        } else if (a()) {
            Log.e(d(), e(str, objArr), th);
        }
    }

    private static String d() {
        String className;
        String str = b;
        if (TextUtils.isEmpty(str)) {
            str = a;
        }
        StackTraceElement e = e();
        String str2 = "";
        if (e != null) {
            className = e.getClassName();
            if (!TextUtils.isEmpty(className)) {
                str2 = className.substring(className.lastIndexOf(46) + 1);
            }
        }
        className = String.valueOf(Process.myPid());
        return str + str2 + "." + className + "." + (Thread.currentThread().getId());
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement e = e();
        String str2 = "";
        if (e != null) {
            str2 = e.getMethodName();
        }
        stringBuilder.append(String.format("[%s]", new Object[]{str2}));
        if (str != null) {
            stringBuilder.append(" ").append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (i + 1 < objArr.length) {
                stringBuilder.append(",");
                str2 = objArr[i];
                int i2 = i + 1;
                String str3 = objArr[i2];
                String str4 = "%s:%s";
                Object[] objArr2 = new Object[2];
                if (str2 == null) {
                    str2 = "";
                }
                objArr2[0] = str2;
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3;
                }
                objArr2[1] = str2;
                stringBuilder.append(String.format(str4, objArr2));
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                stringBuilder.append(",");
                stringBuilder.append(objArr[i]);
            }
        }
        return stringBuilder.toString();
    }

    private static String b(String str, Map<String, String> map) {
        if (str == null || map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement e = e();
        String str2 = "";
        if (e != null) {
            str2 = e.getMethodName();
        }
        stringBuilder.append(String.format("[%s]", new Object[]{str2}));
        if (str != null) {
            stringBuilder.append(" ").append(str);
        }
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(",");
            stringBuilder.append(((String) entry.getKey()) + " : " + ((String) entry.getValue()));
        }
        return stringBuilder.toString();
    }

    private static StackTraceElement e() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(af.class.getName())) {
                return stackTraceElement;
            }
        }
        return null;
    }
}
