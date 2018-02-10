package com.ucpro.feature.inputenhance;

import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class ar extends a {
    final /* synthetic */ al a;

    ar(al alVar) {
        this.a = alVar;
    }

    public final void run() {
        this.a.a.c.c = false;
        if (this.a.a.c.isShowing()) {
            boolean z;
            g b = this.a.a.c;
            if (b.e.getCurrentState() == b.e.a) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.a.a.c.e.getSlideView().b && com.ucweb.common.util.j.a.b("058B6A44EF6A0F81", true)) {
                this.a.a.j.a();
                com.ucweb.common.util.j.a.a("058B6A44EF6A0F81", false);
            }
        }
    }
}
