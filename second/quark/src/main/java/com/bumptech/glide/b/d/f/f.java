package com.bumptech.glide.b.d.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class f {
    private final List<e<?, ?>> a = new ArrayList();

    public final synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
        this.a.add(new e(cls, cls2, dVar));
    }

    public final synchronized <Z, R> d<Z, R> a(Class<Z> cls, Class<R> cls2) {
        d<Z, R> a;
        if (cls2.isAssignableFrom(cls)) {
            a = g.a();
        } else {
            for (e eVar : this.a) {
                if (eVar.a(cls, cls2)) {
                    a = eVar.a;
                }
            }
            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
        }
        return a;
    }

    public final synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        List<Class<R>> list;
        List<Class<R>> arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            list = arrayList;
        } else {
            for (e a : this.a) {
                if (a.a(cls, cls2)) {
                    arrayList.add(cls2);
                }
            }
            list = arrayList;
        }
        return list;
    }
}
