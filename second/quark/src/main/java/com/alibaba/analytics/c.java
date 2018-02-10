package com.alibaba.analytics;

import android.app.Application;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.r;
import com.alibaba.analytics.b.a;
import com.alibaba.analytics.core.h.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class c {
    public static h a;
    public static b b;
    public static final Object c = new Object();
    public static volatile boolean d = false;
    public static int e = m.b;
    public static boolean f = false;
    public static final List<Object> g = Collections.synchronizedList(new ArrayList());
    private static Application h = null;
    private static HandlerThread i = null;
    private static final Object j = new Object();
    private static boolean k = false;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static boolean o = false;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static boolean s = false;
    private static Map<String, String> t = null;
    private static Map<String, String> u = null;
    private static List<m> v = new ArrayList();
    private static boolean w = false;
    private static boolean x = false;
    private static ServiceConnection y = new d();

    public static synchronized void a(Application application) {
        Throwable th;
        int i = 0;
        synchronized (c.class) {
            try {
                if (!d) {
                    Looper looper;
                    Object[] objArr = new Object[2];
                    objArr[0] = "sdk_version";
                    a.a();
                    objArr[1] = a.b();
                    af.b("AnalyticsMgr[init] start", objArr);
                    h = application;
                    i = new HandlerThread("Analytics_Client");
                    i.start();
                    Looper looper2 = null;
                    while (i < 3) {
                        try {
                            looper2 = i.getLooper();
                            if (looper2 != null) {
                                break;
                            }
                            Thread.sleep(10);
                            i++;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            looper = looper2;
                            th = th3;
                            af.d("AnalyticsMgr", "3", th);
                        }
                    }
                    looper = looper2;
                    b = new b(looper);
                    try {
                        b.postAtFrontOfQueue(new i());
                    } catch (Throwable th4) {
                        af.d("AnalyticsMgr", "4", th4);
                    }
                    d = true;
                    af.a("外面init完成", new Object[0]);
                }
            } catch (Throwable th42) {
                af.c("AnalyticsMgr", "5", th42);
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = "isInit";
            objArr2[1] = Boolean.valueOf(d);
            objArr2[2] = "sdk_version";
            a.a();
            objArr2[3] = a.b();
            af.c("AnalyticsMgr[init] end", objArr2);
        }
    }

    public static void a(String str) {
        if (k()) {
            b.a(new g(str));
            m = str;
        }
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        if (k()) {
            b.a(new e(true, false, str, str2));
            o = true;
            l = str;
            n = str2;
            x = false;
        }
    }

    public static void a(Map<String, String> map) {
        if (k()) {
            b.a(new r(map));
            u = map;
            s = true;
        }
    }

    public static void b(String str) {
        af.d(null, "aAppVersion", str);
        if (k()) {
            b.a(new f(str));
            p = str;
        }
    }

    public static void a() {
        af.d("turnOnDebug", new Object[0]);
        if (k()) {
            b.a(new n());
            f = true;
            af.a(true);
        }
    }

    public static String c(String str) {
        String str2 = null;
        if (a != null) {
            try {
                str2 = a.c(str);
            } catch (Exception e) {
            }
        }
        return str2;
    }

    public static void b(Map<String, String> map) {
        if (k()) {
            b.a(new l(map));
        }
    }

    private static boolean k() {
        if (!d) {
            af.a("Please call init() before call other method", new Object[0]);
        }
        return d;
    }

    private static void l() {
        e = m.a;
        a = new o(h);
        af.c("Start AppMonitor Service failed,AppMonitor run in local Mode...", new Object[0]);
    }

    public static void b() {
        if (k()) {
            b.a(new k());
        }
    }

    private static int m() {
        Object a = r.a(h.getApplicationContext(), "UTANALYTICS_REMOTE_SERVICE_DELAY_SECOND");
        if (TextUtils.isEmpty(a)) {
            return 10;
        }
        try {
            int intValue = Integer.valueOf(a).intValue();
            if (intValue < 0 || intValue > 30) {
                intValue = 10;
            }
            return intValue;
        } catch (Throwable th) {
            return 10;
        }
    }

    static /* synthetic */ boolean h() {
        if (h == null) {
            return false;
        }
        boolean bindService = h.getApplicationContext().bindService(new Intent(h.getApplicationContext(), AnalyticsService.class), y, 1);
        if (!bindService) {
            l();
        }
        af.b("AnalyticsMgr", "bindsuccess", Boolean.valueOf(bindService));
        return bindService;
    }
}
