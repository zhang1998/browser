package com.ucpro.feature.inputenhance;

import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ af b;

    h(af afVar, a aVar) {
        this.b = afVar;
        this.a = aVar;
    }

    public final void run() {
        this.a.f = Integer.valueOf(com.ucpro.feature.inputenhance.a.a.a(this.b.b).height());
    }
}
