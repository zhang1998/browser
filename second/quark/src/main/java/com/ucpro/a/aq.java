package com.ucpro.a;

import com.uc.a.d.l;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class aq implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ am b;

    aq(am amVar, String str) {
        this.b = amVar;
        this.a = str;
    }

    public final void run() {
        m.a(0, new aj(this.b, l.a(this.a)));
    }
}
