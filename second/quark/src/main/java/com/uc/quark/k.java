package com.uc.quark;

import com.uc.quark.filedownloader.aa;
import com.uc.quark.filedownloader.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class k {
    static volatile boolean b = true;
    final Object a;
    ArrayList<h> c;
    ArrayList<h> d;
    j e;
    private m f;
    private Runnable g;

    protected static void a() {
        b = true;
    }

    private k() {
        this.a = new Object();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.g = new l(this);
    }

    public static k b() {
        return p.a;
    }

    public final m c() {
        if (this.f == null) {
            this.f = new b(this);
        }
        return this.f;
    }

    static /* synthetic */ void a(k kVar, aa aaVar, int i, long j, long j2, int i2) {
        synchronized (kVar.a) {
            if (aaVar.w() instanceof s) {
                h hVar = ((s) aaVar.w()).d;
                s sVar;
                if (hVar != null) {
                    b = true;
                    sVar = (s) aaVar.w();
                    sVar.a(aaVar.r());
                    if (i == 7) {
                        sVar.a(i2);
                    }
                    if (i == -1) {
                        sVar.a(aaVar.u());
                    }
                    hVar.a(sVar, i, j, j2);
                    if (kVar.d.size() > 0) {
                        com.uc.quark.a.m.a(0, kVar.g);
                    }
                } else {
                    Iterator it = kVar.c.iterator();
                    b = kVar.c.size() > 0;
                    while (it.hasNext()) {
                        hVar = (h) it.next();
                        if (hVar != null) {
                            sVar = (s) aaVar.w();
                            sVar.a(aaVar.r());
                            if (i == 7) {
                                sVar.a(i2);
                            }
                            if (i == -1) {
                                sVar.a(aaVar.u());
                            }
                            hVar.a(sVar, i, j, j2);
                        }
                        if (kVar.d.contains(hVar)) {
                            it.remove();
                            kVar.d.remove(hVar);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ boolean a(aa aaVar) {
        if ((aaVar.w() instanceof s) && (((s) aaVar.w()).l() || aaVar.v())) {
            return true;
        }
        return false;
    }
}
