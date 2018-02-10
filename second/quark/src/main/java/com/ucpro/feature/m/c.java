package com.ucpro.feature.m;

import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.webwindow.aj;
import java.util.Iterator;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        b b = a.b();
        if (!a.a(b)) {
            Iterator it = b.a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Object ajVar = new aj();
                ajVar.o = str;
                ajVar.q = true;
                ajVar.s = aj.l;
                g.a().a(e.k, ajVar);
            }
        }
        a.a(false);
    }
}
