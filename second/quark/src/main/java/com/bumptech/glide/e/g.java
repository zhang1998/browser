package com.bumptech.glide.e;

import com.bumptech.glide.b.n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class g {
    private final List<f<?, ?>> a = new ArrayList();

    public final synchronized <T, R> List<n<T, R>> a(Class<T> cls, Class<R> cls2) {
        List<n<T, R>> arrayList;
        arrayList = new ArrayList();
        for (f fVar : this.a) {
            if (fVar.a(cls, cls2)) {
                arrayList.add(fVar.b);
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        List<Class<R>> arrayList;
        arrayList = new ArrayList();
        for (f fVar : this.a) {
            if (fVar.a(cls, cls2)) {
                arrayList.add(fVar.a);
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> void a(n<T, R> nVar, Class<T> cls, Class<R> cls2) {
        this.a.add(new f(cls, cls2, nVar));
    }

    public final synchronized <T, R> void b(n<T, R> nVar, Class<T> cls, Class<R> cls2) {
        this.a.add(0, new f(cls, cls2, nVar));
    }
}
