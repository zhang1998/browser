package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.p;
import com.tencent.wxop.stat.a.q;
import com.tencent.wxop.stat.b.a;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.i;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ah {
    static volatile int a = 0;
    static volatile long b = 0;
    static volatile long c = 0;
    private static d d;
    private static volatile Map<a, Long> e = new ConcurrentHashMap();
    private static volatile Map<String, Properties> f = new ConcurrentHashMap();
    private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
    private static volatile long h = 0;
    private static volatile long i = 0;
    private static volatile long j = 0;
    private static String k = "";
    private static volatile int l = 0;
    private static volatile String m = "";
    private static volatile String n = "";
    private static Map<String, Long> o = new ConcurrentHashMap();
    private static Map<String, Long> p = new ConcurrentHashMap();
    private static p q = n.c();
    private static UncaughtExceptionHandler r = null;
    private static volatile boolean s = true;
    private static Context t = null;

    static int a(Context context, boolean z, ai aiVar) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - i < ((long) i.d())) {
            boolean z2 = false;
        } else {
            int i2 = 1;
        }
        i = currentTimeMillis;
        if (j == 0) {
            j = n.d();
        }
        if (currentTimeMillis >= j) {
            j = n.d();
            if (as.a(context).b(context).c != 1) {
                as.a(context).b(context).c = 1;
            }
            i.t();
            a = 0;
            k = n.e();
            i2 = 1;
        }
        Object obj = k;
        if (n.a(aiVar)) {
            obj = aiVar.a + k;
        }
        if (p.containsKey(obj)) {
            i = i2;
        }
        if (i != 0) {
            if (n.a(aiVar)) {
                a(context, aiVar);
            } else if (i.u() < i.r()) {
                n.u(context);
                a(context, null);
            } else {
                q.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            p.put(obj, Long.valueOf(1));
        }
        if (s) {
            if (i.c()) {
                Context g = g(context);
                if (g == null) {
                    q.d("The Context of StatService.testSpeed() can not be null!");
                } else if (i(g) != null) {
                    d.a(new w(g));
                }
            }
            s = false;
        }
        return l;
    }

    public static Properties a(String str) {
        return (Properties) f.get(str);
    }

    public static void a(Context context) {
        if (i.c() && i(context) != null) {
            d.a(new z(context));
        }
    }

    private static void a(Context context, ai aiVar) {
        if (i(context) != null) {
            if (i.b()) {
                q.g("start new session.");
            }
            if (aiVar == null || l == 0) {
                l = n.a();
            }
            i.q();
            i.s();
            new ag(new i(context, l, l(), aiVar)).a();
        }
    }

    public static void a(Context context, String str) {
        if (i.c()) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.trackCustomEvent() can not be null!");
                return;
            }
            if ((str.length() == 0 ? 1 : null) != null) {
                q.d("The event_id of StatService.trackCustomEvent() can not be null or empty.");
                return;
            }
            a aVar = new a(str, null);
            if (i(g) != null) {
                d.a(new t(g, aVar));
            }
        }
    }

    public static void a(Context context, String str, ai aiVar) {
        if (i.c()) {
            Context g = g(context);
            if (g == null || str == null || str.length() == 0) {
                q.d("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (i(g) != null) {
                d.a(new u(str2, g, aiVar));
            }
        }
    }

    static void a(Context context, Throwable th) {
        if (i.c()) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (i(g) != null) {
                d.a(new r(g, th));
            }
        }
    }

    static boolean a() {
        if (a < 2) {
            return false;
        }
        b = System.currentTimeMillis();
        return true;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (i.c()) {
                String str3 = "2.0.3";
                if (i.b()) {
                    q.g("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null) {
                    q.d("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    i.a(false);
                    return false;
                } else if (n.b(str3) < n.b(str2)) {
                    q.d(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    i.a(false);
                    return false;
                } else {
                    str3 = i.b(context);
                    if (str3 == null || str3.length() == 0) {
                        i.b("-");
                    }
                    if (str != null) {
                        i.a(context, str);
                    }
                    if (i(context) != null) {
                        d.a(new aa(context));
                    }
                    return true;
                }
            }
            q.d("MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            q.b(th);
            return false;
        }
    }

    static void b() {
        a = 0;
        b = 0;
    }

    public static void b(Context context) {
        if (i.c() && i(context) != null) {
            d.a(new q(context));
        }
    }

    public static void b(Context context, String str, ai aiVar) {
        if (i.c()) {
            Context g = g(context);
            if (g == null || str == null || str.length() == 0) {
                q.d("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (i(g) != null) {
                d.a(new y(g, str2, aiVar));
            }
        }
    }

    static void c() {
        a++;
        b = System.currentTimeMillis();
        e(t);
    }

    static void c(Context context) {
        if (i.c()) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                n.b(g).a(new f(g), new s());
            } catch (Throwable th) {
                q.b(th);
            }
        }
    }

    public static void d(Context context) {
        if (i.c()) {
            if (i.b()) {
                q.a((Object) "commitEvents, maxNumber=-1");
            }
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.commitEvents() can not be null!");
            } else if (d.a(t).b() && i(g) != null) {
                d.a(new v(g));
            }
        }
    }

    public static void e(Context context) {
        if (i.c() && i.n > 0) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.testSpeed() can not be null!");
                return;
            }
            as a = as.a(g);
            if (i.c()) {
                try {
                    a.a.a(new al(a));
                } catch (Throwable th) {
                    as.d.b(th);
                }
            }
        }
    }

    static void f(Context context) {
        c = System.currentTimeMillis() + ((long) (60000 * i.l()));
        q.a(context, "last_period_ts", c);
        d(context);
    }

    private static Context g(Context context) {
        return context != null ? context : t;
    }

    private static synchronized void h(Context context) {
        boolean z = false;
        synchronized (ah.class) {
            if (context != null) {
                if (d == null) {
                    long a = q.a(context, i.c);
                    long b = n.b("2.0.3");
                    boolean z2 = true;
                    if (b <= a) {
                        q.d("MTA is disable for current version:" + b + ",wakeup version:" + a);
                        z2 = false;
                    }
                    a = q.a(context, i.d);
                    if (a > System.currentTimeMillis()) {
                        q.d("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a);
                    } else {
                        z = z2;
                    }
                    i.a(z);
                    if (z) {
                        Context applicationContext = context.getApplicationContext();
                        t = applicationContext;
                        d = new d();
                        k = n.e();
                        h = System.currentTimeMillis() + i.i;
                        d.a(new p(applicationContext));
                    }
                }
            }
        }
    }

    private static d i(Context context) {
        if (d == null) {
            synchronized (ah.class) {
                if (d == null) {
                    try {
                        h(context);
                    } catch (Throwable th) {
                        q.a(th);
                        i.a(false);
                    }
                }
            }
        }
        return d;
    }

    private static JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i.b.d != 0) {
                jSONObject2.put("v", i.b.d);
            }
            jSONObject.put(Integer.toString(i.b.a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (i.a.d != 0) {
                jSONObject2.put("v", i.a.d);
            }
            jSONObject.put(Integer.toString(i.a.a), jSONObject2);
        } catch (Throwable e) {
            q.b(e);
        }
        return jSONObject;
    }
}
