package com.uc.weex.e;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
public abstract class e<T> implements a {
    public static String a = "Task";
    public Boolean b;
    public T c;
    private boolean d;
    private Set<a<T>> e = new HashSet();
    private Throwable f;
    private Set<Object> g = Collections.newSetFromMap(new WeakHashMap());
    private Set<e> h = new HashSet();
    private boolean i;
    private Set<e> j = null;
    private boolean k;

    public abstract void h_();

    public final void a(e eVar) {
        if (eVar != null) {
            a((a) eVar);
            b(eVar);
        }
        if (!this.d) {
            this.d = true;
            a();
            synchronized (this.h) {
                this.i = true;
                for (e a : this.h) {
                    a.a(this);
                }
                this.i = false;
                if (this.j != null) {
                    for (e a2 : this.j) {
                        if (!this.h.contains(a2)) {
                            this.h.add(a2);
                        }
                    }
                    this.j = null;
                }
            }
            d();
        }
    }

    public void a() {
    }

    public void c() {
    }

    public final void a(e eVar, boolean z, Object obj, Throwable th) {
    }

    public final void a(e... eVarArr) {
        synchronized (this.h) {
            Set set = this.h;
            if (this.i) {
                set = new HashSet();
                this.j = set;
            }
            for (int i = 0; i < 3; i++) {
                Object obj = eVarArr[i];
                if (!set.contains(obj)) {
                    set.add(obj);
                }
            }
            if (this.d) {
                for (int i2 = 0; i2 < 3; i2++) {
                    eVarArr[i2].a(this);
                }
            }
        }
    }

    public final void d() {
        if (!e() && f()) {
            synchronized (this) {
                this.k = true;
                try {
                    h_();
                    this.k = false;
                } catch (Throwable th) {
                    Log.e(a, "", th);
                }
                if (e()) {
                    g();
                }
            }
        }
        return;
        this.k = false;
        if (e()) {
            g();
        }
    }

    private boolean e() {
        return this.b != null;
    }

    private boolean f() {
        synchronized (this.h) {
            for (e e : this.h) {
                if (!e.e()) {
                    return false;
                }
            }
            return true;
        }
    }

    public final e<T> a(a<T> aVar) {
        if (aVar != null) {
            if (e()) {
                a(false, aVar);
            } else {
                synchronized (this.e) {
                    if (!this.e.contains(aVar)) {
                        this.e.add(aVar);
                    }
                }
            }
        }
        return this;
    }

    public final e<T> a(c cVar) {
        synchronized (this.g) {
            if (!this.g.contains(cVar)) {
                this.g.add(cVar);
            }
        }
        return this;
    }

    private e<T> b(e eVar) {
        synchronized (this.g) {
            if (!this.g.contains(eVar)) {
                this.g.add(eVar);
            }
        }
        return this;
    }

    public final void a(T t) {
        this.b = Boolean.valueOf(true);
        this.c = t;
        c();
        synchronized (this) {
            if (!this.k) {
                g();
            }
        }
    }

    public final void a(Throwable th) {
        this.b = Boolean.valueOf(false);
        this.f = th;
        c();
        synchronized (this) {
            if (!this.k) {
                g();
            }
        }
    }

    private void g() {
        synchronized (this.e) {
            for (a aVar : this.e) {
                if (aVar != null) {
                    a(true, aVar);
                }
            }
            this.e.clear();
        }
    }

    private void a(boolean z, a<T> aVar) {
        aVar.a(this, this.b.booleanValue(), this.c, this.f);
        if (z && (aVar instanceof e)) {
            e eVar = (e) aVar;
            if (eVar.f()) {
                eVar.d();
            }
        }
    }

    public final void a(String str, e eVar, Object... objArr) {
        synchronized (this.g) {
            for (Object next : this.g) {
                if (next != null) {
                    if (next instanceof e) {
                        ((e) next).a(str, eVar, objArr);
                    } else if (next instanceof c) {
                        ((c) next).a(str, objArr);
                    }
                }
            }
        }
    }
}
