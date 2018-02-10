package com.uc.webview.export;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class Build {
    public static String CORE_TIME = a("180109141442", "");
    public static String CORE_VERSION = a("3.7.43.2", "");
    public static String CPU_ARCH = a("armeabi-v7a", "armv7-a");
    public static boolean IS_INTERNATIONAL_VERSION = false;
    public static int PACK_TYPE = a("@USE_KERNEL_TYPE@", 4);
    public static String SDK_BMODE = a("@WEBVIEW_SDK_BMODE@", "WWW");
    public static String SDK_BTYPE = a("@WEBVIEW_SDK_BTYPE@", "UC");
    public static String SDK_FR = a("@WEBVIEW_SDK_FR@", "android");
    public static String SDK_LANG = a("@WEBVIEW_SDK_LANG@", "zh-CN");
    public static String SDK_PRD = a("@WEBVIEW_SDK_PRD@", "uc_webview_pro");
    public static String SDK_PROFILE_ID = a("@WEBVIEW_SDK_PFID@", "");
    public static String SDK_SUBVER = a("@WEBVIEW_SDK_SUBVER@", "release");
    public static String TIME = a("180109141442", "");
    public static String TYPE = a("@WEBVIEW_SDK_TYPE@", "");
    public static String UCM_SUPPORT_SDK_MIN = "";
    public static String UCM_VERSION = a("", "");

    @Api
    /* compiled from: ProGuard */
    public class Version {
        public static int API_LEVEL = 11;
        public static int BUILD_SERIAL = Build.a("@WEBVIEW_SDK_BUILD_SERIAL@", 1);
        public static int MAJOR = Build.a("@WEBVIEW_SDK_MAJOR@", 2);
        public static int MINOR = Build.a("@WEBVIEW_SDK_MINOR@", 11);
        public static String NAME = (MAJOR + "." + MINOR + "." + BUILD_SERIAL + "." + PATCH);
        public static int PATCH = Build.a("@WEBVIEW_SDK_PATCH@", 0);
        public static String SUPPORT_U4_MIN = "2.11.0.0";
        public static String SUPPORT_UCM_MIN = "99999.99999.99999.99999";
    }

    static int a(String str, int i) {
        return str.startsWith("@") ? i : Integer.parseInt(str);
    }

    private static String a(String str, String str2) {
        return str.startsWith("@") ? str2 : str;
    }
}
