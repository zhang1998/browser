package com.ucpro.feature.webwindow.c;

import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class j implements l {
    final /* synthetic */ k a;

    j(k kVar) {
        this.a = kVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (this.a.b != null) {
            if (u.c == i) {
                this.a.b.confirm();
            } else if (u.d == i) {
                this.a.b.cancel();
            }
            a.a();
            this.a.a.dismiss();
        }
        return true;
    }
}
