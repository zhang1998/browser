package com.ucpro.feature.webwindow.c;

import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class g implements l {
    final /* synthetic */ c a;

    g(c cVar) {
        this.a = cVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (this.a.c != null) {
            if (u.c == i) {
                this.a.c.invoke(this.a.b, true, true);
                this.a.d = true;
            } else if (u.d == i) {
                this.a.c.invoke(this.a.b, false, true);
                this.a.d = true;
            }
        }
        return false;
    }
}
