package com.alibaba.fastjson.a.a;

import com.alibaba.fastjson.c.a;
import com.alibaba.fastjson.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class c {
    public final a b;
    public final Class<?> c;

    public abstract void a(com.alibaba.fastjson.a.c cVar, Object obj, Type type, Map<String, Object> map);

    public c(Class<?> cls, a aVar) {
        this.c = cls;
        this.b = aVar;
    }

    public void a(Object obj, Object obj2) {
        if (obj2 != null || !this.b.f.isPrimitive()) {
            Field field = this.b.c;
            Method method = this.b.b;
            try {
                Map map;
                Collection collection;
                if (this.b.d) {
                    if (!this.b.i) {
                        field.set(obj, obj2);
                    } else if (Map.class.isAssignableFrom(this.b.f)) {
                        map = (Map) field.get(obj);
                        if (map != null) {
                            map.putAll((Map) obj2);
                        }
                    } else {
                        collection = (Collection) field.get(obj);
                        if (collection != null) {
                            collection.addAll((Collection) obj2);
                        }
                    }
                } else if (!this.b.i) {
                    method.invoke(obj, new Object[]{obj2});
                } else if (Map.class.isAssignableFrom(this.b.f)) {
                    map = (Map) method.invoke(obj, new Object[0]);
                    if (map != null) {
                        map.putAll((Map) obj2);
                    }
                } else {
                    collection = (Collection) method.invoke(obj, new Object[0]);
                    if (collection != null) {
                        collection.addAll((Collection) obj2);
                    }
                }
            } catch (Throwable e) {
                throw new d("set property error, " + this.b.a, e);
            }
        }
    }
}
