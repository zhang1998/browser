package com.uc.apollo.android;

import android.os.Build;
import android.os.Build.VERSION;
import com.uc.apollo.android.privy.AndroidSystemProperties;
import com.uc.apollo.android.privy.a;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.impl.SettingsConst;

@KeepForRuntime
/* compiled from: ProGuard */
public class SystemProperties {
    private static a sSystemBuildProp;

    private static a getSystemBuildProp() {
        if (sSystemBuildProp == null) {
            synchronized (SystemProperties.class) {
                if (sSystemBuildProp == null) {
                    try {
                        sSystemBuildProp = new a();
                    } catch (Throwable th) {
                    }
                }
            }
        }
        return sSystemBuildProp;
    }

    public static String get(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return str2;
        }
        String str3 = AndroidSystemProperties.get(trim, null);
        if (str3 == null) {
            try {
                if (trim.equals("ro.build.id")) {
                    str3 = Build.ID;
                } else if (trim.equals("ro.build.display.id")) {
                    str3 = Build.DISPLAY;
                } else if (trim.equals("ro.product.name")) {
                    str3 = Build.PRODUCT;
                } else if (trim.equals("ro.product.device")) {
                    str3 = Build.DEVICE;
                } else if (trim.equals("ro.product.board")) {
                    str3 = Build.BOARD;
                } else if (trim.equals("ro.product.manufacturer")) {
                    str3 = Build.MANUFACTURER;
                } else if (trim.equals("ro.product.brand")) {
                    str3 = Build.BRAND;
                } else if (trim.equals("ro.product.model")) {
                    str3 = Build.MODEL;
                } else if (trim.equals("ro.hardware")) {
                    str3 = Build.HARDWARE;
                } else if (trim.equals("ro.serialno")) {
                    str3 = Build.SERIAL;
                } else if (trim.equals("ro.build.version.incremental")) {
                    str3 = VERSION.INCREMENTAL;
                } else if (trim.equals("ro.build.version.release")) {
                    str3 = VERSION.RELEASE;
                } else if (trim.equals("ro.build.version.sdk")) {
                    str3 = VERSION.SDK;
                } else if (trim.equals("ro.build.version.codename")) {
                    str3 = VERSION.CODENAME;
                } else if (trim.equals("ro.build.type")) {
                    str3 = Build.TYPE;
                } else if (trim.equals("ro.build.tags")) {
                    str3 = Build.TAGS;
                }
            } catch (Throwable th) {
            }
            if (str3 != null) {
                str3 = str3.trim();
            }
            if (str3 == null || str3.length() == 0) {
                a systemBuildProp = getSystemBuildProp();
                if (systemBuildProp != null) {
                    str3 = systemBuildProp.a(trim);
                }
            }
        }
        if (str3 == null || str3.length() == 0) {
            return str2;
        }
        return str3;
    }

    public static int get(String str, int i) {
        String str2 = get(str, null);
        if (str2 != null) {
            try {
                i = Integer.valueOf(str2).intValue();
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static boolean get(String str, boolean z) {
        String str2 = get(str, null);
        if (str2 == null) {
            return z;
        }
        str2 = str2.toLowerCase();
        return str2.equals(SettingsConst.TRUE) || str2.equals("y") || str2.equals("on") || str2.equals("yes") || str2.equals("true");
    }
}
