package com.ucpro.feature.video.player.a;

import android.util.SparseArray;

/* compiled from: ProGuard */
public final class b implements e {
    private static final ThreadLocal<h<b>> a = new ThreadLocal();
    private static final c<b> b = new a();
    private final SparseArray<Object> c;
    private Object d;

    private static h<b> d() {
        if (a.get() == null) {
            a.set(new h(b));
        }
        return (h) a.get();
    }

    public static Object a(b bVar, int i, Object obj) {
        if (bVar == null) {
            return obj;
        }
        Object obj2;
        bVar.e();
        if (bVar.c.indexOfKey(i) >= 0) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        return obj2 == null ? obj : bVar.a(i);
    }

    public static b a() {
        e eVar;
        h d = d();
        e eVar2 = d.e;
        if (eVar2 == null) {
            eVar = (e) d.b.a();
        } else {
            Object c = eVar2.c();
            eVar2.a(null);
            if (c != h.a) {
                eVar = (e) c;
            } else {
                eVar = null;
            }
            d.e = eVar;
            d.d--;
            eVar = eVar2;
        }
        return (b) eVar;
    }

    private b() {
        this.c = new SparseArray();
        this.d = null;
    }

    public final void b() {
        this.c.clear();
        h d = d();
        h.a(this);
        Object obj = null;
        if (d.d < d.c) {
            d.d++;
            obj = d.e;
            d.e = this;
        }
        if (obj == null) {
            obj = h.a;
        }
        a(obj);
    }

    private void e() {
        d();
        h.a(this);
    }

    public final b a(int i, Object obj) {
        e();
        this.c.put(i, obj);
        return this;
    }

    public final Object c() {
        return this.d;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final Object a(int i) {
        e();
        return this.c.get(i);
    }
}
