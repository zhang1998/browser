package com.alibaba.analytics.core.a;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.f.g;

/* compiled from: ProGuard */
final class k implements g {
    final /* synthetic */ f a;

    k(f fVar) {
        this.a = fVar;
    }

    public final void a(long j, long j2) {
        af.a("RealTimeMode", "count", Long.valueOf(j), "dbSize", Long.valueOf(j2));
        if (j > 0 && j2 > 0 && d.REALTIME == this.a.c) {
            f fVar = this.a;
            i.a();
            fVar.e = i.a(null, this.a.g, 0);
        }
    }
}
