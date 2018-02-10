package com.ucpro.feature.g.b;

import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.g.g.b;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class a implements l {
    final /* synthetic */ o a;

    a(o oVar) {
        this.a = oVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == u.c) {
            com.ucpro.feature.g.g.a a = b.a;
            synchronized (a.a) {
                a.a.edit().clear().apply();
            }
            g.a().a(e.bY);
        }
        return false;
    }
}
