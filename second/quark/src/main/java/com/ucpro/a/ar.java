package com.ucpro.a;

import com.uc.base.b.c.b.c;
import com.ucpro.business.d.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class ar implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ am b;

    ar(am amVar, byte[] bArr) {
        this.b = amVar;
        this.a = bArr;
    }

    public final void run() {
        c eVar = new e();
        if (com.uc.a.d.e.a(this.a, eVar)) {
            m.a(2, new az(this, eVar.c()));
        }
    }
}
