package com.uc.c;

import android.text.TextUtils;
import com.uc.m;
import java.io.File;

/* compiled from: ProGuard */
public final class g {
    public static boolean a = true;

    public static String a() {
        return "/data/data/" + m.a.getApplicationInfo().packageName;
    }

    public static String b() {
        File file = new File(a(), "p2p_so");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String c() {
        return "libp2pxg.so";
    }

    public static String d() {
        return a() + File.separator + "p2p_so" + File.separator + "libp2pxg.so";
    }

    public static String e() {
        return c.a;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("xg://") == 0;
    }
}
