package com.bumptech.glide.b.b;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.d.q;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.b.c.g;
import com.bumptech.glide.b.i;
import com.bumptech.glide.f.h;
import com.bumptech.glide.util.a.f;
import com.bumptech.glide.util.a.j;
import com.bumptech.glide.util.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class ai<R> implements h<R>, f {
    private static final ag p = new ag();
    private static final Handler q = new Handler(Looper.getMainLooper(), new ah());
    public final List<h> a;
    public final j b;
    public final aj c;
    public final g d;
    public i e;
    public boolean f;
    public boolean g;
    au<?> h;
    a i;
    public boolean j;
    public boolean k;
    public List<h> l;
    an<?> m;
    public o<R> n;
    public volatile boolean o;
    private final q<ai<?>> r;
    private final ag s;
    private final g t;
    private final g u;
    private ap v;

    ai(g gVar, g gVar2, g gVar3, aj ajVar, q<ai<?>> qVar) {
        this(gVar, gVar2, gVar3, ajVar, qVar, p);
    }

    private ai(g gVar, g gVar2, g gVar3, aj ajVar, q<ai<?>> qVar, ag agVar) {
        this.a = new ArrayList(2);
        this.b = new com.bumptech.glide.util.a.i();
        this.d = gVar;
        this.t = gVar2;
        this.u = gVar3;
        this.c = ajVar;
        this.r = qVar;
        this.s = agVar;
    }

    public final void a(h hVar) {
        l.a();
        this.b.a();
        if (this.j) {
            hVar.a(this.m, this.i);
        } else if (this.k) {
            hVar.a(this.v);
        } else {
            this.a.add(hVar);
        }
    }

    public final g b() {
        return this.g ? this.u : this.t;
    }

    final boolean b(h hVar) {
        return this.l != null && this.l.contains(hVar);
    }

    final void c() {
        l.a();
        this.a.clear();
        this.e = null;
        this.m = null;
        this.h = null;
        if (this.l != null) {
            this.l.clear();
        }
        this.k = false;
        this.o = false;
        this.j = false;
        o oVar = this.n;
        if (oVar.d.a()) {
            oVar.b();
        }
        this.n = null;
        this.v = null;
        this.i = null;
        this.r.a(this);
    }

    public final void a(au<R> auVar, a aVar) {
        this.h = auVar;
        this.i = aVar;
        q.obtainMessage(1, this).sendToTarget();
    }

    public final void a(ap apVar) {
        this.v = apVar;
        q.obtainMessage(2, this).sendToTarget();
    }

    public final void a(o<?> oVar) {
        b().execute(oVar);
    }

    final void d() {
        this.b.a();
        if (this.o) {
            c();
        } else if (this.a.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (this.k) {
            throw new IllegalStateException("Already failed once");
        } else {
            this.k = true;
            this.c.a(this.e, null);
            for (h hVar : this.a) {
                if (!b(hVar)) {
                    hVar.a(this.v);
                }
            }
            c();
        }
    }

    public final j m_() {
        return this.b;
    }
}
