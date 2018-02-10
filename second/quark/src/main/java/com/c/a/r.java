package com.c.a;

import com.c.a.a.f;
import com.c.a.b.b.c;
import com.c.a.b.c.l;
import com.c.a.e.b;
import com.c.a.f.a;
import com.c.a.f.d;
import com.c.a.f.h;

/* compiled from: ProGuard */
public final class r {
    boolean a;
    c b;
    l c;
    l d;
    s e;
    x f;
    a g;
    private h h;
    private ae i;
    private k j;

    private r(aa aaVar) {
        this.i = new ae();
        this.j = new k();
        this.f = new b(this);
        this.g = new ab(this);
        this.b = aaVar.a;
        this.c = aaVar.b;
        this.h = aaVar.c;
    }

    final d a(f fVar, int i) {
        d dVar = null;
        if (fVar != null) {
            float f = Float.MAX_VALUE;
            for (a aVar : this.h.a) {
                d dVar2;
                float f2;
                if (aVar instanceof d) {
                    d dVar3 = (d) aVar;
                    float a = dVar3.a();
                    if (a != Float.MAX_VALUE && a <= f) {
                        float f3 = a;
                        dVar2 = dVar3;
                        f2 = f3;
                        f = f2;
                        dVar = dVar2;
                    }
                }
                f2 = f;
                dVar2 = dVar;
                f = f2;
                dVar = dVar2;
            }
            switch (i) {
                case 1:
                    ae aeVar = this.i;
                    if (aeVar.a != dVar) {
                        aeVar.b = System.currentTimeMillis();
                    }
                    aeVar.a = dVar;
                    b.a.postDelayed(this.i, 100);
                    break;
                case 2:
                    if (f != Float.MAX_VALUE) {
                        this.j.b = fVar;
                        this.j.a = dVar;
                        b.a.post(this.j);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return dVar;
    }
}
