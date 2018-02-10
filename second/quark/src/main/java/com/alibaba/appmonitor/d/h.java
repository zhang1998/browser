package com.alibaba.appmonitor.d;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.appmonitor.f.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
final class h implements Runnable {
    private static boolean a = false;
    private static Map<Integer, h> e;
    private static HashMap<Integer, ScheduledFuture> f = new HashMap();
    private int b = 300000;
    private int c;
    private long d;

    static void a() {
        if (!a) {
            af.a("CommitTask", "init StatisticsAlarmEvent");
            e = new ConcurrentHashMap();
            for (com.alibaba.appmonitor.f.h hVar : com.alibaba.appmonitor.f.h.values()) {
                if (hVar.e) {
                    int i = hVar.d;
                    Runnable hVar2 = new h(i, hVar.h * 1000);
                    e.put(Integer.valueOf(i), hVar2);
                    ScheduledFuture scheduledFuture = (ScheduledFuture) f.get(Integer.valueOf(i));
                    i.a();
                    f.put(Integer.valueOf(i), i.a(scheduledFuture, hVar2, (long) hVar2.b));
                }
            }
            a = true;
        }
    }

    static void b() {
        for (Integer num : f.keySet()) {
            ScheduledFuture scheduledFuture = (ScheduledFuture) f.get(num);
            if (!(scheduledFuture == null || scheduledFuture.isDone())) {
                scheduledFuture.cancel(true);
            }
        }
        a = false;
        e = null;
        f.clear();
    }

    static void a(int i, int i2) {
        long j = 0;
        synchronized (e) {
            h hVar = (h) e.get(Integer.valueOf(i));
            if (hVar == null) {
                if (i2 > 0) {
                    Runnable hVar2 = new h(i, i2 * 1000);
                    e.put(Integer.valueOf(i), hVar2);
                    ScheduledFuture scheduledFuture = (ScheduledFuture) f.get(Integer.valueOf(i));
                    i.a();
                    f.put(Integer.valueOf(i), i.a(scheduledFuture, hVar2, (long) hVar2.b));
                }
            } else if (i2 <= 0) {
                e.remove(Integer.valueOf(i));
            } else if (hVar.b != i2 * 1000) {
                hVar.b = i2 * 1000;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = ((long) hVar.b) - (currentTimeMillis - hVar.d);
                if (j2 >= 0) {
                    j = j2;
                }
                ScheduledFuture scheduledFuture2 = (ScheduledFuture) f.get(Integer.valueOf(i));
                i.a();
                i.a(scheduledFuture2, hVar, j);
                f.put(Integer.valueOf(i), scheduledFuture2);
                hVar.d = currentTimeMillis;
            }
        }
    }

    private h(int i, int i2) {
        this.c = i;
        this.b = i2;
        this.d = System.currentTimeMillis();
    }

    public final void run() {
        af.a("CommitTask", "check&commit event", Integer.valueOf(this.c));
        d.a().a(this.c);
        if (e.containsValue(this)) {
            this.d = System.currentTimeMillis();
            ScheduledFuture scheduledFuture = (ScheduledFuture) f.get(Integer.valueOf(this.c));
            i.a();
            f.put(Integer.valueOf(this.c), i.a(scheduledFuture, this, (long) this.b));
        }
    }

    static void c() {
        for (com.alibaba.appmonitor.f.h hVar : com.alibaba.appmonitor.f.h.values()) {
            d.a().a(hVar.d);
        }
    }
}
