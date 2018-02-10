package com.uc.apollo.android;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.uc.apollo.android.GuideDialog.Factory;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.util.ReflectUtil;
import com.uc.apollo.util.e;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class SystemAlertWindowPermission {
    @KeepForSdk
    public static final String MATCH_STRING_CD_KEY = "crsp_mw_guide";
    private static boolean a;
    private static Factory b;
    private static b c;

    /* compiled from: ProGuard */
    final class a {
        static final boolean a;

        static {
            if (VERSION.SDK_INT >= 19 && VERSION.SDK_INT <= 24) {
                if (ReflectUtil.getMethod("android.widget.Toast$TN", "show", IBinder.class) == null) {
                    a = true;
                    return;
                }
            }
            a = false;
        }
    }

    /* compiled from: ProGuard */
    public interface b {
        String a(String str);
    }

    public static void a(b bVar) {
        c = bVar;
    }

    @KeepForSdk
    public static void setGuideDialogFactory(Factory factory) {
        b = factory;
    }

    private static GuideDialog a(Context context) {
        if (b == null) {
            return new com.uc.apollo.android.GuideDialog.a(context);
        }
        return b.create(context);
    }

    private static String[] b(String str) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > 0) {
                return trim.split("\\^\\^");
            }
        }
        return null;
    }

    @KeepForRuntime
    public static boolean checkPermission(Context context) {
        if (a) {
            return a;
        }
        String a;
        GuideDialog a2 = a(context);
        if (c != null) {
            a = c.a(MATCH_STRING_CD_KEY);
        } else {
            a = null;
        }
        return checkPermission(a2, b(a));
    }

    @KeepForSdk
    public static boolean checkPermission(Context context, String str) {
        if (a) {
            return a;
        }
        return checkPermission(a(context), b(str));
    }

    public static boolean a() {
        return a.a;
    }

    @KeepForSdk
    public static boolean checkPermission(GuideDialog guideDialog, String... strArr) {
        if (a) {
            return a;
        }
        if (SystemUtils.findPermisionInAndroidManifest(guideDialog.getContext(), "android.permission.SYSTEM_ALERT_WINDOW")) {
            boolean isOpAllowed = isOpAllowed(guideDialog.getContext());
            a = isOpAllowed;
            if (!isOpAllowed) {
                String findPropertiesMatchDevice = SystemPropertyMatcher.findPropertiesMatchDevice(strArr);
                if (findPropertiesMatchDevice == null) {
                    a = a.a;
                }
                if (!a) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        b(guideDialog, findPropertiesMatchDevice);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new d(guideDialog, findPropertiesMatchDevice));
                    }
                }
            }
        }
        return a;
    }

    private static Map<String, String> a(String str, String str2) {
        if (!e.a(str)) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            if (matcher.find()) {
                String trim = matcher.group(1).trim();
                if (e.b(trim)) {
                    return f.b(trim);
                }
            }
        }
        return null;
    }

    private static void a(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        if (!map.containsKey(str)) {
            if (map2 == null || map2 == map || !map2.containsKey(str)) {
                map.put(str, str2);
            } else {
                map.put(str, map2.get(str));
            }
        }
    }

    private static void b(GuideDialog guideDialog, String str) {
        Map map;
        Map a = a(str, "afterGuide\\s*:\\s*\\{(.*?)\\}");
        if (a != null) {
            map = a;
        } else {
            map = a("afterGuide\\s*:\\s*\\{(.*?)\\}", true);
        }
        Runnable runnable = null;
        if (!(map == null || map.size() == 0)) {
            String str2 = (String) map.get("type");
            if (str2 != null && str2.toLowerCase(Locale.getDefault()).equals("startactivity")) {
                runnable = new e(guideDialog, map);
            }
        }
        a = a("guide\\s*:\\s*\\{(.*?)\\}", true);
        map = a(str, "guide\\s*:\\s*\\{(.*?)\\}");
        if (map == null) {
            if (a != null) {
                map = a;
            } else {
                map = new HashMap();
            }
        }
        a(GuideDialog.TITLE, map, a, SystemAlertWindowPermissionGuideResource.sTitle);
        a(GuideDialog.MESSAGE, map, a, SystemAlertWindowPermissionGuideResource.sMessage);
        a(GuideDialog.NEGATIVE_BTN, map, a, SystemAlertWindowPermissionGuideResource.sCancel);
        if (runnable == null) {
            a(GuideDialog.POSITIVE_BTN, map, a, SystemAlertWindowPermissionGuideResource.sOK);
        } else {
            a(GuideDialog.POSITIVE_BTN, map, a, SystemAlertWindowPermissionGuideResource.sToSet);
        }
        for (Entry entry : map.entrySet()) {
            map.put(entry.getKey(), e.a(guideDialog.getContext(), (String) entry.getValue()));
        }
        guideDialog.show(map, runnable);
    }

    @TargetApi(19)
    private static boolean b(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (((Integer) AppOpsManager.class.getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName()})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    @KeepForRuntime
    private static boolean isOpAllowed(Context context) {
        if (VERSION.SDK_INT >= 23) {
            return ((Boolean) ReflectUtil.call(Boolean.TYPE, "android.provider.Settings", "canDrawOverlays", new Class[]{Context.class}, new Object[]{context})).booleanValue();
        } else if (VERSION.SDK_INT >= 19) {
            return b(context);
        } else {
            if (c.a == 1 && (134217728 & context.getApplicationInfo().flags) == 0) {
                return false;
            }
            return true;
        }
    }

    private static Map<String, String> a(String str, boolean z) {
        CharSequence findPropertiesMatchDevice;
        Matcher matcher;
        String trim;
        if (z) {
            findPropertiesMatchDevice = SystemPropertyMatcher.findPropertiesMatchDevice(SystemAlertWindowPermissionGuideResource.sCustomMatchStrings);
            if (!e.a(findPropertiesMatchDevice)) {
                matcher = Pattern.compile(str).matcher(findPropertiesMatchDevice);
                if (matcher.find()) {
                    trim = matcher.group(1).trim();
                    if (e.b(trim)) {
                        return f.b(trim);
                    }
                    return null;
                }
            }
        }
        findPropertiesMatchDevice = SystemPropertyMatcher.findPropertiesMatchDevice(SystemAlertWindowPermissionGuideResource.sDefaultMatchStrings);
        if (!e.a(findPropertiesMatchDevice)) {
            matcher = Pattern.compile(str).matcher(findPropertiesMatchDevice);
            if (matcher.find()) {
                trim = matcher.group(1).trim();
                if (e.b(trim)) {
                    return null;
                }
                return f.b(trim);
            }
        }
        trim = null;
        if (e.b(trim)) {
            return f.b(trim);
        }
        return null;
    }
}
