package com.alibaba.fastjson.c;

import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class c<V> {
    private final b<V>[] a = new b[1024];
    private final int b = 1023;

    public final V a(Type type) {
        for (b bVar = this.a[System.identityHashCode(type) & this.b]; bVar != null; bVar = bVar.d) {
            if (type == bVar.b) {
                return bVar.c;
            }
        }
        return null;
    }

    public final boolean a(Type type, V v) {
        int identityHashCode = System.identityHashCode(type);
        int i = identityHashCode & this.b;
        for (b bVar = this.a[i]; bVar != null; bVar = bVar.d) {
            if (type == bVar.b) {
                bVar.c = v;
                return true;
            }
        }
        this.a[i] = new b(type, v, identityHashCode, this.a[i]);
        return false;
    }
}
