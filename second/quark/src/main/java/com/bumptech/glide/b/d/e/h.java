package com.bumptech.glide.b.d.e;

import com.bumptech.glide.b.b.aq;
import com.bumptech.glide.b.d.c.a;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
public final class h extends a<f> implements aq {
    public h(f fVar) {
        super(fVar);
    }

    public final Class<f> a() {
        return f.class;
    }

    public final int c() {
        n nVar = ((f) this.a).a.b;
        return l.a(nVar.b().getWidth(), nVar.b().getHeight(), nVar.b().getConfig()) + nVar.a.g();
    }

    public final void d() {
        ((f) this.a).stop();
        f fVar = (f) this.a;
        fVar.b = true;
        n nVar = fVar.a.b;
        nVar.c.clear();
        nVar.d();
        nVar.e = false;
        if (nVar.g != null) {
            nVar.d.a(nVar.g);
            nVar.g = null;
        }
        if (nVar.i != null) {
            nVar.d.a(nVar.i);
            nVar.i = null;
        }
        nVar.a.i();
        nVar.h = true;
    }

    public final void e() {
        ((f) this.a).a().prepareToDraw();
    }
}
