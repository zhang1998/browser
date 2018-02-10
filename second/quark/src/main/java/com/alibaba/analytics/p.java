package com.alibaba.analytics;

import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
public final class p implements Runnable {
    public final void run() {
        try {
            if (c.w) {
                af.b("delay 30 sec to wait the Remote service connected,waiting...", new Object[0]);
                synchronized (c.c) {
                    try {
                        c.c.wait(30000);
                    } catch (Exception e) {
                    }
                }
            }
            if (c.a == null) {
                af.b("cannot get remote analytics object,new local object", new Object[0]);
                c.l();
            }
            new j().run();
        } catch (Throwable th) {
            af.d("AnalyticsMgr", "7", th);
        }
    }
}
