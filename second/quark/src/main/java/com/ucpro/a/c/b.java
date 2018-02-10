package com.ucpro.a.c;

import com.uc.webview.browser.interfaces.SettingKeys;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    private static List<String> a = new ArrayList();
    private static List<String> b = new ArrayList();
    private static List<String> c = new ArrayList();
    private static List<String> d = new ArrayList();

    static {
        a.add("NetworkProxyRules");
        b.add("SDKUCParam");
        d.add(SettingKeys.UserAdblockJs);
    }

    public static List<String> a() {
        return a;
    }

    public static List<String> b() {
        return b;
    }

    public static List<String> c() {
        return c;
    }

    public static List<String> d() {
        return d;
    }
}
