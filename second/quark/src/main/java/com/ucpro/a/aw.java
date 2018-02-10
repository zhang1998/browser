package com.ucpro.a;

import com.uc.a.d.l;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class aw implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ am b;

    aw(am amVar, String str) {
        this.b = amVar;
        this.a = str;
    }

    public final void run() {
        m.a(0, new ar(this.b, l.a(this.a)));
    }
}
