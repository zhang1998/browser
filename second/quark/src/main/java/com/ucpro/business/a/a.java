package com.ucpro.business.a;

import com.ucpro.business.a.e.c;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ c a;

    a(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        if (this.a.g != null && this.a.g.getParent() == null) {
            this.a.s_().a(this.a.g);
            com.ucpro.business.a.e.a b = this.a.g;
            g eVar = new e(this);
            b.a.b();
            b.a.a(new c(b, eVar));
        }
    }
}
