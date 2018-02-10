package com.alibaba.analytics.core.c;

import com.alibaba.appmonitor.d.a;
import com.alibaba.appmonitor.d.d;
import com.alibaba.appmonitor.f.h;

/* compiled from: ProGuard */
public final class e implements d {
    private static e a = new e();

    public static e a() {
        return a;
    }

    public final void a(i iVar) {
        if (iVar.m == h.COUNTER) {
            a.a("AppMonitor", iVar.l, iVar.n, iVar.o.doubleValue());
        } else if (iVar.m == h.STAT) {
            d.a("AppMonitor", iVar.l, iVar.p, iVar.q);
        }
    }
}
