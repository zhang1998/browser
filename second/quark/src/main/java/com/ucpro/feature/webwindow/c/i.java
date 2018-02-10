package com.ucpro.feature.webwindow.c;

import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.x;

/* compiled from: ProGuard */
final class i implements l {
    final /* synthetic */ l a;

    i(l lVar) {
        this.a = lVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (this.a.b != null && x.a == i) {
            this.a.b.confirm();
        }
        a.a();
        this.a.a.dismiss();
        return true;
    }
}
