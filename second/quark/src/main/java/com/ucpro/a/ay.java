package com.ucpro.a;

import com.uc.a.d.l;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class ay implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ am b;

    ay(am amVar, String str) {
        this.b = amVar;
        this.a = str;
    }

    public final void run() {
        byte[] a = l.a(this.a);
        if (a == null || a.length <= 0) {
            am.a(this.b, "mannualadblock/mannualadblock", new ap(this));
        } else {
            m.a(0, new aa(this.b, a));
        }
    }
}
