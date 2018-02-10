package com.alibaba.fastjson;

import com.alibaba.fastjson.a.n;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.b.y;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class e extends a implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {
    public final Map<String, Object> f;

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((String) obj, obj2);
    }

    public e() {
        this(16, false);
    }

    public e(Map<String, Object> map) {
        this.f = map;
    }

    public e(boolean z) {
        this(16, z);
    }

    public e(int i) {
        this(i, false);
    }

    private e(int i, boolean z) {
        if (z) {
            this.f = new LinkedHashMap(i);
        } else {
            this.f = new HashMap(i);
        }
    }

    public int size() {
        return this.f.size();
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.f.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f.containsValue(obj);
    }

    public Object get(Object obj) {
        return this.f.get(obj);
    }

    public final e d(String str) {
        Object obj = this.f.get(str);
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj instanceof String) {
            return a.b((String) obj);
        }
        return (e) a.a(obj, y.a);
    }

    public final b e(String str) {
        Object obj = this.f.get(str);
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj instanceof String) {
            return (b) a.a((String) obj);
        }
        return (b) a.a(obj, y.a);
    }

    public final Integer f(String str) {
        return com.alibaba.fastjson.c.e.j(get(str));
    }

    public final int g(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return com.alibaba.fastjson.c.e.j(obj).intValue();
    }

    public final String h(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public final Object a(String str, Object obj) {
        return this.f.put(str, obj);
    }

    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f.putAll(map);
    }

    public void clear() {
        this.f.clear();
    }

    public Object remove(Object obj) {
        return this.f.remove(obj);
    }

    public Set<String> keySet() {
        return this.f.keySet();
    }

    public Collection<Object> values() {
        return this.f.values();
    }

    public Set<Entry<String, Object>> entrySet() {
        return this.f.entrySet();
    }

    public Object clone() {
        return new e(new LinkedHashMap(this.f));
    }

    public boolean equals(Object obj) {
        return this.f.equals(obj);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class[] parameterTypes = method.getParameterTypes();
        JSONField jSONField;
        Object obj2;
        String name;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != Void.TYPE) {
                throw new d("illegal setter");
            }
            jSONField = (JSONField) method.getAnnotation(JSONField.class);
            if (jSONField == null || jSONField.name().length() == 0) {
                obj2 = null;
            } else {
                obj2 = jSONField.name();
            }
            if (obj2 == null) {
                name = method.getName();
                if (name.startsWith("set")) {
                    name = name.substring(3);
                    if (name.length() == 0) {
                        throw new d("illegal setter");
                    }
                    obj2 = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                } else {
                    throw new d("illegal setter");
                }
            }
            this.f.put(obj2, objArr[0]);
            return null;
        } else if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() == Void.TYPE) {
            throw new d("illegal getter");
        } else {
            jSONField = (JSONField) method.getAnnotation(JSONField.class);
            if (jSONField == null || jSONField.name().length() == 0) {
                obj2 = null;
            } else {
                obj2 = jSONField.name();
            }
            if (obj2 == null) {
                name = method.getName();
                if (name.startsWith("get")) {
                    name = name.substring(3);
                    if (name.length() == 0) {
                        throw new d("illegal getter");
                    }
                    obj2 = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                } else if (name.startsWith("is")) {
                    name = name.substring(2);
                    if (name.length() == 0) {
                        throw new d("illegal getter");
                    }
                    obj2 = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                } else if (name.startsWith("hashCode")) {
                    return Integer.valueOf(hashCode());
                } else {
                    if (name.startsWith("toString")) {
                        return toString();
                    }
                    throw new d("illegal getter");
                }
            }
            return com.alibaba.fastjson.c.e.a(this.f.get(obj2), method.getGenericReturnType(), n.a);
        }
    }
}
