package com.alibaba.appmonitor.d;

import com.alibaba.analytics.a.af;
import com.alibaba.appmonitor.f.d;
import com.alibaba.appmonitor.f.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
final class i implements Runnable {
    private static boolean a = false;
    private static long b = 300000;
    private static i c;
    private static ScheduledFuture d;

    private i() {
    }

    static void a() {
        if (!a) {
            af.a("CleanTask", "init TimeoutEventManager");
            c = new i();
            com.alibaba.analytics.a.i.a();
            d = com.alibaba.analytics.a.i.b(d, c, b);
            a = true;
        }
    }

    static void b() {
        if (!(d == null || d.isDone())) {
            d.cancel(true);
        }
        a = false;
        c = null;
    }

    public final void run() {
        af.a("CleanTask", "clean TimeoutEvent");
        d a = d.a();
        List arrayList = new ArrayList(a.a.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            f fVar = (f) a.a.get(str);
            if (fVar != null && fVar.c()) {
                a.a.remove(str);
            }
        }
    }
}
