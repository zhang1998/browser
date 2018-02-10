package com.ucpro.feature.i;

import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public final class j implements Runnable {
    final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        m.a("app", "status_bar_type", "type", String.valueOf(this.a.b));
    }
}
