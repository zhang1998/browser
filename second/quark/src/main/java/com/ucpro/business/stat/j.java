package com.ucpro.business.stat;

import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.o;
import com.ucpro.business.stat.a.c;
import com.ucpro.business.stat.a.d;

/* compiled from: ProGuard */
public final class j implements o {
    public boolean a = false;

    public final void a(g gVar) {
        System.currentTimeMillis();
        a(gVar, true);
    }

    public final void b(g gVar) {
        System.currentTimeMillis();
        a(gVar, false);
    }

    private static void a(g gVar, boolean z) {
        if (gVar != null) {
            d dVar;
            if (gVar instanceof d) {
                dVar = (d) gVar;
            } else if (gVar instanceof c) {
                dVar = ((c) gVar).getCurUtPage();
            } else {
                Object obj = null;
            }
            if (dVar != null && z) {
                o.a(dVar);
            }
        }
    }
}
