package com.ucpro.feature.q;

import com.uc.n;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        String c = this.a.c;
        if (n.a.a()) {
            n.a.b(c);
        }
        c = this.a.c;
        if (n.a.a()) {
            n.a.c(c);
        }
        this.a.c = "";
    }
}
