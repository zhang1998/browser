package com.ucpro.d;

import android.content.Context;
import android.os.SystemClock;
import com.uc.aerie.loader.AerieLoaderContext;
import com.ucpro.b.d.a;
import com.ucpro.c.f;
import com.ucweb.common.util.h.m;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class e {
    private static long a;
    private static long b;
    private static long c;
    private static StringBuilder d;
    private static boolean e = false;
    private static long f;
    private static long g;
    private static long h;

    public static void a() {
        e = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        f = elapsedRealtime;
        g = elapsedRealtime;
    }

    public static void b() {
        a = SystemClock.elapsedRealtime() - g();
        new StringBuilder("sFirstDrawTime:").append(String.valueOf(a));
        if (d != null) {
            new StringBuilder("sContent:").append(d.toString());
        }
    }

    public static void c() {
        c = SystemClock.elapsedRealtime();
    }

    public static void d() {
        b = SystemClock.elapsedRealtime() - f;
        new StringBuilder("sApplicationInitTime:").append(String.valueOf(b));
    }

    public static void e() {
        e = false;
        h = SystemClock.elapsedRealtime() - g();
    }

    private static long g() {
        return f.c ? c : f;
    }

    public static void a(Context context) {
        m.a(0, new d(context), 1000);
    }

    public static void a(String str) {
        if (e) {
            if (d == null) {
                d = new StringBuilder();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            d.append(str).append(":").append(elapsedRealtime - g).append("|");
            g = elapsedRealtime;
        }
    }

    static /* synthetic */ void f() {
        boolean z = f.c;
        boolean b = a.b();
        HashMap hashMap = new HashMap();
        hashMap.put("type", "st1");
        hashMap.put("ihs", String.valueOf(z));
        boolean z2 = !AerieLoaderContext.getBaseDv().equals(AerieLoaderContext.getLoadDv());
        hashMap.put("ias", String.valueOf(z2));
        hashMap.put("ifrai", String.valueOf(b));
        hashMap.put("duration", String.valueOf(b));
        com.ucpro.business.stat.m.a("startup", "startup_benchmark", hashMap);
        hashMap = new HashMap();
        hashMap.put("type", "st2");
        hashMap.put("ihs", String.valueOf(z));
        hashMap.put("ias", String.valueOf(z2));
        hashMap.put("ifrai", String.valueOf(b));
        hashMap.put("duration", String.valueOf(a));
        com.ucpro.business.stat.m.a("startup", "startup_benchmark", hashMap);
        new StringBuilder("statKeyStartupTimes:isHotStartUp=").append(z).append(" isFirstRunningAfterInstall=").append(b).append(" sApplicationInitTime=").append(b).append(" sFirstDrawTime=").append(a);
    }
}
