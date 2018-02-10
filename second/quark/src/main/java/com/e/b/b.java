package com.e.b;

import android.text.TextUtils;
import com.alibaba.analytics.core.c;
import com.alibaba.analytics.core.h.k;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    public static volatile boolean a = false;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    private static b d = new b();
    private l e;
    private Map<String, l> f = new HashMap();
    private HashMap<String, l> g = new HashMap();

    private b() {
    }

    public static b a() {
        return d;
    }

    public static void b() {
        k.a().b();
    }

    public static void c() {
        g.a().b();
    }

    public final synchronized l d() {
        if (this.e == null && !TextUtils.isEmpty(c.a().c)) {
            this.e = new l();
        }
        if (this.e == null) {
            throw new RuntimeException("getDefaultTracker error,must call setRequestAuthentication method first");
        }
        return this.e;
    }

    public static void a(Map<String, String> map) {
        com.alibaba.analytics.c.a((Map) map);
    }
}
