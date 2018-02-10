package com.bumptech.glide.f;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.a.a;
import android.support.v4.d.q;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import com.bumptech.glide.b.b.ac;
import com.bumptech.glide.b.b.ae;
import com.bumptech.glide.b.b.af;
import com.bumptech.glide.b.b.ai;
import com.bumptech.glide.b.b.ak;
import com.bumptech.glide.b.b.an;
import com.bumptech.glide.b.b.ap;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.b.n;
import com.bumptech.glide.b.b.o;
import com.bumptech.glide.b.b.w;
import com.bumptech.glide.b.b.y;
import com.bumptech.glide.b.m;
import com.bumptech.glide.e;
import com.bumptech.glide.f.a.g;
import com.bumptech.glide.f.b.d;
import com.bumptech.glide.util.a.f;
import com.bumptech.glide.util.a.h;
import com.bumptech.glide.util.a.i;
import com.bumptech.glide.util.a.j;
import com.bumptech.glide.util.l;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ProGuard */
public final class k<R> implements g, b, h, f {
    private static final q<k<?>> a = h.a(new i());
    private static boolean y = true;
    private final String b = String.valueOf(hashCode());
    private final j c = new i();
    private c d;
    private e e;
    private Object f;
    private Class<R> g;
    private g h;
    private int i;
    private int j;
    private com.bumptech.glide.g k;
    private com.bumptech.glide.f.a.h<R> l;
    private f<R> m;
    private af n;
    private d<? super R> o;
    private au<R> p;
    private ac q;
    private long r;
    private int s;
    private Drawable t;
    private Drawable u;
    private Drawable v;
    private int w;
    private int x;

    public static <R> k<R> a(e eVar, Object obj, Class<R> cls, g gVar, int i, int i2, com.bumptech.glide.g gVar2, com.bumptech.glide.f.a.h<R> hVar, f<R> fVar, c cVar, af afVar, d<? super R> dVar) {
        k<R> kVar = (k) a.a();
        if (kVar == null) {
            kVar = new k();
        }
        kVar.e = eVar;
        kVar.f = obj;
        kVar.g = cls;
        kVar.h = gVar;
        kVar.i = i;
        kVar.j = i2;
        kVar.k = gVar2;
        kVar.l = hVar;
        kVar.m = fVar;
        kVar.d = cVar;
        kVar.n = afVar;
        kVar.o = dVar;
        kVar.s = j.a;
        return kVar;
    }

    k() {
    }

    public final j m_() {
        return this.c;
    }

    public final void i() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = -1;
        this.l = null;
        this.m = null;
        this.d = null;
        this.o = null;
        this.q = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = -1;
        this.x = -1;
        a.a(this);
    }

    public final void b() {
        this.c.a();
        this.r = com.bumptech.glide.util.f.a();
        if (this.f == null) {
            if (l.a(this.i, this.j)) {
                this.w = this.i;
                this.x = this.j;
            }
            a(new ap("Received null model"), k() == null ? 5 : 3);
            return;
        }
        this.s = j.c;
        if (l.a(this.i, this.j)) {
            a(this.i, this.j);
        } else {
            this.l.a((g) this);
        }
        if ((this.s == j.b || this.s == j.c) && l()) {
            this.l.b(j());
        }
        if (Log.isLoggable("Request", 2)) {
            a("finished run method in " + com.bumptech.glide.util.f.a(this.r));
        }
    }

    public final void d() {
        l.a();
        if (this.s != j.g) {
            this.c.a();
            this.l.b((g) this);
            this.s = j.f;
            if (this.q != null) {
                ac acVar = this.q;
                ai aiVar = acVar.a;
                h hVar = acVar.b;
                l.a();
                aiVar.b.a();
                if (aiVar.j || aiVar.k) {
                    if (aiVar.l == null) {
                        aiVar.l = new ArrayList(2);
                    }
                    if (!aiVar.l.contains(hVar)) {
                        aiVar.l.add(hVar);
                    }
                } else {
                    aiVar.a.remove(hVar);
                    if (!(!aiVar.a.isEmpty() || aiVar.k || aiVar.j || aiVar.o)) {
                        aiVar.o = true;
                        o oVar = aiVar.n;
                        oVar.s = true;
                        com.bumptech.glide.b.b.e eVar = oVar.r;
                        if (eVar != null) {
                            eVar.b();
                        }
                        aiVar.c.a(aiVar, aiVar.e);
                    }
                }
                this.q = null;
            }
            if (this.p != null) {
                a(this.p);
            }
            if (l()) {
                this.l.a(j());
            }
            this.s = j.g;
        }
    }

    public final void c() {
        d();
        this.s = j.h;
    }

    public final boolean e() {
        return this.s == j.b || this.s == j.c;
    }

    public final boolean f() {
        return this.s == j.d;
    }

    public final boolean g() {
        return f();
    }

    public final boolean h() {
        return this.s == j.f || this.s == j.g;
    }

    private Drawable j() {
        if (this.u == null) {
            this.u = this.h.f;
            if (this.u == null && this.h.g > 0) {
                this.u = a(this.h.g);
            }
        }
        return this.u;
    }

    private Drawable k() {
        if (this.v == null) {
            this.v = this.h.n;
            if (this.v == null && this.h.o > 0) {
                this.v = a(this.h.o);
            }
        }
        return this.v;
    }

    private Drawable a(@DrawableRes int i) {
        if (y) {
            return b(i);
        }
        return c(i);
    }

    private Drawable b(@DrawableRes int i) {
        try {
            return AppCompatResources.getDrawable(this.e, i);
        } catch (NoClassDefFoundError e) {
            y = false;
            return c(i);
        }
    }

    private Drawable c(@DrawableRes int i) {
        return a.a(this.e.getResources(), i, this.h.t);
    }

    public final void a(int i, int i2) {
        this.c.a();
        if (Log.isLoggable("Request", 2)) {
            a("Got onSizeReady in " + com.bumptech.glide.util.f.a(this.r));
        }
        if (this.s == j.c) {
            au a;
            an anVar;
            ac acVar;
            this.s = j.b;
            float f = this.h.a;
            this.w = a(i, f);
            this.x = a(i2, f);
            if (Log.isLoggable("Request", 2)) {
                a("finished setup for calling load in " + com.bumptech.glide.util.f.a(this.r));
            }
            af afVar = this.n;
            e eVar = this.e;
            Object obj = this.f;
            com.bumptech.glide.b.i iVar = this.h.k;
            int i3 = this.w;
            int i4 = this.x;
            Class cls = this.h.r;
            Class cls2 = this.g;
            com.bumptech.glide.g gVar = this.k;
            w wVar = this.h.b;
            Map map = this.h.q;
            boolean z = this.h.l;
            m mVar = this.h.p;
            boolean z2 = this.h.h;
            boolean z3 = this.h.u;
            boolean z4 = this.h.v;
            l.a();
            long a2 = com.bumptech.glide.util.f.a();
            com.bumptech.glide.b.i akVar = new ak(obj, iVar, i3, i4, map, cls, cls2, mVar);
            if (z2) {
                a = afVar.b.a(akVar);
                if (a == null) {
                    a = null;
                } else if (a instanceof an) {
                    anVar = (an) a;
                } else {
                    Object anVar2 = new an(a, true);
                }
                if (a != null) {
                    a.e();
                    afVar.d.put(akVar, new ae(akVar, a, afVar.a()));
                }
            } else {
                a = null;
            }
            if (a != null) {
                a(a, com.bumptech.glide.b.a.MEMORY_CACHE);
                if (Log.isLoggable("Engine", 2)) {
                    af.a("Loaded resource from cache", a2, akVar);
                }
                acVar = null;
            } else {
                if (z2) {
                    WeakReference weakReference = (WeakReference) afVar.d.get(akVar);
                    if (weakReference != null) {
                        anVar = (an) weakReference.get();
                        if (anVar != null) {
                            anVar.e();
                        } else {
                            afVar.d.remove(akVar);
                        }
                    } else {
                        a = null;
                    }
                } else {
                    a = null;
                }
                if (a != null) {
                    a(a, com.bumptech.glide.b.a.MEMORY_CACHE);
                    if (Log.isLoggable("Engine", 2)) {
                        af.a("Loaded resource from active resources", a2, akVar);
                    }
                    acVar = null;
                } else {
                    ai aiVar = (ai) afVar.a.get(akVar);
                    if (aiVar != null) {
                        aiVar.a((h) this);
                        if (Log.isLoggable("Engine", 2)) {
                            af.a("Added to existing load", a2, akVar);
                        }
                        acVar = new ac(this, aiVar);
                    } else {
                        com.bumptech.glide.b.b.c.g gVar2;
                        aiVar = (ai) afVar.c.e.a();
                        aiVar.e = akVar;
                        aiVar.f = z2;
                        aiVar.g = z3;
                        y yVar = afVar.f;
                        o oVar = (o) yVar.b.a();
                        int i5 = yVar.c;
                        yVar.c = i5 + 1;
                        com.bumptech.glide.b.b.f fVar = oVar.a;
                        k kVar = oVar.b;
                        fVar.c = eVar;
                        fVar.d = obj;
                        fVar.n = iVar;
                        fVar.e = i3;
                        fVar.f = i4;
                        fVar.p = wVar;
                        fVar.g = cls;
                        fVar.h = kVar;
                        fVar.k = cls2;
                        fVar.o = gVar;
                        fVar.i = mVar;
                        fVar.j = map;
                        fVar.q = z;
                        oVar.e = eVar;
                        oVar.f = iVar;
                        oVar.g = gVar;
                        oVar.h = akVar;
                        oVar.i = i3;
                        oVar.j = i4;
                        oVar.k = wVar;
                        oVar.p = z4;
                        oVar.l = mVar;
                        oVar.m = aiVar;
                        oVar.n = i5;
                        oVar.o = com.bumptech.glide.b.b.m.INITIALIZE;
                        afVar.a.put(akVar, aiVar);
                        aiVar.a((h) this);
                        aiVar.n = oVar;
                        n a3 = oVar.a(n.INITIALIZE);
                        if (a3 == n.RESOURCE_CACHE || a3 == n.DATA_CACHE) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            gVar2 = aiVar.d;
                        } else {
                            gVar2 = aiVar.b();
                        }
                        gVar2.execute(oVar);
                        if (Log.isLoggable("Engine", 2)) {
                            af.a("Started new load", a2, akVar);
                        }
                        acVar = new ac(this, aiVar);
                    }
                }
            }
            this.q = acVar;
            if (Log.isLoggable("Request", 2)) {
                a("finished onSizeReady in " + com.bumptech.glide.util.f.a(this.r));
            }
        }
    }

    private static int a(int i, float f) {
        return i == SectionHeader.SHT_LOUSER ? i : Math.round(((float) i) * f);
    }

    private boolean l() {
        return this.d == null || this.d.b(this);
    }

    private boolean m() {
        return this.d == null || !this.d.a();
    }

    public final void a(au<?> auVar, com.bumptech.glide.b.a aVar) {
        this.c.a();
        this.q = null;
        if (auVar == null) {
            a(new ap("Expected to receive a Resource<R> with an object of " + this.g + " inside, but instead got null."), 5);
            return;
        }
        Object b = auVar.b();
        if (b == null || !this.g.isAssignableFrom(b.getClass())) {
            String str;
            a((au) auVar);
            StringBuilder append = new StringBuilder("Expected to receive an object of ").append(this.g).append(" but instead got ").append(b != null ? b.getClass() : "").append("{").append(b).append("} inside Resource{").append(auVar).append("}.");
            if (b != null) {
                str = "";
            } else {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            a(new ap(append.append(str).toString()), 5);
            return;
        }
        Object obj;
        if (this.d == null || this.d.a(this)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            a((au) auVar);
            this.s = j.d;
            return;
        }
        m();
        this.s = j.d;
        this.p = auVar;
        if (this.e.e <= 3) {
            new StringBuilder("Finished loading ").append(b.getClass().getSimpleName()).append(" from ").append(aVar).append(" for ").append(this.f).append(" with size [").append(this.w).append("x").append(this.x).append("] in ").append(com.bumptech.glide.util.f.a(this.r)).append(" ms");
        }
        if (this.m != null) {
            this.m.a(b);
        }
        this.o.a();
        this.l.a(b);
        if (this.d != null) {
            this.d.c(this);
        }
    }

    public final void a(ap apVar) {
        a(apVar, 5);
    }

    private void a(ap apVar, int i) {
        Drawable drawable = null;
        this.c.a();
        int i2 = this.e.e;
        if (i2 <= i) {
            Log.w("Glide", "Load failed for " + this.f + " with size [" + this.w + "x" + this.x + "]", apVar);
            if (i2 <= 4) {
                apVar.a("Glide");
            }
        }
        this.q = null;
        this.s = j.e;
        if (this.m != null) {
            m();
        }
        if (l()) {
            if (this.f == null) {
                drawable = k();
            }
            if (drawable == null) {
                if (this.t == null) {
                    this.t = this.h.d;
                    if (this.t == null && this.h.e > 0) {
                        this.t = a(this.h.e);
                    }
                }
                drawable = this.t;
            }
            if (drawable == null) {
                drawable = j();
            }
            this.l.c(drawable);
        }
    }

    private void a(String str) {
        new StringBuilder().append(str).append(" this: ").append(this.b);
    }

    private void a(au<?> auVar) {
        l.a();
        if (auVar instanceof an) {
            ((an) auVar).f();
            this.p = null;
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }
}
