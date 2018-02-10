package com.uc.base.wa.config;

import com.uc.base.wa.e;
import com.uc.base.wa.e.f;
import com.uc.base.wa.e.i;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class h {
    ArrayList<g> a;

    public final void a(String str, e eVar, i iVar) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            String str2 = gVar.a.a;
            int i = gVar.a.b;
            if (str2 != null) {
                if (gVar.c == 1 && iVar != null) {
                    d a = iVar.a();
                    if (!(a == null || a.a())) {
                        return;
                    }
                }
                com.uc.base.wa.f.e.a(4, new f(i.b(), gVar.g, str2, i, gVar.b, gVar.c, gVar.d, gVar.e, gVar.f, str, eVar));
            }
        }
    }
}
