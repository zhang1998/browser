package com.ucpro.services.d.a;

import java.util.List;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ u b;

    q(u uVar, List list) {
        this.b = uVar;
        this.a = list;
    }

    public final void run() {
        this.b.c.a(this.a);
    }
}
