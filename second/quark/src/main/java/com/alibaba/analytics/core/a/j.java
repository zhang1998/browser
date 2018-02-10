package com.alibaba.analytics.core.a;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.f.g;

/* compiled from: ProGuard */
final class j implements g {
    final /* synthetic */ h a;
    final /* synthetic */ f b;

    j(f fVar, h hVar) {
        this.b = fVar;
        this.a = hVar;
    }

    public final void a(long j, long j2) {
        af.a("BatchMode", "count", Long.valueOf(j), "dbSize", Long.valueOf(j2));
        if (j2 >= this.b.h && d.BATCH == this.b.c) {
            this.a.d = this.b.i;
            f fVar = this.b;
            i.a();
            fVar.e = i.a(this.b.e, this.a, 0);
        }
    }
}
