package com.ucpro.services.download.b;

import com.uc.quark.x;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ d a;

    c(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        x.a();
        if (x.k()) {
            x.a();
            if (x.l().length == 0) {
                return;
            }
        }
        d.a(this.a);
    }
}
