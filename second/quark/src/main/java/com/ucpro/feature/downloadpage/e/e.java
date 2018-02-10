package com.ucpro.feature.downloadpage.e;

import com.uc.quark.s;
import com.ucpro.ui.g.g;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import java.util.List;

/* compiled from: ProGuard */
final class e implements l {
    final /* synthetic */ List a;
    final /* synthetic */ g b;
    final /* synthetic */ o c;

    e(o oVar, List list, g gVar) {
        this.c = oVar;
        this.a = list;
        this.b = gVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == h.c && this.a != null) {
            for (s a : this.a) {
                this.c.a(a.a(), this.b.a.isSelected());
            }
            this.c.a();
            this.c.q();
        }
        return false;
    }
}
