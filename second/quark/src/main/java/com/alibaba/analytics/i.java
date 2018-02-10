package com.alibaba.analytics;

import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
public final class i implements Runnable {
    public final void run() {
        try {
            af.b("延时启动任务", new Object[0]);
            synchronized (c.j) {
                int g = c.m();
                if (g > 0) {
                    af.b("delay " + g + " second to start service,waiting...", new Object[0]);
                    try {
                        c.j.wait((long) (g * 1000));
                    } catch (Exception e) {
                    }
                }
            }
            c.w = c.h();
            c.b.postAtFrontOfQueue(new p());
        } catch (Throwable th) {
            af.d("AnalyticsMgr", "6", th);
        }
    }
}
