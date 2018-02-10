package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.b.ab;
import com.alibaba.fastjson.b.b;
import com.alibaba.fastjson.b.f;
import com.alibaba.fastjson.b.g;
import com.alibaba.fastjson.b.l;
import com.alibaba.fastjson.b.r;
import com.alibaba.fastjson.b.t;
import com.alibaba.fastjson.c.a;
import com.alibaba.fastjson.c.c;
import com.alibaba.fastjson.h;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class n {
    public static n a = new n();
    public final q b = new q();
    public ClassLoader c;
    public h d;
    private final c<e> e = new c();

    public n() {
        this.e.a(SimpleDateFormat.class, r.a);
        this.e.a(Date.class, com.alibaba.fastjson.b.h.a);
        this.e.a(Calendar.class, com.alibaba.fastjson.b.h.a);
        this.e.a(Map.class, l.a);
        this.e.a(HashMap.class, l.a);
        this.e.a(LinkedHashMap.class, l.a);
        this.e.a(TreeMap.class, l.a);
        this.e.a(ConcurrentMap.class, l.a);
        this.e.a(ConcurrentHashMap.class, l.a);
        this.e.a(Collection.class, g.a);
        this.e.a(List.class, g.a);
        this.e.a(ArrayList.class, g.a);
        this.e.a(Object.class, h.a);
        this.e.a(String.class, ab.a);
        this.e.a(Character.TYPE, r.a);
        this.e.a(Character.class, r.a);
        this.e.a(Byte.TYPE, t.a);
        this.e.a(Byte.class, t.a);
        this.e.a(Short.TYPE, t.a);
        this.e.a(Short.class, t.a);
        this.e.a(Integer.TYPE, l.a);
        this.e.a(Integer.class, l.a);
        this.e.a(Long.TYPE, l.a);
        this.e.a(Long.class, l.a);
        this.e.a(BigInteger.class, com.alibaba.fastjson.b.e.a);
        this.e.a(BigDecimal.class, com.alibaba.fastjson.b.e.a);
        this.e.a(Float.TYPE, t.a);
        this.e.a(Float.class, t.a);
        this.e.a(Double.TYPE, t.a);
        this.e.a(Double.class, t.a);
        this.e.a(Boolean.TYPE, f.a);
        this.e.a(Boolean.class, f.a);
        this.e.a(Class.class, r.a);
        this.e.a(char[].class, b.a);
        this.e.a(Object[].class, b.a);
        this.e.a(UUID.class, r.a);
        this.e.a(TimeZone.class, r.a);
        this.e.a(Locale.class, r.a);
        this.e.a(Currency.class, r.a);
        this.e.a(URI.class, r.a);
        this.e.a(URL.class, r.a);
        this.e.a(Pattern.class, r.a);
        this.e.a(Charset.class, r.a);
        this.e.a(Number.class, t.a);
        this.e.a(StackTraceElement.class, r.a);
        this.e.a(Serializable.class, h.a);
        this.e.a(Cloneable.class, h.a);
        this.e.a(Comparable.class, h.a);
        this.e.a(Closeable.class, h.a);
    }

    public final e a(Type type) {
        Type type2 = type;
        while (true) {
            e eVar = (e) this.e.a(type2);
            if (eVar != null) {
                return eVar;
            }
            if (type2 instanceof Class) {
                return a((Class) type2, type2);
            }
            if (!(type2 instanceof ParameterizedType)) {
                return h.a;
            }
            Type rawType = ((ParameterizedType) type2).getRawType();
            if (rawType instanceof Class) {
                return a((Class) rawType, type2);
            }
            type2 = rawType;
        }
    }

    public final e a(Class<?> cls, Type type) {
        e eVar;
        Type type2;
        Type type3 = type;
        Class cls2 = cls;
        while (true) {
            eVar = (e) this.e.a(type3);
            if (eVar != null) {
                break;
            }
            if (type3 == null) {
                type2 = cls2;
            } else {
                type2 = type3;
            }
            eVar = (e) this.e.a(type2);
            if (eVar == null) {
                if (!a(cls2)) {
                    JSONType jSONType = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType == null) {
                        break;
                    }
                    type3 = jSONType.mappingTo();
                    if (type3 == Void.class) {
                        break;
                    }
                    Type type4 = type3;
                } else {
                    break;
                }
            }
            break;
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            eVar = (e) this.e.a(cls2);
        }
        if (eVar == null) {
            eVar = (e) this.e.a(type2);
            if (eVar == null) {
                if (cls2.isEnum()) {
                    eVar = new d(cls2);
                } else if (cls2.isArray()) {
                    eVar = b.a;
                } else if (cls2 == Set.class || cls2 == HashSet.class || cls2 == Collection.class || cls2 == List.class || cls2 == ArrayList.class) {
                    eVar = g.a;
                } else if (Collection.class.isAssignableFrom(cls2)) {
                    eVar = g.a;
                } else if (Map.class.isAssignableFrom(cls2)) {
                    eVar = l.a;
                } else if (Throwable.class.isAssignableFrom(cls2)) {
                    eVar = new r(this, cls2);
                } else {
                    eVar = new f(this, cls2, type2);
                }
                this.e.a(type2, eVar);
            }
        }
        return eVar;
    }

    public static com.alibaba.fastjson.a.a.c a(Class<?> cls, a aVar) {
        Class cls2 = aVar.f;
        if (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) {
            return new k(cls, aVar);
        }
        return new a(cls, aVar);
    }

    public static boolean a(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }
}
