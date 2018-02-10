package com.ucpro.base.weex.component;

import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ h a;
    private Set<g> b = this.a.f;

    i(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        if (!this.a.g) {
            this.a.g = true;
            this.a.h.removeCallbacksAndMessages(null);
            this.a.f = new HashSet();
            for (g gVar : this.b) {
                gVar.b.run();
            }
        }
    }
}
