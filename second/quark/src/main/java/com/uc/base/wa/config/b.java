package com.uc.base.wa.config;

import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.a.c;
import com.uc.base.wa.b.g;
import com.uc.base.wa.p;
import com.uc.base.wa.q;
import com.uc.webview.browser.interfaces.IWebResources;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class b {
    public static q a = null;
    public static p b = null;
    public static String c = null;
    public static final int[] d = new int[]{1, 2, 3, 4, 5, 6};
    private static HashMap<String, Integer> o = new HashMap();
    private static final HashMap<String, b> p = new HashMap();
    private static Set<String> q = null;
    private static HashMap<String, b> r = new HashMap();
    private static HashMap<String, i> t = new HashMap();
    private static byte[] u = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private static byte[] v = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122};
    private static byte w = (byte) 0;
    public boolean e = false;
    public String f = null;
    public String g = null;
    public int h = 0;
    public int i = 100;
    public int j = 10;
    public long k = 1800000;
    public boolean l = false;
    public List<String> m;
    public HashMap<String, i> n = new HashMap();
    private String s = null;

    static {
        p.put("forced", new b(1));
        p.put("impot", new b(2));
        p.put("cbusi", new b(3));
        p.put("system", new b(4));
        p.put("nbusi", new b(5));
        p.put(IWebResources.TEXT_OTHER, new b(6));
        b bVar = new b();
        bVar.g = "system";
        p.put("wa", bVar);
        bVar = new b();
        bVar.g = "forced";
        bVar.s = "wa";
        p.put("wa_forced", bVar);
    }

    public static void a(String str) {
        c = str;
    }

    public static boolean a() {
        return m.k;
    }

    public static String b() {
        if (c != null) {
            return c;
        }
        throw new Error("appName is null !!");
    }

    public static int a(int i) {
        switch (i) {
            case 1:
                return 2500;
            case 3:
                return 250;
            case 4:
                return 166;
            case 5:
                return 125;
            case 6:
                return 100;
            default:
                return SecExceptionCode.SEC_ERROR_DYN_STORE;
        }
    }

    public static long a(long j) {
        long j2 = (m.b * 60) * 24;
        if (j <= 0) {
            return j2 / 8;
        }
        if (j < j2 / 2) {
            return j2 / 8;
        }
        if (j < j2) {
            return j2 / 4;
        }
        if (j < 3 * j2) {
            return j2 / 2;
        }
        return (long) (((double) j2) / 1.5d);
    }

    public static long b(long j) {
        return (m.b * j) / 60000;
    }

    public static long c(long j) {
        return ((1000 * j) * 60) / m.b;
    }

    public static long c() {
        if (c.a().i()) {
            return m.g;
        }
        return m.h;
    }

    public static boolean d() {
        return m.b == 0;
    }

    private static void a(Set<String> set) {
        q = set;
        for (Entry entry : p.entrySet()) {
            if (q.contains(SettingsConst.FALSE) || q.contains(entry.getKey())) {
                ((b) entry.getValue()).e = true;
            }
        }
    }

    public static void b(String str) {
        try {
            String[] split = str.split("`");
            Set hashSet = new HashSet(split.length);
            for (Object add : split) {
                hashSet.add(add);
            }
            if (hashSet.contains(SettingsConst.FALSE)) {
                m.k = true;
            }
            a(hashSet);
            g.a(hashSet);
        } catch (Throwable e) {
            Log.e("WaConfig", "", e);
            c.a().b(e.toString());
        }
    }

    public static String c(String str) {
        String str2 = null;
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                if (bytes != null) {
                    byte b = (byte) (w + 1 < 10 ? w + 1 : 1);
                    w = b;
                    for (int i = 0; i < bytes.length; i++) {
                        byte b2 = u[bytes[i]];
                        if (b2 != (byte) -1) {
                            bytes[i] = v[(byte) ((b2 + b) % 62)];
                        }
                    }
                    str2 = String.valueOf(b) + new String(bytes);
                }
            } catch (Exception e) {
            }
        }
        return str2;
    }

    public static String d(String str) {
        String str2 = null;
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                if (bytes != null && bytes.length > 0) {
                    byte byteValue = Byte.valueOf(new String(new byte[]{bytes[0]})).byteValue();
                    for (int i = 1; i < bytes.length; i++) {
                        byte b = u[bytes[i]];
                        if (b != (byte) -1) {
                            bytes[i] = v[(byte) (((b + 62) - byteValue) % 62)];
                        }
                    }
                    str2 = new String(bytes).substring(1);
                }
            } catch (Exception e) {
            }
        }
        return str2;
    }

    public b() {
        b(6);
    }

    private b(int i) {
        b(i);
    }

    public static boolean e() {
        return m.s() && m.f() > 0;
    }

    public static String f() {
        return c.a().k() + "/wa/ul/uld";
    }

    public static String g() {
        return c.a().k() + "/wa/ul/wf";
    }

    public static String h() {
        return c.a().k() + "/wa/ul/mb";
    }

    public static String i() {
        return c.a().k() + "/wa/sv";
    }

    public static String j() {
        return c.a().k() + "/wa/lo";
    }

    public static File k() {
        return new File(c.a().k() + "/wa");
    }

    public static void a(q qVar) {
        a = qVar;
    }

    public static q l() {
        return a;
    }

    public static void a(p pVar) {
        b = pVar;
    }

    public static p m() {
        return b;
    }

    public static b e(String str) {
        b bVar;
        synchronized (b.class) {
            if (r.containsKey(str)) {
                bVar = (b) r.get(str);
            } else {
                bVar = a(str, true);
                r.put(str, bVar);
            }
        }
        return bVar;
    }

    private b b(int i) {
        this.h = i;
        switch (this.h) {
            case 1:
                this.i = 200;
                this.j = 50;
                this.k = 3000000;
                break;
            case 2:
                this.i = 150;
                this.j = 40;
                this.k = 2400000;
                break;
            case 3:
                this.i = 80;
                this.j = 20;
                this.k = 1200000;
                break;
            case 4:
                this.i = 100;
                this.j = 30;
                this.k = 1800000;
                break;
            case 5:
                this.i = 50;
                this.j = 15;
                this.k = 900000;
                break;
            case 6:
                this.i = 30;
                this.j = 10;
                this.k = 600000;
                break;
        }
        return this;
    }

    public static b f(String str) {
        return a(str, true);
    }

    public static b g(String str) {
        return a(str, false);
    }

    private static b a(String str, boolean z) {
        b bVar = (b) p.get(str);
        if (bVar != null || !z) {
            return bVar;
        }
        if (str == null) {
            return null;
        }
        bVar = (b) p.get(str);
        if (bVar == null) {
            bVar = new b();
            Log.e("WaConfig", "category = " + str + ", config is null", new Throwable());
        }
        if (q != null && q.contains(str)) {
            bVar.e = true;
        }
        if (bVar != null && bVar.h != 0) {
            return bVar;
        }
        throw new Error();
    }

    public final String h(String str) {
        return this.s == null ? str : this.s;
    }

    public static boolean n() {
        return m.l == 5;
    }

    public static int i(String str) {
        Integer num = (Integer) o.get(str);
        if (num == null || num.intValue() <= 0 || num.intValue() > 6) {
            return 6;
        }
        return num.intValue();
    }

    public static i a(String str, String str2, String str3) {
        return (i) t.get(str + "#" + str2 + "#" + str3);
    }
}
