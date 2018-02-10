package com.ucpro.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.c.b;
import com.ucpro.c.f;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class a {
    private static a a = new a();
    private static Map<String, String> b = new HashMap();
    private static boolean c;
    private static String d;

    static {
        b.put(SettingKeys.UBISn, "5b01553f08a9f7434f1ffbe86d3df071");
        b.put(SettingKeys.UBIEnSn, "350b5087815b566c493b303d4bc8e9f1");
        b.put(SettingKeys.UBISn2, "f4a3212da56a8487783ff2d14fc113c2");
        b.put(SettingKeys.UBIDn, "1548d0593902f4af8e9cd935bf52fb9a");
        b.put(SettingKeys.UBICpParam, "158a52e85ab26a4502569e0265a14028");
        b.put(SettingKeys.NetworkDNSControlFlag, "b565eb7886b846299660a8f54f6e163f");
        b.put(SettingKeys.UBIMiImei, "56b7d74acce5d1e19ea4bf57da0b7ab5");
        b.put(SettingKeys.UBIMiEnImei, "28d3ca527951387f90681d42aee3d19e");
        b.put("device_id", "034624a206fe0bf878d697e24b806dfc");
        b.put(SettingKeys.UBIMiEnDeviceID, "3920fea184ec695b0afb6b75285b6152");
        b.put(SettingKeys.UBIUtdId, "5857f64f5dbba15336113bd02e5ce7d3");
        b.put(SettingKeys.UBIEnUtdId, "b8a5d45530ef1f6de68bf8b03623422c");
        b.put(SettingKeys.UBIAid, "24e0b46378c955c0553647269f3cddd5");
        b.put(SettingKeys.UBIEnAid, "7add091cc4873850989e56f9f762b758");
        b.put(SettingKeys.UBIMiGi, "b23522d68f5ad40bde93894c92de5857");
        b.put(SettingKeys.UBIEnAddr, "5e90ce5f6495d4e648cdb144c5e20ba6");
    }

    private static boolean f(String str) {
        b();
        if (!c) {
            a(d.a());
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        Editor edit = a().edit();
        edit.putBoolean(str, true);
        edit.apply();
        return true;
    }

    private static void a(Context context) {
        if (context != null && !c) {
            c = true;
            if (f.a) {
                d = context.getApplicationInfo().dataDir + "/ucflags/";
                if (!a("has_check_replace")) {
                    File file = new File(d);
                    if (file.exists()) {
                        String[] list = file.list();
                        if (list != null && list.length > 0) {
                            for (String str : list) {
                                if (!"58730232135f70d2fb7bef7dc7f210cb".equals(str)) {
                                    f(str);
                                }
                            }
                        }
                        m.a(0, new c(file));
                    }
                    f("has_check_replace");
                }
            }
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void a(String str, long j) {
        b();
        if (!c) {
            a(d.a());
        }
        if (str != null && !"".equals(str)) {
            Editor edit = a().edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }

    public static void a(String str, int i) {
        b();
        if (!c) {
            a(d.a());
        }
        if (!"".equals(str)) {
            Editor edit = a().edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public static void a(String str, String str2) {
        b();
        if (!c) {
            a(d.a());
        }
        if (str != null && !"".equals(str)) {
            Editor edit = a().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void b(String str, int i) {
        b();
        if (!c) {
            a(d.a());
        }
        if (!"".equals(str)) {
            Editor edit = a().edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    private static void b(File file) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        b(listFiles[i]);
                        listFiles[i].delete();
                    } else {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        }
    }

    private static SharedPreferences a() {
        return d.a().getSharedPreferences("flags_counter", (f.a ? 0 : 4) | 0);
    }

    private static void b() {
        if (b.b() && !f.a) {
            Throwable th = new Throwable("Can not write data outside main process!");
            Log.e("SettingFlags", th.getMessage(), th);
            c.a(th.getMessage());
        }
    }

    public static boolean a(String str) {
        if (!c) {
            a(d.a());
        }
        if (str.length() == 0) {
            return false;
        }
        Boolean bool = null;
        SharedPreferences a = a();
        if (a.contains(str)) {
            try {
                bool = Boolean.valueOf(a.getBoolean(str, false));
            } catch (Exception e) {
            }
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static int b(String str) {
        if (!c) {
            a(d.a());
        }
        if ("".equals(str)) {
            return 0;
        }
        return a().getInt(str, 0);
    }

    public static long c(String str) {
        if (!c) {
            a(d.a());
        }
        if ("".equals(str)) {
            return -1;
        }
        return a().getLong(str, -1);
    }

    public static String d(String str) {
        if (!c) {
            a(d.a());
        }
        if ("".equals(str)) {
            return "";
        }
        return a().getString(str, "");
    }

    public static String b(String str, String str2) {
        if (!c) {
            a(d.a());
        }
        if ("".equals(str)) {
            return "";
        }
        return a().getString(str, str2);
    }

    public static int e(String str) {
        if (!c) {
            a(d.a());
        }
        if ("".equals(str)) {
            return -1;
        }
        return a().getInt(str, -1);
    }
}
