package com.bumptech.glide.b.b;

import com.bumptech.glide.b.a;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.o;
import com.bumptech.glide.b.p;
import com.bumptech.glide.k;
import java.util.List;

/* compiled from: ProGuard */
final class i<Z> implements p<Z> {
    final /* synthetic */ o a;
    private final a b;

    i(o oVar, a aVar) {
        this.a = oVar;
        this.b = aVar;
    }

    public final au<Z> a(au<Z> auVar) {
        p c;
        au<Z> a;
        Object obj;
        Class cls = auVar.b().getClass();
        if (this.b != a.RESOURCE_DISK_CACHE) {
            c = this.a.a.c(cls);
            a = c.a(this.a.e, auVar, this.a.i, this.a.j);
        } else {
            a = auVar;
            c = null;
        }
        if (!auVar.equals(a)) {
            auVar.d();
        }
        if (this.a.a.c.b.d.a(a.a()) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            o a2 = this.a.a.c.b.d.a(a.a());
            if (a2 != null) {
                o oVar = a2;
                d a3 = a2.a(this.a.l);
            } else {
                throw new k(a.a());
            }
        }
        oVar = null;
        a3 = d.NONE;
        f fVar = this.a.a;
        com.bumptech.glide.b.i iVar = this.a.q;
        List b = fVar.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (((ap) b.get(i)).a.equals(iVar)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (!this.a.k.a(obj == null, this.b, a3)) {
            return a;
        }
        if (oVar == null) {
            throw new k(a.b().getClass());
        }
        com.bumptech.glide.b.i bVar;
        if (a3 == d.SOURCE) {
            bVar = new b(this.a.q, this.a.f);
        } else if (a3 == d.TRANSFORMED) {
            bVar = new aw(this.a.q, this.a.f, this.a.i, this.a.j, c, cls, this.a.l);
        } else {
            throw new IllegalArgumentException("Unknown strategy: " + a3);
        }
        au a4 = at.a(a);
        j jVar = this.a.c;
        jVar.a = bVar;
        jVar.b = oVar;
        jVar.c = a4;
        return a4;
    }
}
