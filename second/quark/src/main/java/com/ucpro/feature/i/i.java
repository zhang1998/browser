package com.ucpro.feature.i;

import android.app.Activity;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.o;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class i implements o {
    final /* synthetic */ k a;

    i(k kVar) {
        this.a = kVar;
    }

    public final void a(g gVar) {
        if ((gVar instanceof bb) && ((bb) gVar).G() && a.a()) {
            this.a.a((Activity) gVar.getContext(), 0);
        }
    }

    public final void b(g gVar) {
        if ((gVar instanceof bb) && a.a()) {
            this.a.a((Activity) gVar.getContext(), a.c("status_bar_color"));
        }
    }
}
