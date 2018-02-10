package com.bumptech.glide.b.c;

/* compiled from: ProGuard */
final class ay<Model, Data> {
    final Class<Data> a;
    final ar<Model, Data> b;
    private final Class<Model> c;

    public ay(Class<Model> cls, Class<Data> cls2, ar<Model, Data> arVar) {
        this.c = cls;
        this.a = cls2;
        this.b = arVar;
    }

    public final boolean a(Class<?> cls, Class<?> cls2) {
        return a(cls) && this.a.isAssignableFrom(cls2);
    }

    public final boolean a(Class<?> cls) {
        return this.c.isAssignableFrom(cls);
    }
}
