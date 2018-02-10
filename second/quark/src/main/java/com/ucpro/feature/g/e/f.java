package com.ucpro.feature.g.e;

import com.uc.sync.f.l;
import com.ucpro.feature.g.e.a.c;

/* compiled from: ProGuard */
public final class f extends l {
    public String m;
    public String n;
    public int o;
    public long p;

    public final void a(f fVar) {
        super.a((l) fVar);
        this.m = fVar.m;
        this.n = fVar.n;
        this.o = fVar.o;
        this.p = fVar.p;
    }

    public static f a(c cVar) {
        l fVar = new f();
        fVar.e = cVar.c;
        fVar.j = cVar.a;
        fVar.m = cVar.d;
        fVar.n = cVar.e;
        fVar.a(cVar.f);
        fVar.p = cVar.i;
        fVar.o = cVar.h;
        return fVar;
    }
}
