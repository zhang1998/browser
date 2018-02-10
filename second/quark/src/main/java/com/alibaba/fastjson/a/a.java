package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.c;
import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.b.h;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: ProGuard */
public final class a extends c {
    protected e a;

    public a(Class<?> cls, com.alibaba.fastjson.c.a aVar) {
        super(cls, aVar);
    }

    public final e a(n nVar) {
        if (this.a == null) {
            this.a = nVar.a(this.b.f, this.b.g);
        }
        return this.a;
    }

    public final void a(c cVar, Object obj, Type type, Map<String, Object> map) {
        Object a;
        if (this.a == null) {
            this.a = cVar.b.a(this.b.f, this.b.g);
        }
        if (type instanceof ParameterizedType) {
            cVar.f.d = type;
        }
        String str = this.b.l;
        if (str == null || !(this.a instanceof h)) {
            a = this.a.a(cVar, this.b.g, this.b.a);
        } else {
            a = h.a(cVar, this.b.g, str);
        }
        if (cVar.g == 1) {
            b a2 = cVar.a();
            a2.c = this;
            a2.d = cVar.f;
            cVar.g = 0;
        } else if (obj == null) {
            map.put(this.b.a, a);
        } else {
            if (a == null) {
                Class cls = this.b.f;
                if (cls == Byte.TYPE || cls == Short.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                    return;
                }
            }
            a(obj, a);
        }
    }
}
