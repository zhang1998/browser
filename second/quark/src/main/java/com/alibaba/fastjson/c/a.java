package com.alibaba.fastjson.c;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: ProGuard */
public final class a implements Comparable<a> {
    public final String a;
    public final Method b;
    public final Field c;
    public final boolean d;
    public final boolean e;
    public final Class<?> f;
    public final Type g;
    public final Class<?> h;
    public final boolean i;
    public final char[] j;
    public final boolean k;
    public final String l;
    private int m = 0;
    private final JSONField n;
    private final JSONField o;

    public final /* synthetic */ int compareTo(Object obj) {
        return a((a) obj);
    }

    public a(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i) {
        this.a = str;
        this.h = cls;
        this.f = cls2;
        this.g = type;
        this.b = null;
        this.c = field;
        this.m = i;
        this.k = cls2.isEnum();
        this.n = null;
        this.o = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            boolean z = (modifiers & 1) != 0 || this.b == null;
            this.d = z;
            this.e = Modifier.isTransient(modifiers);
        } else {
            this.d = false;
            this.e = false;
        }
        this.i = false;
        int length = this.a.length();
        this.j = new char[(length + 3)];
        this.a.getChars(0, this.a.length(), this.j, 1);
        this.j[0] = '\"';
        this.j[length + 1] = '\"';
        this.j[length + 2] = ':';
        this.l = null;
    }

    public a(String str, Method method, Field field, Class<?> cls, Type type, int i, JSONField jSONField, JSONField jSONField2, boolean z) {
        boolean z2;
        Type type2;
        Class cls2;
        Type type3;
        Class cls3;
        this.a = str;
        this.b = method;
        this.c = field;
        this.m = i;
        this.o = jSONField;
        this.n = jSONField2;
        JSONField a = a();
        String str2 = null;
        if (a != null) {
            str2 = a.format();
            if (str2.trim().length() == 0) {
                str2 = null;
            }
        }
        this.l = str2;
        if (field != null) {
            int modifiers = field.getModifiers();
            z2 = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.d = z2;
            this.e = (modifiers & 128) != 0;
        } else {
            this.d = false;
            this.e = false;
        }
        int length = this.a.length();
        this.j = new char[(length + 3)];
        this.a.getChars(0, this.a.length(), this.j, 1);
        this.j[0] = '\"';
        this.j[length + 1] = '\"';
        this.j[length + 2] = ':';
        Class cls4;
        if (method != null) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                if (cls4 == Class.class || cls4 == String.class || cls4.isPrimitive()) {
                    type2 = cls4;
                } else {
                    type2 = method.getGenericParameterTypes()[0];
                }
                this.i = false;
            } else {
                cls4 = method.getReturnType();
                if (cls4 != Class.class) {
                    type2 = method.getGenericReturnType();
                } else {
                    Object obj = cls4;
                }
                this.i = true;
            }
            this.h = method.getDeclaringClass();
            cls2 = cls4;
            type3 = type2;
        } else {
            cls4 = field.getType();
            if (cls4.isPrimitive() || cls4 == String.class || cls4.isEnum()) {
                type2 = cls4;
            } else {
                type2 = field.getGenericType();
            }
            this.h = field.getDeclaringClass();
            this.i = Modifier.isFinal(field.getModifiers());
            cls2 = cls4;
            type3 = type2;
        }
        if (cls != null && cls2 == Object.class && (type3 instanceof TypeVariable)) {
            type2 = a(cls, (TypeVariable) type3);
            if (type2 != null) {
                this.f = e.c(type2);
                this.g = type2;
                this.k = cls2.isEnum();
                return;
            }
        }
        if (type3 instanceof Class) {
            cls3 = cls2;
        } else {
            if (type == null) {
                Object obj2 = cls;
            }
            Type a2 = a(cls, type, type3);
            if (a2 != type3) {
                if (a2 instanceof ParameterizedType) {
                    cls3 = e.c(a2);
                    type3 = a2;
                } else if (a2 instanceof Class) {
                    cls3 = e.c(a2);
                    type3 = a2;
                }
            }
            cls3 = cls2;
            type3 = a2;
        }
        this.g = type3;
        this.f = cls3;
        if (cls3.isArray() || !cls3.isEnum()) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.k = z2;
    }

    private static Type a(Class<?> cls, Type type, Type type2) {
        Type[] typeArr = null;
        if (cls == null || type == null) {
            return type2;
        }
        Type genericComponentType;
        Type a;
        if (type2 instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
            a = a(cls, type, genericComponentType);
            if (genericComponentType != a) {
                return Array.newInstance(e.c(a), 0).getClass();
            }
            return type2;
        } else if (!e.a(type)) {
            return type2;
        } else {
            TypeVariable typeVariable;
            if (type2 instanceof TypeVariable) {
                genericComponentType = (ParameterizedType) e.b(type);
                Class c = e.c(genericComponentType);
                typeVariable = (TypeVariable) type2;
                for (int i = 0; i < c.getTypeParameters().length; i++) {
                    if (c.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                        return genericComponentType.getActualTypeArguments()[i];
                    }
                }
            }
            if (!(type2 instanceof ParameterizedType)) {
                return type2;
            }
            TypeVariable[] typeParameters;
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (type instanceof ParameterizedType) {
                type = (ParameterizedType) type;
                typeParameters = cls.getTypeParameters();
            } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) cls.getGenericSuperclass();
                typeParameters = cls.getSuperclass().getTypeParameters();
                Object obj = parameterizedType2;
            } else {
                type = null;
                typeParameters = null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < actualTypeArguments.length && type != null; i3++) {
                a = actualTypeArguments[i3];
                if (a instanceof TypeVariable) {
                    typeVariable = (TypeVariable) a;
                    for (int i4 = 0; i4 < typeParameters.length; i4++) {
                        if (typeParameters[i4].getName().equals(typeVariable.getName())) {
                            if (typeArr == null) {
                                typeArr = type.getActualTypeArguments();
                            }
                            actualTypeArguments[i3] = typeArr[i4];
                            i2 = 1;
                        }
                    }
                }
            }
            if (i2 != 0) {
                return new d(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
            }
            return type2;
        }
    }

    private static Type a(Class<?> cls, TypeVariable<?> typeVariable) {
        Type genericDeclaration = typeVariable.getGenericDeclaration();
        Type genericSuperclass;
        do {
            genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (parameterizedType.getRawType() == genericDeclaration) {
                    TypeVariable[] typeParameters = genericDeclaration.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (typeParameters[i] == typeVariable) {
                            return actualTypeArguments[i];
                        }
                    }
                    return null;
                }
            }
            cls = e.c(genericSuperclass);
        } while (genericSuperclass != null);
        return null;
    }

    public final String toString() {
        return this.a;
    }

    public final int a(a aVar) {
        if (this.m < aVar.m) {
            return -1;
        }
        if (this.m > aVar.m) {
            return 1;
        }
        return this.a.compareTo(aVar.a);
    }

    public final JSONField a() {
        if (this.n != null) {
            return this.n;
        }
        return this.o;
    }
}
