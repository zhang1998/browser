package com.ucpro.a;

import com.uc.a.d.l;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class av implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ am b;

    av(am amVar, String str) {
        this.b = amVar;
        this.a = str;
    }

    public final void run() {
        m.a(0, new an(this.b, l.a(this.a)));
    }
}
