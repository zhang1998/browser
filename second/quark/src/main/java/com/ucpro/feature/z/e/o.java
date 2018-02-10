package com.ucpro.feature.z.e;

import com.ucpro.feature.z.e.a.f;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void run() {
        f fVar = new f();
        fVar.c();
        n.a(this.a, fVar.a() + "data");
    }
}
