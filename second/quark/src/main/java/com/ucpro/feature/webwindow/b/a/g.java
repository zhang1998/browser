package com.ucpro.feature.webwindow.b.a;

import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class g implements l {
    final /* synthetic */ l a;

    g(l lVar) {
        this.a = lVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (u.c == i) {
            if (this.a.g != null) {
                this.a.g.b(true);
            }
        } else if (u.d == i && this.a.g != null) {
            this.a.g.b(false);
        }
        return false;
    }
}
