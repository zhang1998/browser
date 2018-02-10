package com.uc.apollo.media.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.util.Printer;
import com.UCMobile.Apollo.MediaPlayer;
import com.uc.apollo.Settings;
import com.uc.apollo.android.GuideDialog;
import com.uc.apollo.android.SystemProperties;
import com.uc.apollo.android.SystemUtils;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.DataSourceURI;
import com.uc.apollo.util.f;
import java.util.List;

@KeepForRuntime
/* compiled from: ProGuard */
public class SystemUtil {
    static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String TAG = (f.a + "SystemUtil");
    private static Printer sPrinter;

    /* compiled from: ProGuard */
    final class a {
        public static final String a;

        private static String a(Context context, PackageManager packageManager, Uri uri) {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(uri, "video/*");
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 32);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                SystemUtil.TAG;
                new StringBuilder("can't find video player activity for ").append(uri);
            } else {
                String str;
                String str2 = ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.targetActivity;
                if (f.a(str2)) {
                    str = ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name;
                } else {
                    str = str2;
                }
                if (f.b(str)) {
                    try {
                        if (str.equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name)) {
                            SystemUtil.TAG;
                        } else {
                            SystemUtil.TAG;
                            new StringBuilder("targetActivity ").append(str).append(", alias name ").append(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name);
                        }
                        Class.forName(str);
                        return ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name;
                    } catch (Exception e) {
                        Log.w(SystemUtil.TAG, "find video player activity exception " + e);
                    }
                }
            }
            return null;
        }

        static {
            String str;
            Context context = Settings.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                str = null;
            } else {
                str = a(context, packageManager, Uri.parse("player:///"));
                if (f.a(str)) {
                    str = a(context, packageManager, Uri.parse("file:///"));
                }
            }
            a = str;
        }
    }

    private static Printer getPrinter() {
        if (sPrinter == null) {
            sPrinter = new i();
        }
        return sPrinter;
    }

    public static boolean contextHasPermision(String str) {
        return SystemUtils.contextHasPermision(Settings.getContext(), str);
    }

    public static boolean findPermisionInAndroidManifest(String str) {
        return SystemUtils.findPermisionInAndroidManifest(Settings.getContext(), str);
    }

    public static String getMediaPlayerServiceClassName(String str) {
        Context context = Settings.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 4);
            if (packageInfo == null || packageInfo.services == null) {
                return null;
            }
            for (ServiceInfo serviceInfo : packageInfo.services) {
                if (serviceInfo.processName.endsWith(":MediaPlayerService")) {
                    if (serviceInfo.enabled) {
                        return serviceInfo.name;
                    }
                    Log.w(TAG, "svc \"" + serviceInfo.name + "\" had found, but it was disable!");
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void openVideoInFullscreen(int i, DataSource dataSource) {
        if (dataSource instanceof DataSourceURI) {
            DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
            openVideoInFullscreen(i, dataSourceURI.uri, dataSourceURI.pageUri, dataSourceURI.title);
        }
    }

    private static void openVideoInFullscreen(int i, Uri uri, String str, String str2) {
        if (f.a(a.a)) {
            Log.w(TAG, "openVideoInFullscreen - try to get video player activity name failure!");
            return;
        }
        try {
            Context context = Settings.getContext();
            new StringBuilder("openVideoInFullscreen - domID: ").append(i).append(", uri: ").append(uri).append(", pageUri: ").append(str).append(", title: ").append(str2).append(", package name: ").append(context.getPackageName()).append(", target activityName: ").append(a.a);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName(context.getPackageName(), a.a);
            intent.setFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
            intent.addFlags(67108864);
            intent.addFlags(65536);
            intent.setDataAndType(uri, "video/*");
            intent.putExtra("page_uri", str);
            intent.putExtra(GuideDialog.TITLE, str2);
            intent.putExtra("mediaplayer_id", Integer.toString(i));
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static boolean supportOpenVideoInFullscreen() {
        return f.b(a.a);
    }

    public static boolean isMIBrand() {
        return "Xiaomi".equals(Build.BRAND);
    }

    public static boolean isHuaweiBrand() {
        return equalsIgnoreCase("huawei", Build.BRAND) || equalsIgnoreCase("honor", Build.BRAND);
    }

    public static boolean isSmartisanBrand() {
        return equalsIgnoreCase("smartisan", Build.BRAND);
    }

    private static boolean equalsIgnoreCase(String str, String str2) {
        if (!(str == null || str2 == null || str.length() != str2.length())) {
            if (regionMatches(true, str, 0, str.length(), str2, 0, str2.length())) {
                return true;
            }
        }
        return false;
    }

    private static boolean regionMatches(boolean z, String str, int i, int i2, String str2, int i3, int i4) {
        if (i < 0 || i3 < 0 || i2 < 0 || i4 < 0 || i > i2 || i3 > i4 || i2 - i < i4 - i3) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char charAt = str.charAt(i);
            int i7 = i3 + 1;
            char charAt2 = str2.charAt(i3);
            if (charAt != charAt2) {
                if (!z) {
                    return false;
                }
                if (!(Character.toLowerCase(charAt) == charAt2 || Character.toUpperCase(charAt) == charAt2)) {
                    return false;
                }
            }
            i4 = i5;
            i3 = i7;
            i = i6;
        }
    }

    private static boolean checkSystemVersionName(String str, String... strArr) {
        String str2 = SystemProperties.get(str, "");
        for (String equalsIgnoreCase : strArr) {
            if (equalsIgnoreCase.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMiUIV5() {
        return checkSystemVersionName(KEY_MIUI_VERSION_NAME, "V5");
    }

    public static boolean isMiUIV6orAbove() {
        return checkSystemVersionName(KEY_MIUI_VERSION_NAME, "V6", "V7");
    }
}
