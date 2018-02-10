package com.bumptech.glide.b.b;

import com.bumptech.glide.b.b.b.c;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.d.b;
import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.p;
import com.bumptech.glide.e;
import com.bumptech.glide.e.d;
import com.bumptech.glide.g;
import com.bumptech.glide.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class f<Transcode> {
    final List<ap<?>> a = new ArrayList();
    final List<i> b = new ArrayList();
    public e c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public k h;
    public m i;
    public Map<Class<?>, p<?>> j;
    public Class<Transcode> k;
    boolean l;
    boolean m;
    public i n;
    public g o;
    public w p;
    public boolean q;

    f() {
    }

    final c a() {
        return this.h.a();
    }

    final boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    final <Data> ar<Data, ?, Transcode> b(Class<Data> cls) {
        com.bumptech.glide.m mVar = this.c.b;
        Class cls2 = this.g;
        Class cls3 = this.k;
        ar<Data, ?, Transcode> b = mVar.i.b(cls, cls2, cls3);
        if (b == null && !mVar.i.a(cls, cls2, cls3)) {
            List arrayList = new ArrayList();
            for (Class cls4 : mVar.c.b(cls, cls2)) {
                for (Class cls5 : mVar.f.b(cls4, cls3)) {
                    arrayList.add(new q(cls, cls4, cls5, mVar.c.a(cls, cls4), mVar.f.a(cls4, cls5), mVar.j));
                }
            }
            if (arrayList.isEmpty()) {
                b = null;
            } else {
                b = new ar(cls, cls2, cls3, arrayList, mVar.j);
            }
            d dVar = mVar.i;
            synchronized (dVar.a) {
                dVar.a.put(new com.bumptech.glide.util.i(cls, cls2, cls3), b);
            }
        }
        return b;
    }

    final <Z> p<Z> c(Class<Z> cls) {
        p<Z> pVar = (p) this.j.get(cls);
        if (pVar != null) {
            return pVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return b.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    final List<aq<File, ?>> a(File file) throws j {
        return this.c.b.a((Object) file);
    }

    final List<ap<?>> b() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List a = this.c.b.a(this.d);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ap a2 = ((aq) a.get(i)).a(this.d, this.e, this.f, this.i);
                if (a2 != null) {
                    this.a.add(a2);
                }
            }
        }
        return this.a;
    }

    final List<i> c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List b = b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                ap apVar = (ap) b.get(i);
                if (!this.b.contains(apVar.a)) {
                    this.b.add(apVar.a);
                }
                for (int i2 = 0; i2 < apVar.b.size(); i2++) {
                    if (!this.b.contains(apVar.b.get(i2))) {
                        this.b.add(apVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }
}
