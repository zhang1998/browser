package com.alibaba.analytics.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.s;
import com.alibaba.analytics.a.z;
import com.alibaba.analytics.core.c.d;
import com.alibaba.analytics.core.c.e;
import com.alibaba.analytics.core.c.h;
import com.alibaba.analytics.core.db.a;
import com.alibaba.analytics.core.h.i;
import com.alibaba.analytics.core.h.n;
import com.alibaba.analytics.core.h.p;
import com.alibaba.analytics.core.h.r;
import com.alibaba.analytics.core.h.t;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.d.f;
import com.e.b.d.a.c;
import com.uc.apollo.impl.SettingsConst;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    public static final b a = new b();
    private boolean A = false;
    private String B = null;
    private boolean C = false;
    private boolean D = false;
    private Map<String, String> E = null;
    private boolean F = false;
    private int G = 30;
    private long H = -1;
    private boolean I = false;
    private boolean J = false;
    public Context b = null;
    public String c = null;
    public String d = null;
    public volatile c e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = a.b;
    public volatile boolean m = false;
    public a n = null;
    public i o = null;
    public volatile boolean p = false;
    public volatile String q = null;
    public volatile boolean r = false;
    public boolean s = false;
    public boolean t = true;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public String x = null;
    public boolean y = false;
    private boolean z = false;

    public static b a() {
        return a;
    }

    public final synchronized void b() {
        this.J = true;
    }

    public final synchronized boolean c() {
        return this.J;
    }

    public final synchronized void a(Application application) {
        this.b = application.getApplicationContext();
        if (this.b == null) {
            af.c("UTDC init failed", "context:" + this.b);
        } else {
            af.d(null, "init", Boolean.valueOf(this.m));
            if (!this.m) {
                d a;
                Class cls;
                Map hashMap;
                try {
                    UncaughtExceptionHandler a2 = h.a();
                    a2.a = Thread.getDefaultUncaughtExceptionHandler();
                    Thread.setDefaultUncaughtExceptionHandler(a2);
                } catch (Throwable th) {
                    af.b(null, th, new Object[0]);
                }
                try {
                    a = e.a();
                    f.c.a(a);
                } catch (Throwable th2) {
                    af.b(null, th2, new Object[0]);
                }
                try {
                    com.alibaba.analytics.core.a.h.b.a(a);
                } catch (Throwable th22) {
                    af.b(null, th22, new Object[0]);
                }
                try {
                    com.alibaba.analytics.core.f.f.c.a(a);
                } catch (Throwable th222) {
                    af.b(null, th222, new Object[0]);
                }
                try {
                    com.e.b.d.e.a().d.a(a);
                } catch (Throwable th2222) {
                    af.b(null, th2222, new Object[0]);
                }
                try {
                    com.alibaba.analytics.core.h.c.a.a(a);
                } catch (Throwable th22222) {
                    af.b(null, th22222, new Object[0]);
                }
                try {
                    com.alibaba.analytics.a.d.a.a(a);
                } catch (Throwable th222222) {
                    af.b(null, th222222, new Object[0]);
                }
                try {
                    com.alibaba.analytics.core.c.b.a.a(a);
                } catch (Throwable th2222222) {
                    af.b(null, th2222222, new Object[0]);
                }
                SharedPreferences sharedPreferences = this.b.getSharedPreferences("UTCommon", 0);
                Object string = sharedPreferences.getString("_lun", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.i = new String(s.a(string.getBytes()), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                    }
                }
                Object string2 = sharedPreferences.getString("_luid", "");
                if (!TextUtils.isEmpty(string2)) {
                    try {
                        this.k = new String(s.a(string2.getBytes()), "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                    }
                }
                this.n = new a(this.b, "ut.db");
                com.alibaba.analytics.core.d.e.c(this.b);
                com.alibaba.analytics.core.db.f.a();
                try {
                    cls = Class.forName("com.taobao.orange.OrangeConfig");
                } catch (Throwable th3) {
                    cls = null;
                }
                if (cls != null) {
                    this.o = new com.alibaba.analytics.core.h.c();
                } else {
                    this.o = new n();
                }
                this.o.a(t.a());
                this.o.a(p.a());
                this.o.a(new com.alibaba.analytics.core.h.b());
                this.o.a(com.alibaba.appmonitor.a.d.a());
                try {
                    this.o.a(com.alibaba.analytics.core.h.e.a());
                    com.alibaba.analytics.core.h.e.a().a("sw_plugin", new r());
                } catch (Throwable th22222222) {
                    af.b(null, th22222222, new Object[0]);
                }
                this.o.a();
                com.alibaba.analytics.core.b.h a3 = com.alibaba.analytics.core.b.h.a();
                com.alibaba.analytics.a.i.a();
                com.alibaba.analytics.a.i.a(null, new com.alibaba.analytics.core.b.c(a3), 0);
                f.a(application);
                com.e.b.i.a().a = application;
                com.e.b.c.a.a();
                if (this.b != null) {
                    af.b();
                    sharedPreferences = this.b.getSharedPreferences("UTRealTimeDebug", 0);
                    af.a("", "debugDate", Long.valueOf(sharedPreferences.getLong("debug_date", 0)));
                    if (System.currentTimeMillis() - sharedPreferences.getLong("debug_date", 0) <= 14400000) {
                        hashMap = new HashMap();
                        hashMap.put("debug_api_url", sharedPreferences.getString("debug_api_url", ""));
                        hashMap.put("debug_key", sharedPreferences.getString("debug_key", ""));
                        b(hashMap);
                    }
                }
                com.alibaba.analytics.core.a.f.a().b();
                try {
                    Map c = com.alibaba.analytics.a.r.c(this.b);
                    if (c != null && c.size() > 0) {
                        hashMap = new HashMap();
                        hashMap.put(LogField.EVENTID.toString(), "1021");
                        hashMap.putAll(c);
                        com.e.b.i.a();
                        com.e.b.i.a(hashMap);
                    }
                } catch (Throwable th4) {
                }
                this.m = true;
            }
        }
    }

    public final String d() {
        if (TextUtils.isEmpty(this.g)) {
            Map a = j.a(this.b);
            if (a != null) {
                this.g = (String) a.get(LogField.APPVERSION);
            }
        }
        return this.g;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f)) {
            Object a = z.a(this.b, "channel");
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
        }
        return this.f;
    }

    private synchronized void m() {
        this.F = true;
    }

    public final synchronized void a(Map<String, String> map) {
        this.E = map;
    }

    public final synchronized Map<String, String> f() {
        return this.E;
    }

    public final synchronized void a(String str) {
        this.B = str;
    }

    public final synchronized String g() {
        return this.B;
    }

    public final synchronized boolean h() {
        return this.A;
    }

    private synchronized void n() {
        this.A = true;
    }

    public final synchronized void i() {
        this.A = false;
    }

    public final void b(Map<String, String> map) {
        af.b();
        if (SettingsConst.FALSE.equalsIgnoreCase(com.alibaba.analytics.core.h.e.a().a("real_time_debug"))) {
            af.c("Variables", "Server Config turn off RealTimeDebug Mode!");
            return;
        }
        if (map != null && map.containsKey("debug_api_url") && map.containsKey("debug_key")) {
            String str = (String) map.get("debug_api_url");
            String str2 = (String) map.get("debug_key");
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                this.l = str;
                n();
                a(str2);
            }
            if ("ap".equalsIgnoreCase((String) map.remove("from"))) {
                this.r = true;
            }
            if (map.containsKey("debug_sampling_option")) {
                m();
                j();
                if (this.r) {
                    f.a = true;
                }
            }
            com.alibaba.analytics.core.a.f.a().a(com.alibaba.analytics.core.a.d.REALTIME);
        }
        c(map);
    }

    public final void c(Map<String, String> map) {
        if (this.b != null) {
            af.a("", (Map) map);
            Editor edit = this.b.getSharedPreferences("UTRealTimeDebug", 0).edit();
            if (map == null || !map.containsKey("debug_store")) {
                edit.putLong("debug_date", 0);
            } else {
                edit.putString("debug_api_url", (String) map.get("debug_api_url"));
                edit.putString("debug_key", (String) map.get("debug_key"));
                edit.putLong("debug_date", System.currentTimeMillis());
            }
            edit.commit();
        }
    }

    public final void j() {
        this.C = true;
        af.a(true);
    }

    public static boolean l() {
        return true;
    }

    public final String k() {
        CharSequence a = z.a(this.b, "http_host");
        if (TextUtils.isEmpty(a)) {
            return this.l;
        }
        try {
            String replace = this.l.replace(Uri.parse(this.l).getHost(), a);
            af.d(replace, new Object[0]);
            return replace;
        } catch (Throwable th) {
            return this.l;
        }
    }
}
