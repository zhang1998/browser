package com.ucpro.feature.webwindow.b;

import com.ucpro.ui.g.h;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class l implements com.ucpro.ui.g.l {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (u.c == i) {
            if (this.a.a != null) {
                this.a.a.a(true);
            }
        } else if (u.d == i && this.a.a != null) {
            this.a.a.a(false);
        }
        return false;
    }
}
