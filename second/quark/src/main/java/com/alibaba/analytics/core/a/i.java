package com.alibaba.analytics.core.a;

import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
final class i extends h {
    final /* synthetic */ f a;

    i(f fVar, c cVar) {
        this.a = fVar;
        super(cVar);
    }

    public final void a(long j) {
        if (d.INTERVAL == this.a.c) {
            this.a.b = this.a.f();
            af.a(null, "mCurrentUploadInterval", Long.valueOf(this.a.b));
            this.d = this.a.i;
            f fVar = this.a;
            com.alibaba.analytics.a.i.a();
            fVar.e = com.alibaba.analytics.a.i.a(this.a.e, this, this.a.b);
        }
    }
}
