package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.b.b.w;
import com.bumptech.glide.b.d.c.b;
import com.bumptech.glide.b.d.e.f;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.e;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.c.r;
import com.bumptech.glide.c.s;
import com.bumptech.glide.c.v;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.f.g;
import com.bumptech.glide.util.l;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class u implements k {
    private static final g f = g.a(Bitmap.class).f();
    private static final g g = g.a(f.class).f();
    private static final g h = g.a(w.c).a(g.LOW).a(true);
    public final c a;
    final j b;
    final s c;
    final v d;
    @NonNull
    g e;
    private final r i;
    private final Runnable j;
    private final Handler k;
    private final d l;

    public u(c cVar, j jVar, r rVar) {
        this(cVar, jVar, rVar, new s(), cVar.g);
    }

    private u(c cVar, j jVar, r rVar, s sVar, e eVar) {
        this.d = new v();
        this.j = new q(this);
        this.k = new Handler(Looper.getMainLooper());
        this.a = cVar;
        this.b = jVar;
        this.i = rVar;
        this.c = sVar;
        this.l = eVar.a(cVar.c.getBaseContext(), new t(sVar));
        if (l.d()) {
            this.k.post(this.j);
        } else {
            jVar.a(this);
        }
        jVar.a(this.l);
        a(cVar.c.c);
        synchronized (cVar.h) {
            if (cVar.h.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            cVar.h.add(this);
        }
    }

    public void a(@NonNull g gVar) {
        this.e = gVar.a().g();
    }

    public final void a(int i) {
        this.a.c.onTrimMemory(i);
    }

    public final void d() {
        this.a.c.onLowMemory();
    }

    public final void c() {
        this.d.c();
        for (h a : new ArrayList(this.d.a)) {
            a(a);
        }
        this.d.a.clear();
        this.c.a();
        this.b.b(this);
        this.b.b(this.l);
        this.k.removeCallbacks(this.j);
        c cVar = this.a;
        synchronized (cVar.h) {
            if (cVar.h.contains(this)) {
                cVar.h.remove(this);
            } else {
                throw new IllegalStateException("Cannot register not yet registered manager");
            }
        }
    }

    public p<Bitmap> e() {
        return a(Bitmap.class).a(new b()).a(f);
    }

    public p<Drawable> f() {
        return a(Drawable.class).a(new b());
    }

    public p<Drawable> a(@Nullable Object obj) {
        return f().a(obj);
    }

    public <ResourceType> p<ResourceType> a(Class<ResourceType> cls) {
        return new p(this.a, this, cls);
    }

    public final void a(@Nullable h<?> hVar) {
        if (hVar != null) {
            if (!l.c()) {
                this.k.post(new r(this, hVar));
            } else if (!b(hVar)) {
                c cVar = this.a;
                synchronized (cVar.h) {
                    for (u b : cVar.h) {
                        if (b.b(hVar)) {
                            return;
                        }
                    }
                    throw new IllegalStateException("Failed to remove target from managers");
                }
            }
        }
    }

    private boolean b(h<?> hVar) {
        com.bumptech.glide.f.b d = hVar.d();
        if (d == null) {
            return true;
        }
        if (!this.c.a(d)) {
            return false;
        }
        this.d.a.remove(hVar);
        hVar.a(null);
        return true;
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.c + ", treeNode=" + this.i + "}";
    }

    public final void a() {
        l.a();
        s sVar = this.c;
        sVar.c = false;
        for (com.bumptech.glide.f.b bVar : l.a(sVar.a)) {
            if (!(bVar.f() || bVar.h() || bVar.e())) {
                bVar.b();
            }
        }
        sVar.b.clear();
        this.d.a();
    }

    public final void b() {
        l.a();
        s sVar = this.c;
        sVar.c = true;
        for (com.bumptech.glide.f.b bVar : l.a(sVar.a)) {
            if (bVar.e()) {
                bVar.c();
                sVar.b.add(bVar);
            }
        }
        this.d.b();
    }
}
