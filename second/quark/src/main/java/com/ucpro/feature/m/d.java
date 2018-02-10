package com.ucpro.feature.m;

import com.uc.base.b.c.i;
import com.ucpro.feature.m.a.b;
import com.ucweb.common.util.h.a;
import java.util.Iterator;

/* compiled from: ProGuard */
final class d extends a {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        b bVar = (b) this.f;
        if (!(bVar == null || bVar.a == null)) {
            i bVar2 = new b();
            bVar2.c = true;
            Iterator it = bVar.a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                com.ucpro.feature.m.a.a aVar = new com.ucpro.feature.m.a.a();
                aVar.b = str;
                bVar2.b.add(aVar);
            }
            com.uc.browser.b.a("crashrecovery", "recovery_data", bVar2);
        }
        a.a(true);
    }
}
