package com.alibaba.analytics.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.Process;
import com.alibaba.analytics.core.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class r {
    static Map<String, String> a = null;
    private static String b = "";

    public static String a() {
        return b.a().e();
    }

    public static String b() {
        return b.a().c;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String a(Context context, String str) {
        String str2 = null;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                if (resources != null) {
                    int identifier = resources.getIdentifier(str, "string", context.getPackageName());
                    if (identifier != 0) {
                        str2 = context.getString(identifier);
                    }
                }
            } catch (Throwable th) {
            }
        }
        return str2;
    }

    public static Map<String, String> c(Context context) {
        if (a != null) {
            return a;
        }
        if (context == null) {
            return null;
        }
        a = new HashMap();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("manufacture_config", 0);
            boolean z = sharedPreferences.getBoolean("preLoad", false);
            String string = sharedPreferences.getString("preLoad_VersionName", "");
            String string2 = sharedPreferences.getString("preLoad_Channel1", "");
            String string3 = sharedPreferences.getString("preLoad_Channel2", "");
            if (z) {
                a.put("preLoad", "true");
                a.put("preLoad_VersionName", string);
                a.put("preLoad_Channel1", string2);
                a.put("preLoad_Channel2", string3);
            }
        } catch (Exception e) {
        }
        return a;
    }

    public static String d(Context context) {
        Map c = c(context);
        if (c != null) {
            return (String) c.get("preLoad_Channel2");
        }
        return null;
    }
}
