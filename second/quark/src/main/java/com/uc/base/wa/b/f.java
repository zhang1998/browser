package com.uc.base.wa.b;

import com.uc.base.wa.a.c;
import com.uc.base.wa.d.l;
import com.uc.base.wa.f.e;
import com.uc.base.wa.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
final class f implements m {
    final /* synthetic */ boolean a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ n c;
    final /* synthetic */ c d;
    final /* synthetic */ boolean e;
    final /* synthetic */ AtomicInteger f;
    final /* synthetic */ g g;

    f(g gVar, boolean z, HashMap hashMap, n nVar, c cVar, boolean z2, AtomicInteger atomicInteger) {
        this.g = gVar;
        this.a = z;
        this.b = hashMap;
        this.c = nVar;
        this.d = cVar;
        this.e = z2;
        this.f = atomicInteger;
    }

    public final void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        int i;
        int i2 = 0;
        if (!(this.a || hashMap2 == null || hashMap2.containsKey("lt"))) {
            c.a().b("lt is null, IWaItem.onFillProtocolBodyData called IWaItem.WaEvent.fillProtocolBodyData(protoMap); ?");
        }
        if (g.m == null) {
            String[] b = com.uc.base.wa.config.c.b();
            if (!(b == null || this.b == null)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String str : b) {
                    String str2 = (String) this.b.get(str);
                    if (str2 == null && hashMap != null) {
                        str2 = (String) hashMap.get(str);
                    }
                    if (str2 != null) {
                        stringBuilder.append("`" + str + "=" + str2);
                    }
                }
                if (stringBuilder.length() <= 0) {
                    c.a().b("appendForcedSystemHead logic error");
                }
                g.m = stringBuilder.toString();
            }
        }
        if (hashMap2 != null) {
            String[] b2 = com.uc.base.wa.config.c.b();
            if (b2 != null) {
                for (Object remove : b2) {
                    hashMap2.remove(remove);
                }
            }
        }
        if (!(hashMap == null || hashMap.isEmpty() || this.g.n == null)) {
            synchronized (this.g) {
                if (this.g.n != null) {
                    this.g.n.putAll(hashMap);
                    this.g.o = (HashMap) this.g.n.clone();
                }
            }
        }
        if (this.c != null) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("ct", this.g.h.h(this.g.d));
            if (hashMap2 != null) {
                hashMap3.putAll(hashMap2);
            }
            if (this.d != null && this.d.c()) {
                Map a = this.d.a();
                if (a != null) {
                    hashMap3.putAll(a);
                }
                if (this.d.e && this.d.d()) {
                    ArrayList a2 = this.d.b().a(hashMap3);
                    l.a(com.uc.base.wa.c.c.a(g.m, (Map[]) a2.toArray(new HashMap[a2.size()])), this.c, this.e);
                    return;
                }
            }
            l.a(com.uc.base.wa.c.c.a(g.m, hashMap3), this.c, this.e);
            return;
        }
        q b3;
        q d;
        Map g;
        if (this.f != null) {
            this.f.decrementAndGet();
            if (this.f.get() == 0 && g.l.contains(this.f)) {
                g.l.remove(this.f);
                i = 1;
                synchronized (this.g) {
                    if (hashMap2 != null) {
                        if (this.d != null && this.d.c()) {
                            hashMap2.putAll(this.d.a());
                        }
                    }
                    if (this.d != null && this.d.d()) {
                        b3 = this.d.b();
                        if (this.d.e && this.d.d() && b3 != null) {
                            b3 = b3.a((HashMap) hashMap2, this.g.h.h(this.g.d));
                        }
                        if (b3 != null) {
                            if (this.g.g == null) {
                                this.g.g = new q();
                            }
                            d = this.g.g;
                            int a3 = d.a();
                            if (b3.b()) {
                                g = b3.g();
                                if (!(d == null || g == null)) {
                                    d.g().putAll(g);
                                }
                            }
                            if (b3.c()) {
                                q.a(d, b3.h());
                            }
                            if (b3.d()) {
                                q.b(d, b3.i());
                            }
                            if (b3.e()) {
                                q.c(d, b3.j());
                            }
                            if (b3.f()) {
                                q.d(d, b3.k());
                            }
                            g.b(d.a() - a3);
                            if (this.g.r != null) {
                                this.g.r.q = true;
                            }
                        }
                    }
                    if (!(hashMap2 == null || hashMap2.isEmpty() || (this.d != null && this.d.e))) {
                        if (this.g.f == null) {
                            this.g.f = new ArrayList();
                        }
                        this.g.f.add(hashMap2);
                        g.d();
                        i2 = this.g.f.size();
                        if (this.g.r != null) {
                            this.g.r.i = this.g.r.i + 1;
                        }
                    }
                }
                if (i != 0) {
                    e.a(2, new e(this));
                } else if (this.g.r == null) {
                    g.a(this.g.r, i2);
                } else {
                    g.a(this.g, i2);
                }
            }
        }
        i = 0;
        synchronized (this.g) {
            if (hashMap2 != null) {
                hashMap2.putAll(this.d.a());
            }
            b3 = this.d.b();
            b3 = b3.a((HashMap) hashMap2, this.g.h.h(this.g.d));
            if (b3 != null) {
                if (this.g.g == null) {
                    this.g.g = new q();
                }
                d = this.g.g;
                int a32 = d.a();
                if (b3.b()) {
                    g = b3.g();
                    d.g().putAll(g);
                }
                if (b3.c()) {
                    q.a(d, b3.h());
                }
                if (b3.d()) {
                    q.b(d, b3.i());
                }
                if (b3.e()) {
                    q.c(d, b3.j());
                }
                if (b3.f()) {
                    q.d(d, b3.k());
                }
                g.b(d.a() - a32);
                if (this.g.r != null) {
                    this.g.r.q = true;
                }
            }
            if (this.g.f == null) {
                this.g.f = new ArrayList();
            }
            this.g.f.add(hashMap2);
            g.d();
            i2 = this.g.f.size();
            if (this.g.r != null) {
                this.g.r.i = this.g.r.i + 1;
            }
        }
        if (i != 0) {
            e.a(2, new e(this));
        } else if (this.g.r == null) {
            g.a(this.g, i2);
        } else {
            g.a(this.g.r, i2);
        }
    }
}
