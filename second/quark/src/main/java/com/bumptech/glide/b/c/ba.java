package com.bumptech.glide.b.c;

import android.support.v4.d.q;
import com.bumptech.glide.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: ProGuard */
public final class ba {
    private static final az a = new az();
    private static final aq<Object, Object> b = new ax();
    private final List<ay<?, ?>> c;
    private final az d;
    private final Set<ay<?, ?>> e;
    private final q<List<Exception>> f;

    public ba(q<List<Exception>> qVar) {
        this(qVar, a);
    }

    private ba(q<List<Exception>> qVar, az azVar) {
        this.c = new ArrayList();
        this.e = new HashSet();
        this.f = qVar;
        this.d = azVar;
    }

    final synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ar<Model, Data> arVar) {
        this.c.add(this.c.size(), new ay(cls, cls2, arVar));
    }

    final synchronized <Model, Data> List<ar<Model, Data>> b(Class<Model> cls, Class<Data> cls2, ar<Model, Data> arVar) {
        List<ar<Model, Data>> b;
        b = b(cls, cls2);
        a(cls, cls2, arVar);
        return b;
    }

    private synchronized <Model, Data> List<ar<Model, Data>> b(Class<Model> cls, Class<Data> cls2) {
        List<ar<Model, Data>> arrayList;
        arrayList = new ArrayList();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ay ayVar = (ay) it.next();
            if (ayVar.a(cls, cls2)) {
                it.remove();
                arrayList.add(ayVar.b);
            }
        }
        return arrayList;
    }

    final synchronized <Model> List<aq<Model, ?>> a(Class<Model> cls) {
        List<aq<Model, ?>> arrayList;
        try {
            arrayList = new ArrayList();
            for (ay ayVar : this.c) {
                if (!this.e.contains(ayVar) && ayVar.a(cls)) {
                    this.e.add(ayVar);
                    arrayList.add(a(ayVar));
                    this.e.remove(ayVar);
                }
            }
        } catch (Throwable th) {
            this.e.clear();
        }
        return arrayList;
    }

    final synchronized List<Class<?>> b(Class<?> cls) {
        List<Class<?>> arrayList;
        arrayList = new ArrayList();
        for (ay ayVar : this.c) {
            if (!arrayList.contains(ayVar.a) && ayVar.a(cls)) {
                arrayList.add(ayVar.a);
            }
        }
        return arrayList;
    }

    public final synchronized <Model, Data> aq<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        aq<Model, Data> awVar;
        try {
            List arrayList = new ArrayList();
            Object obj = null;
            for (ay ayVar : this.c) {
                if (this.e.contains(ayVar)) {
                    obj = 1;
                } else if (ayVar.a(cls, cls2)) {
                    this.e.add(ayVar);
                    arrayList.add(a(ayVar));
                    this.e.remove(ayVar);
                }
            }
            if (arrayList.size() > 1) {
                awVar = new aw(arrayList, this.f);
            } else if (arrayList.size() == 1) {
                awVar = (aq) arrayList.get(0);
            } else if (obj != null) {
                awVar = b;
            } else {
                throw new j(cls, cls2);
            }
        } catch (Throwable th) {
            this.e.clear();
        }
        return awVar;
    }

    private <Model, Data> aq<Model, Data> a(ay<?, ?> ayVar) {
        return (aq) com.bumptech.glide.util.j.a(ayVar.b.a(this), "Argument must not be null");
    }
}
