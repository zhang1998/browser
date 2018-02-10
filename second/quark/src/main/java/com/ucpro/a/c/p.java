package com.ucpro.a.c;

import android.os.Looper;
import android.text.TextUtils;
import com.uc.webview.browser.BrowserCore;
import com.uc.webview.browser.interfaces.BrowserSettings;
import com.uc.webview.export.extension.UCSettings;
import com.ucpro.a.g;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class p {
    private static String a = "WebCoreSetting";
    private static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, Float> c = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, Integer> f = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, Float> g = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, Boolean> h = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, String> i = new ConcurrentHashMap();
    private static List<String> j = new ArrayList();
    private static List<String> k = new ArrayList();
    private static List<String> l = new ArrayList();
    private static List<String> m = new ArrayList();
    private static boolean n = false;

    public static void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            new StringBuilder("setGlobalIntValue key = ").append(str).append(", value = ").append(i);
            if (!g.a().c()) {
                f.put(str, Integer.valueOf(i));
            } else if (d(str)) {
                d dVar = k.a.c;
                if (dVar != null) {
                    m.a(0, new s(dVar, str, i));
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    BrowserSettings.setGlobalIntValue(str, i);
                } else {
                    m.a(2, new h(str, i));
                }
            } else {
                b.put(str, Integer.valueOf(i));
            }
        }
    }

    public static int a(String str) {
        i();
        if (!TextUtils.isEmpty(str)) {
            if (g.a().c()) {
                if (d(str)) {
                    return BrowserSettings.getGlobalIntValue(str);
                }
                return ((Integer) b.get(str)).intValue();
            } else if (f.containsKey(str)) {
                return ((Integer) f.get(str)).intValue();
            }
        }
        return -1;
    }

    public static void a(String str, float f) {
        if (!TextUtils.isEmpty(str)) {
            new StringBuilder("setGlobalFloatValue key = ").append(str).append(", value = ").append(f);
            if (!g.a().c()) {
                g.put(str, Float.valueOf(f));
            } else if (d(str)) {
                d dVar = k.a.c;
                if (dVar != null) {
                    m.a(0, new o(dVar, str, f));
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    BrowserSettings.setGlobalFloatValue(str, f);
                } else {
                    m.a(2, new w(str, f));
                }
            } else {
                c.put(str, Float.valueOf(f));
            }
        }
    }

    public static void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            new StringBuilder("setGlobalBoolValue key = ").append(str).append(", value = ").append(z);
            if (!g.a().c()) {
                h.put(str, Boolean.valueOf(z));
            } else if (d(str)) {
                d dVar = k.a.c;
                if (dVar != null) {
                    m.a(0, new f(dVar, str, z));
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    BrowserSettings.setGlobalBoolValue(str, z);
                } else {
                    m.a(2, new u(str, z));
                }
            } else {
                d.put(str, Boolean.valueOf(z));
            }
        }
    }

    public static boolean b(String str) {
        i();
        if (!TextUtils.isEmpty(str)) {
            if (g.a().c()) {
                if (d(str)) {
                    return UCSettings.getGlobalBoolValue(str);
                }
                return ((Boolean) d.get(str)).booleanValue();
            } else if (h.containsKey(str)) {
                return ((Boolean) h.get(str)).booleanValue();
            }
        }
        return false;
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new StringBuilder("setGlobalStringValue key = ").append(str).append(", value = ").append(str2);
            if (!g.a().c()) {
                i.put(str, str2);
            } else if (d(str)) {
                d dVar = k.a.c;
                if (dVar != null) {
                    m.a(0, new v(dVar, str, str2));
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    new StringBuilder("realSetToCore: \nkey: ").append(str).append("\nvalue: ").append(str2);
                    BrowserSettings.setGlobalStringValue(str, str2);
                    new StringBuilder("set ").append(str).append("success");
                    return;
                }
                m.a(2, new i(str, str2));
            } else {
                e.put(str, str2);
            }
        }
    }

    public static List<String> a() {
        i();
        if (l == null || l.size() == 0) {
            List b = b(2);
            l = b;
            b.addAll(b.b());
        }
        new StringBuilder("getWebCoreCareBoolSettingKeys Size = ").append(String.valueOf(l.size()));
        Iterator it = l.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return l;
    }

    public static List<String> b() {
        i();
        if (j == null || j.size() == 0) {
            List b = b(1);
            j = b;
            b.addAll(b.a());
        }
        new StringBuilder("getWebCoreCareIntSettingKeys Size = ").append(String.valueOf(j.size()));
        Iterator it = j.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return j;
    }

    public static List<String> c() {
        i();
        if (k == null || k.size() == 0) {
            List b = b(3);
            k = b;
            b.addAll(b.c());
        }
        new StringBuilder("getWebCoreCareFloatSettingKeys Size = ").append(String.valueOf(k.size()));
        Iterator it = k.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return k;
    }

    public static List<String> d() {
        i();
        if (m == null || m.size() == 0) {
            List b = b(4);
            m = b;
            b.addAll(b.d());
        }
        new StringBuilder("getWebCoreCareStringSettingKeys Size = ").append(String.valueOf(m.size()));
        Iterator it = m.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return m;
    }

    public static void e() {
        if (!n) {
            a();
            c();
            b();
            d();
            n = true;
        }
    }

    static Map<String, String> a(int i) {
        return BrowserCore.getBusinessInfo(i);
    }

    public static void a(int i, int i2, Map<String, String> map) {
        c.b(g.a().c());
        if (g.a().c() && map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                if (!(entry == null || TextUtils.isEmpty((CharSequence) entry.getKey()))) {
                    g.a().c.updateBussinessInfo(i, i2, (String) entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void c(String str) {
        c.b(g.a().c());
        if (g.a().c()) {
            g.a().c.updateBussinessInfo(3, 0, "SETTING_CLEAR_RECORD", str);
        }
    }

    public static void f() {
        c.b(g.a().c());
        if (g.a().c()) {
            g.a().c.updateBussinessInfo(3, 0, "SETTING_RESTORE_DEFAULT", null);
        }
    }

    public static void g() {
        new StringBuilder("WebCorePendingIntMap Size = ").append(f.size()).append("\n WebCorePendingFloatMap Size = ").append(g.size()).append("\n WebCorePendingBoolMap Size = ").append(h.size()).append("\n WebCorePendingStringMap Size = ").append(i.size());
        if (!f.isEmpty()) {
            for (String str : f.keySet()) {
                a(str, ((Integer) f.get(str)).intValue());
            }
        }
        if (!g.isEmpty()) {
            for (String str2 : g.keySet()) {
                a(str2, ((Float) g.get(str2)).floatValue());
            }
        }
        if (!h.isEmpty()) {
            for (String str22 : h.keySet()) {
                a(str22, ((Boolean) h.get(str22)).booleanValue());
            }
        }
        if (!i.isEmpty()) {
            for (String str222 : i.keySet()) {
                a(str222, (String) i.get(str222));
            }
        }
        i();
        f.clear();
        g.clear();
        h.clear();
        i.clear();
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (k.contains(str) || l.contains(str) || j.contains(str) || m.contains(str)) {
            return true;
        }
        return false;
    }

    private static List<String> b(int i) {
        if (i <= 0 || i >= 5) {
            return null;
        }
        return BrowserSettings.getCoreCareSettingKeys(i);
    }

    private static void i() {
        c.b(Looper.getMainLooper() == Looper.myLooper());
    }
}
