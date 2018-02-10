package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.uc.apollo.impl.SettingsConst;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: ProGuard */
public final class dx {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = null;

    public static String a(Context context) {
        try {
            return g(context);
        } catch (Throwable th) {
            return d;
        }
    }

    public static void a(String str) {
        b = str;
    }

    public static String b(Context context) {
        try {
            if (!"".equals(a)) {
                return a;
            }
            PackageManager packageManager = context.getPackageManager();
            a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return a;
        } catch (Throwable th) {
            es.a(th, "AppInfo", "getApplicationName");
        }
    }

    public static void b(String str) {
        e = str;
    }

    public static String c(Context context) {
        try {
            if (b != null && !"".equals(b)) {
                return b;
            }
            b = context.getApplicationContext().getPackageName();
            return b;
        } catch (Throwable th) {
            es.a(th, "AppInfo", "getPackageName");
        }
    }

    static void c(String str) {
        d = str;
    }

    public static String d(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return c == null ? "" : c;
        } catch (Throwable th) {
            es.a(th, "AppInfo", "getApplicationVersion");
        }
    }

    public static String e(Context context) {
        try {
            if (e != null && !"".equals(e)) {
                return e;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append(SettingsConst.FALSE);
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(":");
            }
            stringBuffer.append(packageInfo.packageName);
            String stringBuffer2 = stringBuffer.toString();
            e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            es.a(th, "AppInfo", "getSHA1AndPackage");
            return e;
        }
    }

    public static String f(Context context) {
        try {
            return g(context);
        } catch (Throwable th) {
            es.a(th, "AppInfo", "getKey");
            return d;
        }
    }

    private static String g(Context context) throws NameNotFoundException {
        if (d == null || d.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return d;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            d = string;
            if (string == null) {
                d = "";
            }
        }
        return d;
    }
}
