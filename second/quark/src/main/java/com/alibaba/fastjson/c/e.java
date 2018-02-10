package com.alibaba.fastjson.c;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.f;
import com.alibaba.fastjson.a.i;
import com.alibaba.fastjson.a.n;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.b.z;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.h;
import com.taobao.weex.ui.component.ab;
import com.uc.apollo.impl.SettingsConst;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ProGuard */
public final class e {
    public static boolean a = false;
    private static boolean b = true;
    private static ConcurrentMap<String, Class<?>> c;

    static {
        ConcurrentMap concurrentHashMap = new ConcurrentHashMap();
        c = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        c.put("short", Short.TYPE);
        c.put("int", Integer.TYPE);
        c.put("long", Long.TYPE);
        c.put("float", Float.TYPE);
        c.put("double", Double.TYPE);
        c.put("boolean", Boolean.TYPE);
        c.put("char", Character.TYPE);
        c.put("[byte", byte[].class);
        c.put("[short", short[].class);
        c.put("[int", int[].class);
        c.put("[long", long[].class);
        c.put("[float", float[].class);
        c.put("[double", double[].class);
        c.put("[boolean", boolean[].class);
        c.put("[char", char[].class);
        c.put(HashMap.class.getName(), HashMap.class);
    }

    public static final String a(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static final Byte b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new d("can not cast to byte, value : " + obj);
    }

    public static final Character c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new d("can not cast to byte, value : " + obj);
        }
        throw new d("can not cast to byte, value : " + obj);
    }

    public static final Short d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new d("can not cast to short, value : " + obj);
    }

    public static final BigDecimal e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Float g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new d("can not cast to float, value : " + obj);
    }

    public static final Double h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new d("can not cast to double, value : " + obj);
    }

    private static Date l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j = -1;
        if (obj instanceof Number) {
            j = ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.indexOf(45) != -1) {
                String str2;
                if (str.length() == a.d.length()) {
                    str2 = a.d;
                } else if (str.length() == 10) {
                    str2 = "yyyy-MM-dd";
                } else if (str.length() == 19) {
                    str2 = "yyyy-MM-dd HH:mm:ss";
                } else {
                    str2 = "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, a.b);
                simpleDateFormat.setTimeZone(a.a);
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException e) {
                    throw new d("can not cast to Date, value : " + str);
                }
            } else if (str.length() == 0 || "null".equals(str)) {
                return null;
            } else {
                j = Long.parseLong(str);
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        throw new d("can not cast to Date, value : " + obj);
    }

    public static final Long i(Object obj) {
        Calendar m;
        Calendar calendar = null;
        if (obj == null) {
            return calendar;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return calendar;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException e) {
                i iVar = new i(str);
                if (iVar.b(false)) {
                    m = iVar.m();
                } else {
                    m = calendar;
                }
                iVar.b();
                if (m != null) {
                    return Long.valueOf(m.getTimeInMillis());
                }
            }
        }
        throw new d("can not cast to long, value : " + obj);
    }

    public static final Integer j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        throw new d("can not cast to int, value : " + obj);
    }

    public static final Boolean k(Object obj) {
        boolean z = true;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || SettingsConst.TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || SettingsConst.FALSE.equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new d("can not cast to int, value : " + obj);
    }

    public static final <T> T a(Object obj, Class<T> cls, n nVar) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        int i = 0;
                        Object newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object a : collection) {
                            Array.set(newInstance, i, a(a, cls.getComponentType(), nVar));
                            i++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        if (obj instanceof byte[]) {
                            return (byte[]) obj;
                        }
                        if (obj instanceof String) {
                            return i.a((String) obj);
                        }
                        throw new d("can not cast to int, value : " + obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return k(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return b(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return d(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return j(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return i(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return g(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return h(obj);
                }
                if (cls == String.class) {
                    return a(obj);
                }
                if (cls == BigDecimal.class) {
                    return e(obj);
                }
                if (cls == BigInteger.class) {
                    return f(obj);
                }
                if (cls == Date.class) {
                    return l(obj);
                }
                if (cls.isEnum()) {
                    return a(obj, (Class) cls);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Calendar instance;
                    Date l = l(obj);
                    if (cls == Calendar.class) {
                        instance = Calendar.getInstance(a.a, a.b);
                    } else {
                        try {
                            instance = (Calendar) cls.newInstance();
                        } catch (Throwable e) {
                            throw new d("can not cast to : " + cls.getName(), e);
                        }
                    }
                    instance.setTime(l);
                    return instance;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return Currency.getInstance(str);
                    }
                }
                throw new d("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey("@type")) {
                    return a((Map) obj, (Class) cls, nVar);
                }
                return obj;
            }
        }
    }

    private static <T> T a(Object obj, Class<T> cls) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                Object[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new d("can not cast to : " + cls.getName());
        } catch (Throwable e) {
            throw new d("can not cast to : " + cls.getName(), e);
        }
    }

    public static final <T> T a(Object obj, Type type, n nVar) {
        Object obj2 = type;
        T t = obj;
        while (t != null) {
            if (obj2 instanceof Class) {
                return a((Object) t, (Class) obj2, nVar);
            }
            String str;
            if (obj2 instanceof ParameterizedType) {
                Type type2;
                T hashSet;
                ParameterizedType parameterizedType = (ParameterizedType) obj2;
                type = parameterizedType.getRawType();
                if (type == Set.class || type == HashSet.class || type == TreeSet.class || type == List.class || type == ArrayList.class) {
                    type2 = parameterizedType.getActualTypeArguments()[0];
                    if (t instanceof Iterable) {
                        if (type == Set.class || type == HashSet.class) {
                            hashSet = new HashSet();
                        } else if (type == TreeSet.class) {
                            hashSet = new TreeSet();
                        } else {
                            hashSet = new ArrayList();
                        }
                        for (Object a : (Iterable) t) {
                            hashSet.add(a(a, type2, nVar));
                        }
                        return hashSet;
                    }
                }
                if (type == Map.class || type == HashMap.class) {
                    type2 = parameterizedType.getActualTypeArguments()[0];
                    Type type3 = parameterizedType.getActualTypeArguments()[1];
                    if (t instanceof Map) {
                        hashSet = new HashMap();
                        for (Entry entry : ((Map) t).entrySet()) {
                            hashSet.put(a(entry.getKey(), type2, nVar), a(entry.getValue(), type3, nVar));
                        }
                        return hashSet;
                    }
                }
                if (t instanceof String) {
                    str = (String) t;
                    if (str.length() == 0 || "null".equals(str)) {
                        return null;
                    }
                }
                if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
                    Type type4 = type;
                } else {
                    throw new d("can not cast to : " + parameterizedType);
                }
            }
            if (t instanceof String) {
                str = (String) t;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
            }
            if (obj2 instanceof TypeVariable) {
                return t;
            }
            throw new d("can not cast to : " + obj2);
        }
        return null;
    }

    private static <T> T a(Map<String, Object> map, Class<T> cls, n nVar) {
        int i = 0;
        try {
            String str;
            if (cls == StackTraceElement.class) {
                str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i = number.intValue();
                }
                return new StackTraceElement(str, str2, str3, i);
            }
            Object obj = map.get("@type");
            if (obj instanceof String) {
                str = (String) obj;
                Class a = a(str, null);
                if (a == null) {
                    throw new ClassNotFoundException(str + " not found");
                } else if (!a.equals(cls)) {
                    return a((Map) map, a, nVar);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof com.alibaba.fastjson.e) {
                    map = (com.alibaba.fastjson.e) map;
                } else {
                    Object eVar = new com.alibaba.fastjson.e((Map) map);
                }
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, map);
            }
            f fVar;
            if (nVar == null) {
                nVar = n.a;
            }
            com.alibaba.fastjson.a.a.e a2 = nVar.a((Type) cls);
            if (a2 instanceof f) {
                fVar = (f) a2;
            } else {
                fVar = null;
            }
            if (fVar != null) {
                return fVar.a((Map) map, nVar);
            }
            throw new d("can not get javaBeanDeserializer");
        } catch (Throwable e) {
            throw new d(e.getMessage(), e);
        }
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        while (str != null && str.length() != 0) {
            Class<?> cls = (Class) c.get(str);
            if (cls != null) {
                return cls;
            }
            if (str.charAt(0) == '[') {
                return Array.newInstance(a(str.substring(1), classLoader), 0).getClass();
            }
            if (str.startsWith("L") && str.endsWith(";")) {
                str = str.substring(1, str.length() - 1);
            } else {
                if (classLoader != null) {
                    try {
                        cls = classLoader.loadClass(str);
                        c.put(str, cls);
                        return cls;
                    } catch (Exception e) {
                    }
                }
                try {
                    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader != null) {
                        cls = contextClassLoader.loadClass(str);
                        c.put(str, cls);
                        return cls;
                    }
                } catch (Exception e2) {
                }
                try {
                    cls = Class.forName(str);
                    c.put(str, cls);
                    return cls;
                } catch (Exception e3) {
                    return cls;
                }
            }
        }
        return null;
    }

    public static List<a> a(Class<?> cls, int i, JSONType jSONType, boolean z, h hVar) {
        String name;
        Field a;
        JSONField jSONField;
        int length;
        Object obj;
        Map linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Member member : cls.getMethods()) {
            Member a2;
            String name2 = member.getName();
            int i2 = 0;
            if (!((member.getModifiers() & 8) != 0 || member.getReturnType().equals(Void.TYPE) || member.getParameterTypes().length != 0 || member.getReturnType() == ClassLoader.class || member.getDeclaringClass() == Object.class)) {
                if (!name2.equals("getMetaClass") || !member.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                    JSONField a3;
                    char charAt;
                    JSONField jSONField2 = (JSONField) member.getAnnotation(JSONField.class);
                    if (jSONField2 == null) {
                        a3 = a((Class) cls, (Method) member);
                    } else {
                        a3 = jSONField2;
                    }
                    if (a3 != null) {
                        if (a3.serialize()) {
                            i2 = a3.ordinal();
                            z.a(a3.serialzeFeatures());
                            if (a3.name().length() != 0) {
                                name = a3.name();
                                a((Class) cls, member, i);
                                linkedHashMap.put(name, new a(name, member, null, cls, null, i2, a3, null, true));
                            }
                        }
                    }
                    if (name2.startsWith("get")) {
                        if (name2.length() >= 4) {
                            if (!name2.equals("getClass")) {
                                charAt = name2.charAt(3);
                                if (Character.isUpperCase(charAt)) {
                                    if (a) {
                                        name = a(name2.substring(3));
                                    } else {
                                        name = Character.toLowerCase(name2.charAt(3)) + name2.substring(4);
                                    }
                                } else if (charAt == '_') {
                                    name = name2.substring(4);
                                } else if (charAt == 'f') {
                                    name = name2.substring(3);
                                } else if (name2.length() >= 5 && Character.isUpperCase(name2.charAt(4))) {
                                    name = a(name2.substring(3));
                                }
                                if (!a((Class) cls, jSONType, name)) {
                                    a = a((Class) cls, name, declaredFields);
                                    if (a != null) {
                                        jSONField2 = (JSONField) a.getAnnotation(JSONField.class);
                                        if (jSONField2 != null) {
                                            if (jSONField2.serialize()) {
                                                i2 = jSONField2.ordinal();
                                                z.a(jSONField2.serialzeFeatures());
                                                if (jSONField2.name().length() != 0) {
                                                    name = jSONField2.name();
                                                    jSONField = jSONField2;
                                                }
                                            }
                                        }
                                        jSONField = jSONField2;
                                    } else {
                                        jSONField = null;
                                    }
                                    if (hVar != null) {
                                        name = hVar.a(name);
                                    }
                                    a((Class) cls, member, i);
                                    linkedHashMap.put(name, new a(name, member, a, cls, null, i2, a3, jSONField, true));
                                }
                            }
                        }
                    }
                    if (name2.startsWith("is") && name2.length() >= 3) {
                        charAt = name2.charAt(2);
                        if (Character.isUpperCase(charAt)) {
                            if (a) {
                                name = a(name2.substring(2));
                            } else {
                                name = Character.toLowerCase(name2.charAt(2)) + name2.substring(3);
                            }
                        } else if (charAt == '_') {
                            name = name2.substring(3);
                        } else if (charAt == 'f') {
                            name = name2.substring(2);
                        }
                        a2 = a((Class) cls, name, declaredFields);
                        if (a2 == null) {
                            a2 = a((Class) cls, name2, declaredFields);
                        }
                        if (a2 != null) {
                            jSONField2 = (JSONField) a2.getAnnotation(JSONField.class);
                            if (jSONField2 != null) {
                                if (jSONField2.serialize()) {
                                    i2 = jSONField2.ordinal();
                                    z.a(jSONField2.serialzeFeatures());
                                    if (jSONField2.name().length() != 0) {
                                        name = jSONField2.name();
                                        jSONField = jSONField2;
                                    }
                                }
                            }
                            jSONField = jSONField2;
                        } else {
                            jSONField = null;
                        }
                        if (hVar != null) {
                            name = hVar.a(name);
                        }
                        a((Class) cls, a2, i);
                        a((Class) cls, member, i);
                        linkedHashMap.put(name, new a(name, member, a2, cls, null, i2, a3, jSONField, true));
                    }
                }
            }
        }
        List<Member> arrayList = new ArrayList(declaredFields.length);
        for (Field a4 : declaredFields) {
            if (!((a4.getModifiers() & 8) != 0 || a4.getName().equals("this$0") || (a4.getModifiers() & 1) == 0)) {
                arrayList.add(a4);
            }
        }
        Class superclass = cls.getSuperclass();
        while (superclass != null && superclass != Object.class) {
            for (Field field : superclass.getDeclaredFields()) {
                if ((field.getModifiers() & 8) == 0 && (field.getModifiers() & 1) != 0) {
                    arrayList.add(field);
                }
            }
            superclass = superclass.getSuperclass();
        }
        for (Member a22 : arrayList) {
            jSONField = (JSONField) a22.getAnnotation(JSONField.class);
            i2 = 0;
            name = a22.getName();
            if (jSONField != null) {
                if (jSONField.serialize()) {
                    i2 = jSONField.ordinal();
                    z.a(jSONField.serialzeFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                }
            }
            if (hVar != null) {
                name = hVar.a(name);
            }
            if (!linkedHashMap.containsKey(name)) {
                a((Class) cls, a22, i);
                linkedHashMap.put(name, new a(name, null, a22, cls, null, i2, null, jSONField, true));
            }
        }
        List<a> arrayList2 = new ArrayList();
        String[] strArr;
        if (jSONType != null) {
            String[] orders = jSONType.orders();
            if (orders != null && orders.length == linkedHashMap.size()) {
                length = orders.length;
                int i3 = 0;
                while (i3 < length) {
                    if (linkedHashMap.containsKey(orders[i3])) {
                        i3++;
                    }
                }
                strArr = orders;
                obj = 1;
            }
            strArr = orders;
            obj = null;
            break;
        }
        strArr = null;
        obj = null;
        if (obj != null) {
            for (Object obj2 : r4) {
                arrayList2.add((a) linkedHashMap.get(obj2));
            }
        } else {
            for (a add : linkedHashMap.values()) {
                arrayList2.add(add);
            }
            if (z) {
                Collections.sort(arrayList2);
            }
        }
        return arrayList2;
    }

    public static JSONField a(Class<?> cls, Method method) {
        for (Class methods : cls.getInterfaces()) {
            for (Method method2 : methods.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    Class[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length == parameterTypes2.length) {
                        int i;
                        Object obj;
                        for (i = 0; i < parameterTypes.length; i++) {
                            if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                obj = null;
                                break;
                            }
                        }
                        i = 1;
                        if (obj != null) {
                            JSONField jSONField = (JSONField) method2.getAnnotation(JSONField.class);
                            if (jSONField != null) {
                                return jSONField;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private static boolean a(Class<?> cls, JSONType jSONType, String str) {
        if (!(jSONType == null || jSONType.ignores() == null)) {
            for (String equalsIgnoreCase : jSONType.ignores()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        Class superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !a(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static boolean a(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        if (genericSuperclass == Object.class || !a(genericSuperclass)) {
            return false;
        }
        return true;
    }

    public static Type b(Type type) {
        Type type2 = type;
        while (type2 instanceof Class) {
            type2 = ((Class) type2).getGenericSuperclass();
        }
        return type2;
    }

    public static Class<?> c(Type type) {
        Object obj = type;
        while (obj.getClass() != Class.class) {
            if (obj instanceof ParameterizedType) {
                obj = ((ParameterizedType) obj).getRawType();
            } else if (obj instanceof TypeVariable) {
                return (Class) ((TypeVariable) obj).getBounds()[0];
            } else {
                return Object.class;
            }
        }
        return (Class) obj;
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        toCharArray[0] = Character.toLowerCase(toCharArray[0]);
        return new String(toCharArray);
    }

    public static boolean a(Class<?> cls, Member member, int i) {
        if (member == null || !b) {
            return false;
        }
        Class superclass = cls.getSuperclass();
        if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
            return false;
        }
        try {
            ((AccessibleObject) member).setAccessible(true);
            return true;
        } catch (AccessControlException e) {
            b = false;
            return false;
        }
    }

    public static Field a(Class<?> cls, String str, Field[] fieldArr) {
        Field b = b(cls, str, fieldArr);
        if (b == null) {
            b = b(cls, "_" + str, fieldArr);
        }
        if (b == null) {
            b = b(cls, "m_" + str, fieldArr);
        }
        if (b == null) {
            return b(cls, new StringBuilder(ab.PROP_FS_MATCH_PARENT).append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString(), fieldArr);
        }
        return b;
    }

    private static Field b(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class superclass = cls.getSuperclass();
        return (superclass == null || superclass == Object.class) ? null : a(superclass, str, superclass.getDeclaredFields());
    }
}
