package com.bumptech.glide.e;

import com.bumptech.glide.b.n;

/* compiled from: ProGuard */
final class f<T, R> {
    final Class<R> a;
    final n<T, R> b;
    private final Class<T> c;

    public f(Class<T> cls, Class<R> cls2, n<T, R> nVar) {
        this.c = cls;
        this.a = cls2;
        this.b = nVar;
    }

    public final boolean a(Class<?> cls, Class<?> cls2) {
        return this.c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.a);
    }
}
