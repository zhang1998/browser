package com.alibaba.analytics.core.a;

/* compiled from: ProGuard */
final class l extends h {
    final /* synthetic */ f a;

    l(f fVar, c cVar) {
        this.a = fVar;
        super(cVar);
    }

    public final void a(long j) {
        this.a.k = j;
        if (d.LAUNCH == this.a.c && this.a.k >= this.a.l) {
            this.a.e.cancel(false);
        }
    }
}
