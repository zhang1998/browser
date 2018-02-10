package com.uc.base.wa.b;

import android.util.Log;
import com.uc.base.wa.a.c;
import java.util.Iterator;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ g c;

    d(g gVar, boolean z, boolean z2) {
        this.c = gVar;
        this.a = z;
        this.b = z2;
    }

    public final void run() {
        g gVar = this.c;
        boolean z = this.a;
        boolean z2 = this.b;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            g.a();
            long currentTimeMillis2 = System.currentTimeMillis();
            synchronized (g.a) {
                Iterator it = g.a.iterator();
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 == null) {
                        c.a().b(null);
                    } else if (currentTimeMillis2 - gVar2.e > gVar.h.k) {
                        try {
                            synchronized (gVar2) {
                                int size;
                                if (gVar2.f != null) {
                                    size = gVar2.f.size() + gVar2.i;
                                } else {
                                    size = gVar2.i;
                                }
                                if (size > gVar.h.j) {
                                    long a = gVar.a(currentTimeMillis, com.uc.base.wa.c.c.a(gVar2.h.h), gVar2.h.h(gVar2.d), gVar2.f, gVar2.g);
                                    gVar2.a(true);
                                    g.c = (int) (((long) g.c) - a);
                                    gVar2.e = currentTimeMillis;
                                }
                            }
                        } catch (Throwable e) {
                            Log.e("gzm_wa_WaCache", "waCacheCats = " + g.a, e);
                            c.a().b(e.toString());
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z2) {
            g.a(gVar.h.h);
            synchronized (gVar) {
                int size2;
                if (gVar.f != null) {
                    size2 = gVar.f.size() + gVar.i;
                } else {
                    size2 = gVar.i;
                }
                if (size2 >= gVar.h.i) {
                    a = gVar.a(currentTimeMillis, com.uc.base.wa.c.c.a(gVar.h.h), gVar.h.h(gVar.d), gVar.f, gVar.g);
                    gVar.a(true);
                    g.c = (int) (((long) g.c) - a);
                    gVar.e = currentTimeMillis;
                }
            }
        }
    }
}
