package com.ucpro.feature.aa.a;

import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        this.a.s_().b(true);
        this.a.i();
        m.a(2, new l(this.a), 150);
    }
}
