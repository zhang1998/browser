package com.ucpro.business.e.g;

import com.uc.a.e;
import com.uc.a.f.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ d b;

    c(d dVar, boolean z) {
        this.b = dVar;
        this.a = z;
    }

    public final void run() {
        a a = this.b.a;
        boolean z = this.a;
        new StringBuilder("[dispatcher] try request(force=").append(z).append(")");
        if (!z) {
            Object obj;
            if (System.currentTimeMillis() - a.c.a.getLong("__last_update", 0) >= a.a.k) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                new StringBuilder("[dispatcher] request blocked by minimal interval (").append(((float) a.a.k) / 60000.0f).append("min)");
                return;
            }
        }
        a.b.a(e.b);
    }
}
