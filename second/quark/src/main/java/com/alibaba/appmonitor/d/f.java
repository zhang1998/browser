package com.alibaba.appmonitor.d;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.c.a.a;
import com.alibaba.analytics.core.c.a.b;
import com.alibaba.analytics.core.c.a.c;
import com.alibaba.analytics.core.c.g;
import com.alibaba.analytics.core.d.e;
import com.alibaba.appmonitor.a.d;
import com.alibaba.appmonitor.f.h;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;

/* compiled from: ProGuard */
public final class f {
    public static boolean a = false;
    public static volatile boolean b = false;
    public static g c = new g();
    private static Application d;

    public static synchronized void a(Application application) {
        synchronized (f.class) {
            af.a("AppMonitorDelegate", "start init");
            try {
                if (!b) {
                    d = application;
                    i.a();
                    h.a();
                    b.a(application);
                    b = true;
                }
            } catch (Throwable th) {
                a();
            }
        }
    }

    public static synchronized void a() {
        synchronized (f.class) {
            try {
                af.a("AppMonitorDelegate", "start destory");
                if (b) {
                    h.c();
                    h.b();
                    i.b();
                    if (d != null) {
                        e.d(d.getApplicationContext());
                    }
                    b = false;
                }
            } catch (Throwable th) {
                c.a(b.b, th);
            }
        }
    }

    public static synchronized void b() {
        synchronized (f.class) {
            try {
                af.a("AppMonitorDelegate", "triggerUpload");
                if (b) {
                    com.alibaba.analytics.core.b.l();
                    h.c();
                }
            } catch (Throwable th) {
                c.a(b.b, th);
            }
        }
    }

    public static void a(int i) {
        for (h hVar : h.values()) {
            hVar.h = i;
            a(hVar, i);
        }
    }

    public static void b(int i) {
        int i2 = 0;
        af.a("AppMonitorDelegate", "[setSampling]");
        h[] values = h.values();
        int length = values.length;
        while (i2 < length) {
            h hVar = values[i2];
            hVar.k = i;
            d.a().a(hVar, i);
            i2++;
        }
    }

    public static void a(boolean z) {
        af.a("AppMonitorDelegate", "[enableLog]");
        af.a(z);
    }

    public static void a(String str, String str2, MeasureSet measureSet) {
        a(str, str2, measureSet, null);
    }

    public static void a(String str, String str2, MeasureSet measureSet, boolean z) {
        a(str, str2, measureSet, null, z);
    }

    public static void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        a(str, str2, measureSet, dimensionSet, false);
    }

    public static void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (!b) {
                return;
            }
            if (com.alibaba.analytics.a.b.c(str) || com.alibaba.analytics.a.b.c(str2)) {
                af.a("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (a) {
                    throw new a("register error. module and monitorPoint can't be null");
                }
                return;
            }
            com.alibaba.appmonitor.model.b bVar = new com.alibaba.appmonitor.model.b(str, str2, measureSet, dimensionSet, z);
            com.alibaba.appmonitor.model.a.a().a(bVar);
            com.alibaba.appmonitor.b.f a = com.alibaba.appmonitor.b.f.a();
            af.b();
            a.a.add(bVar);
            if (a.a.size() >= 100) {
                i.a();
                a.b = i.a(null, a.c, 0);
            } else {
                i.a();
                a.b = i.a(a.b, a.c, 30000);
            }
            MeasureSet a2 = com.alibaba.analytics.core.c.a.a().a(str, str2);
            if (a2 != null) {
                com.alibaba.appmonitor.model.a.a().a(new com.alibaba.appmonitor.model.b(str + "_abtest", str2, a2, dimensionSet, false));
            }
        } catch (Throwable th) {
            c.a(b.b, th);
        }
    }

    public static void a(String str, String str2, String str3, double d, double d2, double d3) {
        af.a("AppMonitorDelegate", "[updateMeasure]");
        try {
            if (b && !com.alibaba.analytics.a.b.c(str) && !com.alibaba.analytics.a.b.c(str2)) {
                com.alibaba.appmonitor.model.b a = com.alibaba.appmonitor.model.a.a().a(str, str2);
                if (a != null && a.d() != null) {
                    MeasureSet d4 = a.d();
                    Measure measure = new Measure(str3, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2));
                    int size = d4.a.size();
                    for (int i = 0; i < size; i++) {
                        if (TextUtils.equals(((Measure) d4.a.get(i)).a, measure.a)) {
                            ((Measure) d4.a.get(i)).a(measure.a(), measure.b());
                            ((Measure) d4.a.get(i)).a(measure.c());
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void a(h hVar, int i) {
        try {
            if (b && hVar != null) {
                h.a(hVar.d, i);
                if (i > 0) {
                    hVar.e = true;
                } else {
                    hVar.e = false;
                }
            }
        } catch (Throwable th) {
            c.a(b.b, th);
        }
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.e.b.d.a.c bVar;
        if (z) {
            bVar = new com.e.b.d.a.b(str, str2);
        } else {
            bVar = new com.e.b.d.a.a(str, str2, z2);
        }
        com.alibaba.analytics.core.b a = com.alibaba.analytics.core.b.a();
        a.e = bVar;
        a.c = bVar.a();
    }
}
