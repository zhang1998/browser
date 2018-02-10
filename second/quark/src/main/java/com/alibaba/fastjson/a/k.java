package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.c;
import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.c.a;
import com.alibaba.fastjson.c.d;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: ProGuard */
final class k extends c {
    private final Type a;
    private e d;
    private final boolean e;

    public k(Class<?> cls, a aVar) {
        super(cls, aVar);
        Type type = aVar.g;
        Class cls2 = aVar.f;
        if (type instanceof ParameterizedType) {
            this.a = ((ParameterizedType) type).getActualTypeArguments()[0];
            this.e = false;
        } else if (cls2.isArray()) {
            this.a = cls2.getComponentType();
            this.e = true;
        } else {
            this.a = Object.class;
            this.e = false;
        }
    }

    public final void a(c cVar, Object obj, Type type, Map<String, Object> map) {
        if (cVar.e.a == 8) {
            a(obj, null);
            cVar.e.g();
            return;
        }
        Object obj2;
        b bVar;
        if (this.e) {
            b bVar2 = new b();
            bVar2.a(this.a);
            obj2 = bVar2;
            bVar = bVar2;
        } else {
            bVar = null;
            ArrayList arrayList = new ArrayList();
        }
        m mVar = cVar.f;
        cVar.a(mVar, obj, this.b.a);
        a(cVar, type, obj2);
        cVar.a(mVar);
        if (this.e) {
            obj2 = obj2.toArray((Object[]) Array.newInstance((Class) this.a, obj2.size()));
            bVar.c(obj2);
        }
        if (obj == null) {
            map.put(this.b.a, obj2);
        } else {
            a(obj, obj2);
        }
    }

    private void a(c cVar, Type type, Collection collection) {
        int i;
        int i2;
        Type type2 = this.a;
        e eVar = this.d;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                Class cls;
                e a;
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() instanceof Class) {
                    cls = (Class) parameterizedType.getRawType();
                } else {
                    cls = null;
                }
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (cls.getTypeParameters()[i3].getName().equals(typeVariable.getName())) {
                            i = i3;
                            break;
                        }
                    }
                }
                i = -1;
                if (i != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i];
                    if (!type2.equals(this.a)) {
                        a = cVar.b.a(type2);
                        eVar = a;
                    }
                }
                a = eVar;
                eVar = a;
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    Class cls2;
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    if (parameterizedType3.getRawType() instanceof Class) {
                        cls2 = (Class) parameterizedType3.getRawType();
                    } else {
                        cls2 = null;
                    }
                    if (cls2 != null) {
                        int length2 = cls2.getTypeParameters().length;
                        for (int i4 = 0; i4 < length2; i4++) {
                            if (cls2.getTypeParameters()[i4].getName().equals(typeVariable2.getName())) {
                                i2 = i4;
                                break;
                            }
                        }
                    }
                    i2 = -1;
                    if (i2 != -1) {
                        actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i2];
                        type2 = new d(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        i iVar = cVar.e;
        if (iVar.a != 14) {
            String str = "exepct '[', but " + j.a(iVar.a);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new com.alibaba.fastjson.d(str);
        }
        if (eVar == null) {
            eVar = cVar.b.a(type2);
            this.d = eVar;
        }
        char c = iVar.d;
        if (c == '[') {
            i = iVar.e + 1;
            iVar.e = i;
            if (i >= iVar.p) {
                c = '\u001a';
            } else {
                c = iVar.o.charAt(i);
            }
            iVar.d = c;
            iVar.a = 14;
        } else if (c == '{') {
            i = iVar.e + 1;
            iVar.e = i;
            if (i >= iVar.p) {
                c = '\u001a';
            } else {
                c = iVar.o.charAt(i);
            }
            iVar.d = c;
            iVar.a = 12;
        } else if (c == '\"') {
            iVar.k();
        } else if (c == ']') {
            i = iVar.e + 1;
            iVar.e = i;
            if (i >= iVar.p) {
                c = '\u001a';
            } else {
                c = iVar.o.charAt(i);
            }
            iVar.d = c;
            iVar.a = 15;
        } else {
            iVar.g();
        }
        i = 0;
        while (true) {
            if (iVar.a != 16 || (iVar.c & e.AllowArbitraryCommas.q) == 0) {
                if (iVar.a == 15) {
                    break;
                }
                collection.add(eVar.a(cVar, type2, Integer.valueOf(i)));
                if (cVar.g == 1) {
                    cVar.a(collection);
                }
                if (iVar.a == 16) {
                    char c2 = iVar.d;
                    if (c2 == '[') {
                        i2 = iVar.e + 1;
                        iVar.e = i2;
                        if (i2 >= iVar.p) {
                            c2 = '\u001a';
                        } else {
                            c2 = iVar.o.charAt(i2);
                        }
                        iVar.d = c2;
                        iVar.a = 14;
                    } else if (c2 == '{') {
                        i2 = iVar.e + 1;
                        iVar.e = i2;
                        if (i2 >= iVar.p) {
                            c2 = '\u001a';
                        } else {
                            c2 = iVar.o.charAt(i2);
                        }
                        iVar.d = c2;
                        iVar.a = 12;
                    } else if (c2 == '\"') {
                        iVar.k();
                    } else {
                        iVar.g();
                    }
                }
                i++;
            } else {
                iVar.g();
            }
        }
        if (iVar.d == ',') {
            i = iVar.e + 1;
            iVar.e = i;
            if (i >= iVar.p) {
                c = '\u001a';
            } else {
                c = iVar.o.charAt(i);
            }
            iVar.d = c;
            iVar.a = 16;
            return;
        }
        iVar.g();
    }
}
