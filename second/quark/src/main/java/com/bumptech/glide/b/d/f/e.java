package com.bumptech.glide.b.d.f;

/* compiled from: ProGuard */
final class e<Z, R> {
    final d<Z, R> a;
    private final Class<Z> b;
    private final Class<R> c;

    e(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
        this.b = cls;
        this.c = cls2;
        this.a = dVar;
    }

    public final boolean a(Class<?> cls, Class<?> cls2) {
        return this.b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.c);
    }
}
