package com.ucweb.common.util.d;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: ProGuard */
public final class d {
    private static final String[] a = new String[]{"M040", "M045"};
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static String i;
    private static final String[] j = new String[]{"OPPO"};
    private static boolean k = true;
    private static b l = b.UNKNOWN;

    public static boolean a() {
        if (g) {
            return h;
        }
        if (Build.DISPLAY.contains("Flyme")) {
            String str = Build.MODEL;
            for (String equals : a) {
                if (equals.equals(str)) {
                    h = true;
                    break;
                }
            }
            if (!h) {
                try {
                    h = ((Boolean) Build.class.getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
                } catch (Exception e) {
                }
            }
        }
        g = true;
        return h;
    }

    public static boolean b() {
        return Build.MODEL.equals("OD103");
    }

    public static boolean c() {
        return Build.DISPLAY != null && Build.DISPLAY.contains("Flyme");
    }

    public static boolean d() {
        if (!b) {
            if (Build.DISPLAY.contains("Flyme")) {
                if (VERSION.SDK_INT == 16) {
                    c = true;
                } else if (VERSION.SDK_INT == 17) {
                    d = true;
                }
            }
            b = true;
        }
        return d;
    }

    public static boolean e() {
        try {
            if (Integer.valueOf(c.a().a("ro.miui.ui.version.name", "").toString().substring(1)).intValue() >= 6) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (i == null) {
            try {
                i = c.a().a("ro.build.version.incremental", "");
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(i)) {
            return false;
        }
        return a(i, str);
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        try {
            String str3 = "\\.";
            String[] split = str.replace("V", "").replace("v", "").split(str3);
            String[] split2 = str2.split(str3);
            if (split == null || split2 == null) {
                return false;
            }
            int intValue = Integer.valueOf(split[0].trim()).intValue();
            int intValue2 = Integer.valueOf(split[1].trim()).intValue();
            int intValue3 = Integer.valueOf(split[2].trim()).intValue();
            int intValue4 = Integer.valueOf(split2[0].trim()).intValue();
            int intValue5 = Integer.valueOf(split2[1].trim()).intValue();
            int intValue6 = Integer.valueOf(split2[2].trim()).intValue();
            if (intValue < intValue4) {
                return false;
            }
            if (intValue > intValue4) {
                return true;
            }
            if (intValue2 < intValue5) {
                return false;
            }
            if (intValue2 > intValue5) {
                return true;
            }
            if (intValue3 < intValue6) {
                return false;
            }
            if (intValue3 > intValue6) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static b f() {
        if (!k) {
            return l;
        }
        k = false;
        b a = b.a(Build.BRAND);
        l = a;
        return a;
    }

    public static boolean g() {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(Environment.getRootDirectory(), "build.prop");
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return properties.containsKey("ro.build.hw_emui_api_level");
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream2 = fileInputStream;
                th = th3;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return properties.containsKey("ro.build.hw_emui_api_level");
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return properties.containsKey("ro.build.hw_emui_api_level");
    }
}
