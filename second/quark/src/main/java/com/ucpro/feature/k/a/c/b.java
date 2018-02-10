package com.ucpro.feature.k.a.c;

import android.graphics.Bitmap;
import com.ucpro.business.stat.m;
import com.ucpro.feature.k.a;
import com.ucpro.feature.x.e;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class b implements l {
    final /* synthetic */ boolean a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ int c;
    final /* synthetic */ g d;

    b(g gVar, boolean z, Bitmap bitmap, int i) {
        this.d = gVar;
        this.a = z;
        this.b = bitmap;
        this.c = i;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == u.c) {
            g.b(this.a, this.b, this.c);
            e.b(this.b, this.a);
            m.a("quark_lab", a.h, new String[0]);
        } else {
            g.b(this.a, this.b, this.c);
            m.a("quark_lab", a.i, new String[0]);
        }
        return false;
    }
}
