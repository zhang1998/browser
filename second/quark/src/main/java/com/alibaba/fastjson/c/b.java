package com.alibaba.fastjson.c;

import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class b<V> {
    public final int a;
    public final Type b;
    public V c;
    public final b<V> d;

    public b(Type type, V v, int i, b<V> bVar) {
        this.b = type;
        this.c = v;
        this.d = bVar;
        this.a = i;
    }
}
