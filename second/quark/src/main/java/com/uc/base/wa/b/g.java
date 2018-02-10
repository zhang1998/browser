package com.uc.base.wa.b;

import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.a.c;
import com.uc.base.wa.component.e;
import com.uc.base.wa.config.b;
import com.uc.base.wa.config.m;
import com.uc.base.wa.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class g implements j, Comparable<g> {
    static TreeSet<g> a = new TreeSet();
    static final h b = new h("nullconfig");
    static volatile int c;
    private static AtomicInteger k = new AtomicInteger(0);
    private static Set<AtomicInteger> l = Collections.synchronizedSet(new HashSet());
    private static String m;
    final String d;
    long e;
    ArrayList<HashMap<String, String>> f;
    q g;
    b h;
    int i = 0;
    HashMap<String, h> j;
    private volatile HashMap<String, String> n;
    private HashMap<String, String> o;
    private HashMap<String, g> p = null;
    private boolean q = false;
    private g r = null;

    static /* synthetic */ int b(int i) {
        int i2 = c + i;
        c = i2;
        return i2;
    }

    static /* synthetic */ int d() {
        int i = c;
        c = i + 1;
        return i;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int i = b.e(gVar.d).h;
        int i2 = b.e(this.d).h;
        boolean equals = equals(gVar);
        i = -(i2 - i);
        if (i != 0 || equals) {
            return i;
        }
        return 1;
    }

    g(String str) {
        this.d = str;
        this.h = b.e(this.d);
        if (this.h == null) {
            c.a().b(null);
        }
        synchronized (a) {
            a.add(this);
        }
    }

    public final void a(j jVar) {
        if (jVar instanceof g) {
            this.r = (g) jVar;
            if (this.r.p == null) {
                this.r.p = new HashMap();
            }
            if (!this.r.p.containsKey(this.d)) {
                this.r.p.put(this.d, this);
                return;
            }
            return;
        }
        c.a().b("relatedCache type error");
    }

    public final String toString() {
        return this.d;
    }

    public static void a(Set<String> set) {
        synchronized (a) {
            g gVar;
            if (set.contains(SettingsConst.FALSE)) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    gVar = (g) it.next();
                    if (gVar != null) {
                        synchronized (gVar) {
                            gVar.h.e = true;
                            gVar.a(true);
                        }
                    }
                }
            } else {
                Set hashSet = new HashSet();
                Iterator it2 = a.iterator();
                while (it2.hasNext()) {
                    gVar = (g) it2.next();
                    if (set.contains(gVar.d)) {
                        hashSet.add(gVar.d);
                        if (gVar.j != null) {
                            for (String add : gVar.j.keySet()) {
                                hashSet.add(add);
                            }
                        }
                    }
                }
                it2 = a.iterator();
                while (it2.hasNext()) {
                    gVar = (g) it2.next();
                    if (hashSet.remove(gVar.d)) {
                        gVar.h.e = true;
                        gVar.a(true);
                    }
                }
            }
        }
    }

    static void a() {
        for (int a : b.d) {
            a(a);
        }
    }

    static void a(int i) {
        new File(com.uc.base.wa.c.c.a(i)).mkdirs();
    }

    final long a(long j, String str, String str2, ArrayList<HashMap<String, String>> arrayList, q qVar) {
        long j2 = 0;
        if (this.r == null) {
            Object a = com.uc.base.wa.c.c.a();
            if (this.r == null) {
                j2 = 0 + com.uc.base.wa.c.c.a(a, str2, arrayList, qVar, m);
            }
            if (this.p != null) {
                Collection<g> values = this.p.values();
                if (values != null) {
                    long j3 = j2;
                    for (g gVar : values) {
                        synchronized (gVar) {
                            if (gVar.f == null && gVar.g == null) {
                            } else {
                                j3 += com.uc.base.wa.c.c.a(a, gVar.h.h(gVar.d), gVar.f, gVar.g, m);
                            }
                        }
                    }
                    j2 = j3;
                }
            }
            if (com.uc.base.wa.c.c.a(a, j, str, str2)) {
                e.a.a("E5FFFDF082B7E88B73195E0ED684035D", j2);
            } else {
                Log.e("gzm_wa_WaCache", "save fail!", new Throwable());
            }
        }
        return j2;
    }

    final void a(boolean z) {
        if (!z || this.r == null) {
            this.n = null;
            this.f = null;
            this.g = null;
            if (this.p != null) {
                Collection<g> values = this.p.values();
                if (values != null) {
                    for (g gVar : values) {
                        synchronized (gVar) {
                            gVar.a(false);
                        }
                    }
                }
            }
            this.i = 0;
            this.q = false;
        }
    }

    public static void b(boolean z) {
        if (z) {
            l.add(k);
            k = new AtomicInteger(0);
        }
        a();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (a) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                try {
                    synchronized (gVar) {
                        if (gVar.f != null || gVar.g != null || gVar.i > 0 || gVar.q) {
                            long a = gVar.a(currentTimeMillis, com.uc.base.wa.c.c.a(gVar.h.h), gVar.h.h(gVar.d), gVar.f, gVar.g);
                            gVar.a(true);
                            c = (int) (((long) c) - a);
                            gVar.e = currentTimeMillis;
                        }
                    }
                } catch (Throwable e) {
                    Log.e("gzm_wa_WaCache", "waCacheCats = " + a, e);
                    c.a().b(e.toString());
                }
            }
        }
    }

    public final void a(k kVar, h hVar, c cVar, String... strArr) {
        b.l();
        a(null, kVar, false, hVar, strArr, cVar);
    }

    public final void a(k kVar, n<Object> nVar, boolean z, h hVar, c cVar, String... strArr) {
        a((n) nVar, kVar, z, hVar, strArr, cVar);
    }

    private void a(n<Object> nVar, k kVar, boolean z, h hVar, String[] strArr, c cVar) {
        if (kVar != null && !this.h.e) {
            AtomicInteger atomicInteger;
            if (this.n == null) {
                synchronized (this) {
                    if (this.n == null) {
                        this.o = new HashMap();
                        this.n = new HashMap();
                    }
                }
            }
            HashMap hashMap = this.o != null ? this.o : new HashMap();
            boolean z2 = strArr == null && ((cVar == null || !cVar.c()) && com.uc.base.wa.config.c.e() == null && (cVar == null || !cVar.d()));
            h a = h.a(hVar, this.h, nVar != null, cVar, strArr);
            if (nVar == null) {
                atomicInteger = k;
                atomicInteger.addAndGet(1);
            } else {
                atomicInteger = null;
            }
            n nVar2 = new n(kVar, a, hashMap, z2, new f(this, z2, hashMap, nVar, cVar, z, atomicInteger));
            if (a != null) {
                if (!(a.c == null || a.c.a())) {
                    nVar2.a(1);
                }
                if (!(a.a == null || a.a.a())) {
                    nVar2.a(2);
                }
                if (!(a.b == null || a.b.a())) {
                    nVar2.a(3);
                }
            }
            nVar2.a(4);
        }
    }

    static /* synthetic */ void a(g gVar, int i) {
        boolean z;
        boolean z2 = true;
        if (i >= gVar.h.i) {
            z = true;
        } else {
            z = false;
        }
        if (((long) c) < m.h()) {
            z2 = false;
        }
        if (z || z2) {
            com.uc.base.wa.f.e.a(3, new d(gVar, z2, z));
        }
    }
}
