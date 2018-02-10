package com.ucpro.feature.navigation;

import com.uc.browser.a;
import com.uc.browser.b;
import com.ucpro.feature.navigation.b.g;
import com.ucpro.feature.navigation.b.j;
import com.ucpro.feature.navigation.b.r;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ o a;

    h(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        j jVar;
        o oVar = this.a;
        try {
            jVar = (j) b.a("navigation", "data", j.class);
        } catch (a e) {
            jVar = null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            jVar = null;
        }
        if (jVar == null || (jVar.b.size() == 0 && !jVar.c)) {
            jVar = o.a();
            if (jVar == null) {
                boolean z;
                long currentTimeMillis = System.currentTimeMillis();
                j jVar2 = new j();
                int i = 0;
                while (i < com.ucpro.feature.navigation.b.h.b().length) {
                    g gVar = new g();
                    gVar.b = com.ucpro.feature.navigation.b.h.b()[i];
                    gVar.c = com.ucpro.feature.navigation.b.h.a()[i];
                    long j = 1 + currentTimeMillis;
                    gVar.f = currentTimeMillis;
                    gVar.g = 0;
                    jVar2.b.add(gVar);
                    i++;
                    currentTimeMillis = j;
                }
                if (jVar2.b.size() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                jVar2.c = z;
                m.a(0, new i(oVar, jVar2));
                m.a(0, new b(oVar, jVar2));
                jVar = jVar2;
            }
        }
        if (!m.c()) {
            m.a(2, new r(oVar, jVar));
        } else if (oVar.a != null) {
            oVar.a.a(new r(jVar));
        }
    }
}
