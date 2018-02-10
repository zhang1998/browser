package com.uc.webview.browser.shell;

import com.uc.webview.export.annotations.Api;
import java.util.HashMap;

@Api
/* compiled from: ProGuard */
public class Build {
    public static String CORE_TIME = a("180109141442", "");
    public static String CORE_VERSION = "3.7.43.2";
    public static String CPU_ARCH = "armv7-a";
    public static HashMap<String, Long> LIB_SIZE_MAP = new a();
    public static String TIME = a("180109141442", "");
    public static String TYPE = a("@WEBVIEW_SDK_TYPE@", "");
    public static String UCM_SUPPORT_SDK_MIN = "";
    public static String UCM_VERSION = a("", "");

    @Api
    /* compiled from: ProGuard */
    public class Version {
        public static int API_LEVEL = 10;
        public static int BUILD_SERIAL = Build.a("@WEBVIEW_SDK_BUILD_SERIAL@", 1);
        public static int MAJOR = Build.a("@WEBVIEW_SDK_MAJOR@", 2);
        public static int MINOR = Build.a("@WEBVIEW_SDK_MINOR@", 11);
        public static String NAME = (MAJOR + "." + MINOR + "." + BUILD_SERIAL + "." + PATCH);
        public static int PATCH = Build.a("@WEBVIEW_SDK_PATCH@", 0);
        public static String SUPPORT_SDK_MIN = "2.11.0.0";
    }

    static int a(String str, int i) {
        return str.startsWith("@") ? i : Integer.parseInt(str);
    }

    private static String a(String str, String str2) {
        return str.startsWith("@") ? str2 : str;
    }
}
