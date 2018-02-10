package com.alibaba.analytics;

import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
final class j implements Runnable {
    j() {
    }

    public final void run() {
        af.b("call Remote init start...", new Object[0]);
        try {
            c.a.a();
        } catch (Throwable th) {
            af.b("initut error", th, new Object[0]);
        }
        af.b("call Remote init end", new Object[0]);
    }
}
