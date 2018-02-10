package com.uc.apollo.android;

import android.os.Build.VERSION;
import com.uc.apollo.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Locale;

@KeepForSdk
/* compiled from: ProGuard */
public class SystemAlertWindowPermissionGuideResource {
    public static String sCancel = "取消";
    static final String[] sCustomMatchStrings;
    static final String[] sDefaultMatchStrings;
    public static String sMessage;
    public static String sOK = "好的";
    public static String sTitle = "小窗播放需要悬浮窗权限";
    public static String sToSet = "去设置";

    static {
        String str = VERSION.SDK_INT >= 23 ? "设置“允许在其他应用的上层显示”，若开关为打开状态，请关闭后再开一次" : (c.a == 2 || c.a == 3) ? "请到《手机管家 - 进入通知管理 - 悬浮窗管理》开启悬浮窗权限" : c.a == 4 ? "请到《i 管家 - 软件管理 - 悬浮窗管理》开启本应用悬浮窗权限" : "请到《系统设置 - 应用管理 - 权限管理》或者《系统设置 - 悬浮窗权限管理》或者《手机管家、安全管家等应用里面》开启悬浮窗权限";
        sMessage = str;
        String[] strArr = new String[1];
        if (VERSION.SDK_INT >= 23) {
            str = "* ## afterGuide: {type=startActivity, action=android.settings.action.MANAGE_OVERLAY_PERMISSION, data=package:$PkgName};";
        } else if (VERSION.SDK_INT >= 9) {
            str = "* ## afterGuide: {type=startActivity, action=android.settings.APPLICATION_DETAILS_SETTINGS, data=package:$PkgName};";
        } else {
            str = "* ## afterGuide: {type=startActivity, action=android.intent.action.VIEW, pkgName=com.android.settings, className=com.android.settings.InstalledAppDetails, extra=" + (VERSION.SDK_INT == 8 ? "pkg" : "com.android.settings.ApplicationPkgName") + "/$PkgName};";
        }
        strArr[0] = str;
        sDefaultMatchStrings = strArr;
        ArrayList arrayList = new ArrayList();
        if (c.a == 1) {
            String str2 = SystemProperties.get("ro.miui.ui.version.name", "");
            if (str2 != null) {
                str2 = str2.toLowerCase(Locale.getDefault());
                if (str2.matches("v8")) {
                    arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand == xiaomi && ro.miui.ui.version.name == v5 ## afterGuide: {type=startActivity, action=android.intent.action.MAIN, pkgName=com.android.settings, className=com.android.settings.applications.InstalledAppDetailsTop, data=package:$PkgName};");
                } else if (str2.matches("v[67]")) {
                    arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand == xiaomi && ro.miui.ui.version.name reg v[67] ## afterGuide: {type=startActivity, action=android.intent.action.MAIN, pkgName=com.android.settings, className=com.android.settings.applications.InstalledAppDetailsTop, data=package:$PkgName};");
                } else {
                    arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand == xiaomi ## guide: {message=设置“应用信息 -> 权限管理 -> 显示悬浮窗”}; afterGuide: {type=startActivity, action=miui.intent.action.APP_PERM_EDITOR, category=android.intent.category.DEFAULT, extra=extra_pkgname/$PkgName};");
                }
            }
        } else if (c.a == 2 || c.a == 3) {
            arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand reg huawei|honor ## guide: {message=设置“可在其它应用上层显示的应用 -> 在其他应用上层显示”}; ");
        } else if (c.a == 5) {
            if (VERSION.SDK_INT == 19) {
                arrayList.add("ro.build.version.sdk == 19 && ro.product.brand reg oppo ## afterGuide: {type=startActivity, action=com.color.safecenter, pkgName=com.color.safecenter, className=com.color.safecenter.permission.floatwindow.FloatWindowListActivity};");
            } else if (VERSION.SDK_INT >= 22) {
                arrayList.add("ro.build.version.sdk >= 22 && ro.product.brand reg oppo ## guide: {message=请在“手机管家 -> 权限隐私 -> 悬浮窗管理”启用本应用}; afterGuide: {type=startActivity, action=com.oppo.safe.permission.PermissionTopActivity, pkgName=com.coloros.safecenter, className=com.coloros.safecenter.permission.PermissionTopActivity};");
            } else if (VERSION.SDK_INT > 19) {
                arrayList.add("ro.build.version.sdk > 19 && ro.product.brand reg oppo ## afterGuide: {type=startActivity, action=com.color.safe, pkgName=com.color.safe, className=com.oppo.safe.permission.floatwindow.FloatWindowListActivity};");
            } else {
                arrayList.add("ro.build.version.sdk < 19 && ro.product.brand reg oppo ## afterGuide: {type=startActivity, action=com.color.safecenter, pkgName=com.color.safecenter, className=com.color.safecenter.sysfloatwindow.FloatWindowListActivity};");
            }
        } else if (c.a == 4) {
            arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand reg vivo ## afterGuide: {type=startActivity, action=com.iqoo.secure, pkgName=com.iqoo.secure, className=com.iqoo.secure.MainActivity};");
        } else if (c.a == 6) {
            arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand == smartisan ## afterGuide: {type=startActivity, action=com.smartisanos.security.action.SWITCHED_PERMISSIONS_NEW, extra=index/16};");
        } else if (c.a == 7) {
            arrayList.add("ro.build.version.sdk >= 8 && ro.product.brand == meizu ## guide: {message=设置“应用信息 -> 权限管理 -> 显示悬浮窗”}; afterGuide: {type=startActivity, action=com.meizu.safe.security.SHOW_APPSEC, category=android.intent.category.DEFAULT, extra=packageName/$PkgName};");
        }
        sCustomMatchStrings = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
