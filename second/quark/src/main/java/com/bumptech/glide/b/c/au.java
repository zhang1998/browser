package com.bumptech.glide.b.c;

import android.support.v4.d.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class au {
    private final ba a;
    private final at b;

    public au(q<List<Exception>> qVar) {
        this(new ba(qVar));
    }

    private au(ba baVar) {
        this.b = new at();
        this.a = baVar;
    }

    public final synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, ar<Model, Data> arVar) {
        this.a.a(cls, cls2, arVar);
        this.b.a();
    }

    public final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, ar<Model, Data> arVar) {
        Iterator it = this.a.b(cls, cls2, arVar).iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.b.a();
    }

    public final synchronized <A> List<aq<A, ?>> a(A a) {
        List<aq<A, ?>> arrayList;
        List list;
        List list2;
        Class cls = a.getClass();
        as asVar = (as) this.b.a.get(cls);
        if (asVar == null) {
            list = null;
        } else {
            list = asVar.a;
        }
        if (list == null) {
            List unmodifiableList = Collections.unmodifiableList(this.a.a(cls));
            if (((as) this.b.a.put(cls, new as(unmodifiableList))) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
            list2 = unmodifiableList;
        } else {
            list2 = list;
        }
        int size = list2.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            aq aqVar = (aq) list2.get(i);
            if (aqVar.a(a)) {
                arrayList.add(aqVar);
            }
        }
        return arrayList;
    }

    public final synchronized List<Class<?>> a(Class<?> cls) {
        return this.a.b(cls);
    }
}
