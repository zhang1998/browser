package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.c;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.c.e;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class o extends c {
    private final int a;
    private final List d;
    private final c e;
    private final Object f;
    private final Map g;
    private final Collection h;

    public o(c cVar, List list, int i) {
        super(null, null);
        this.e = cVar;
        this.a = i;
        this.d = list;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public o(Map map, Object obj) {
        super(null, null);
        this.e = null;
        this.a = -1;
        this.d = null;
        this.f = obj;
        this.g = map;
        this.h = null;
    }

    public o(Collection collection) {
        super(null, null);
        this.e = null;
        this.a = -1;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = collection;
    }

    public final void a(Object obj, Object obj2) {
        if (this.g != null) {
            this.g.put(this.f, obj2);
        } else if (this.h != null) {
            this.h.add(obj2);
        } else {
            this.d.set(this.a, obj2);
            if (this.d instanceof b) {
                b bVar = (b) this.d;
                Object b = bVar.b();
                if (b != null && Array.getLength(b) > this.a) {
                    if (bVar.c() != null) {
                        obj2 = e.a(obj2, bVar.c(), this.e.b);
                    }
                    Array.set(b, this.a, obj2);
                }
            }
        }
    }

    public final void a(c cVar, Object obj, Type type, Map<String, Object> map) {
    }
}
