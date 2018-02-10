package com.ucpro.feature.s;

import com.ucpro.business.stat.m;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class e {
    private static boolean a = false;

    public static void a(String str, String str2, String str3) {
        if (a) {
            new StringBuilder("tabName:").append(str).append(" siteName:").append(str2).append(" url:").append(str3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("tab", str);
        hashMap.put("name", str2);
        hashMap.put("url", str3);
        m.a("allinonenavigation", "aion_ck_siteview", hashMap);
    }

    public static void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab", str);
        m.a("allinonenavigation", "aion_select_tab", hashMap);
    }

    public static void a() {
        m.a("allinonenavigation", "aion_stfs", new String[0]);
    }

    public static void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        m.a("allinonenavigation", "aion_exit_type", hashMap);
    }
}
