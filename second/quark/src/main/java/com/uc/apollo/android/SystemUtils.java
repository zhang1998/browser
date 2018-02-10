package com.uc.apollo.android;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.e;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class SystemUtils {
    @KeepForRuntime
    public static void startActivity(Context context, Map<String, String> map) {
        Intent intent;
        String str;
        if (map.containsKey("action")) {
            intent = new Intent(e.a(context, (String) map.get("action")));
        } else {
            intent = new Intent();
        }
        if (map.containsKey("flags")) {
            str = (String) map.get("flags");
            if (str.startsWith("0x")) {
                intent.setFlags(Integer.parseInt(str.substring(2), 16));
            } else {
                intent.setFlags(Integer.parseInt(str));
            }
        }
        if (map.containsKey("pkgName") && map.containsKey("className")) {
            intent.setClassName((String) map.get("pkgName"), (String) map.get("className"));
        }
        if (map.containsKey("data")) {
            if (map.containsKey("dataType")) {
                intent.setDataAndType(Uri.parse(e.a(context, (String) map.get("data"))), e.a(context, (String) map.get("dataType")));
            } else {
                intent.setData(Uri.parse(e.a(context, (String) map.get("data"))));
            }
        }
        if (map.containsKey("category")) {
            intent.addCategory(e.a(context, (String) map.get("category")));
        }
        if (map.containsKey("extra")) {
            for (Entry entry : f.a((String) map.get("extra"), ",", "/").entrySet()) {
                String str2 = (String) entry.getKey();
                str = (String) entry.getValue();
                if (str2 != null) {
                    str2 = e.a(context, str2).trim();
                }
                if (str != null) {
                    str = e.a(context, str).trim();
                }
                if (e.b(str2) && e.b(str)) {
                    intent.putExtra(str2, str);
                }
            }
        }
        context.startActivity(intent);
    }

    @KeepForRuntime
    public static boolean contextHasPermision(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    @KeepForRuntime
    public static boolean findPermisionInAndroidManifest(Context context, String str) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
            if (packageInfo == null || packageInfo.requestedPermissions == null) {
                return false;
            }
            for (String str2 : packageInfo.requestedPermissions) {
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static Activity a(Context context) {
        if (context == null) {
            return a();
        }
        Context context2 = context;
        while (!(context2 instanceof Activity) && (context2 instanceof ContextWrapper)) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        return a();
    }

    private static Activity a() {
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object invoke2 : map.values()) {
                Class cls2 = invoke2.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(invoke2)) {
                    declaredField = cls2.getDeclaredField("activity");
                    declaredField.setAccessible(true);
                    return (Activity) declaredField.get(invoke2);
                }
            }
            return null;
        } catch (Throwable th) {
        }
    }
}
