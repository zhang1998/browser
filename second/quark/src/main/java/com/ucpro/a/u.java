package com.ucpro.a;

import com.uc.a.d.l;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ am b;

    u(am amVar, String str) {
        this.b = amVar;
        this.a = str;
    }

    public final void run() {
        m.a(0, new v(this.b, l.a(this.a)));
    }
}
