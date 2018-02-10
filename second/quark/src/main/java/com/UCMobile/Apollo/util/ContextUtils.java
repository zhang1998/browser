package com.UCMobile.Apollo.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.UCMobile.Apollo.annotations.Keep;

/* compiled from: ProGuard */
public class ContextUtils {
    @Keep
    public static int getVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getApplicationInfo().packageName, 0).versionCode;
        } catch (Exception e) {
            return i;
        }
    }

    @Keep
    public static String getDataDir(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo.dataDir != null) {
            return fixLastSlash(applicationInfo.dataDir);
        }
        return "/data/data/" + applicationInfo.packageName + "/";
    }

    @Keep
    public static String fixLastSlash(String str) {
        String str2 = str == null ? "/" : str.trim() + "/";
        if (str2.length() <= 2 || str2.charAt(str2.length() - 2) != '/') {
            return str2;
        }
        return str2.substring(0, str2.length() - 1);
    }
}
