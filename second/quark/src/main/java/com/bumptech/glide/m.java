package com.bumptech.glide;

import android.support.v4.d.q;
import com.bumptech.glide.b.a.h;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.c.ar;
import com.bumptech.glide.b.c.au;
import com.bumptech.glide.b.d.f.f;
import com.bumptech.glide.b.n;
import com.bumptech.glide.b.o;
import com.bumptech.glide.e.b;
import com.bumptech.glide.e.c;
import com.bumptech.glide.e.d;
import com.bumptech.glide.e.e;
import com.bumptech.glide.e.g;
import com.bumptech.glide.e.i;
import java.util.List;

/* compiled from: ProGuard */
public final class m {
    public final au a = new au(this.j);
    public final b b = new b();
    public final g c = new g();
    public final i d = new i();
    public final h e = new h();
    public final f f = new f();
    final c g = new c();
    public final e h = new e();
    public final d i = new d();
    public final q<List<Exception>> j = com.bumptech.glide.util.a.h.a();

    public final <Data> m a(Class<Data> cls, com.bumptech.glide.b.c<Data> cVar) {
        this.b.a(cls, cVar);
        return this;
    }

    public final <Data, TResource> m a(Class<Data> cls, Class<TResource> cls2, n<Data, TResource> nVar) {
        this.c.a(nVar, cls, cls2);
        return this;
    }

    public final <Data, TResource> m b(Class<Data> cls, Class<TResource> cls2, n<Data, TResource> nVar) {
        this.c.b(nVar, cls, cls2);
        return this;
    }

    public final <TResource> m a(Class<TResource> cls, o<TResource> oVar) {
        this.d.a(cls, oVar);
        return this;
    }

    public final m a(com.bumptech.glide.b.a.d dVar) {
        this.e.a(dVar);
        return this;
    }

    public final <TResource, Transcode> m a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.b.d.f.d<TResource, Transcode> dVar) {
        this.f.a(cls, cls2, dVar);
        return this;
    }

    public final <Model, Data> m a(Class<Model> cls, Class<Data> cls2, ar<Model, Data> arVar) {
        this.a.a(cls, cls2, arVar);
        return this;
    }

    public final <Model> List<aq<Model, ?>> a(Model model) {
        List<aq<Model, ?>> a = this.a.a((Object) model);
        if (!a.isEmpty()) {
            return a;
        }
        throw new j(model);
    }

    public final List<com.bumptech.glide.b.g> a() {
        List<com.bumptech.glide.b.g> a = this.g.a();
        if (!a.isEmpty()) {
            return a;
        }
        throw new i();
    }
}
