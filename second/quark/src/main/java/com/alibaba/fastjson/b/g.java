package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.d;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* compiled from: ProGuard */
public final class g implements e, u {
    public static final g a = new g();

    private g() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        int i = 0;
        aa aaVar = oVar.b;
        if (obj != null) {
            Type type2;
            if ((aaVar.c & z.WriteClassName.x) == 0 || !(type instanceof ParameterizedType)) {
                type2 = null;
            } else {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Collection collection = (Collection) obj;
            x xVar = oVar.j;
            oVar.a(xVar, obj, obj2);
            if ((aaVar.c & z.WriteClassName.x) != 0) {
                if (HashSet.class == collection.getClass()) {
                    aaVar.a((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    aaVar.a((CharSequence) "TreeSet");
                }
            }
            try {
                aaVar.write(91);
                for (Object next : collection) {
                    int i2 = i + 1;
                    if (i != 0) {
                        aaVar.write(44);
                    }
                    if (next == null) {
                        aaVar.write("null");
                        i = i2;
                    } else {
                        Class cls = next.getClass();
                        if (cls == Integer.class) {
                            aaVar.b(((Integer) next).intValue());
                            i = i2;
                        } else if (cls == Long.class) {
                            aaVar.a(((Long) next).longValue());
                            if ((aaVar.c & z.WriteClassName.x) != 0) {
                                aaVar.write(76);
                                i = i2;
                            } else {
                                i = i2;
                            }
                        } else {
                            oVar.a.a(cls).a(oVar, next, Integer.valueOf(i2 - 1), type2);
                            i = i2;
                        }
                    }
                }
                aaVar.write(93);
            } finally {
                oVar.j = xVar;
            }
        } else if ((aaVar.c & z.WriteNullListAsEmpty.x) != 0) {
            aaVar.write("[]");
        } else {
            aaVar.write("null");
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        if (cVar.e.a() == 8) {
            cVar.e.a(16);
            return null;
        } else if (type == b.class) {
            r2 = new b();
            cVar.b(r2);
            return r2;
        } else {
            Type type2 = type;
            while (!(type2 instanceof Class)) {
                if (type2 instanceof ParameterizedType) {
                    type2 = ((ParameterizedType) type2).getRawType();
                } else {
                    throw new d("TODO");
                }
            }
            Class cls = (Class) type2;
            if (cls == AbstractCollection.class || cls == Collection.class) {
                r2 = new ArrayList();
            } else if (cls.isAssignableFrom(HashSet.class)) {
                r2 = new HashSet();
            } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
                r2 = new LinkedHashSet();
            } else if (cls.isAssignableFrom(TreeSet.class)) {
                r2 = new TreeSet();
            } else if (cls.isAssignableFrom(ArrayList.class)) {
                r2 = new ArrayList();
            } else if (cls.isAssignableFrom(EnumSet.class)) {
                if (type instanceof ParameterizedType) {
                    cls = ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    cls = Object.class;
                }
                r2 = EnumSet.noneOf(cls);
            } else {
                try {
                    r2 = (Collection) cls.newInstance();
                } catch (Exception e) {
                    throw new d("create instane error, class " + cls.getName());
                }
            }
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                if (type instanceof Class) {
                    Class cls2 = (Class) type;
                    if (!cls2.getName().startsWith("java.")) {
                        type2 = cls2.getGenericSuperclass();
                        if (type2 instanceof ParameterizedType) {
                            type2 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type2 == null) {
                                type2 = Object.class;
                            }
                        }
                    }
                }
                type2 = null;
                if (type2 == null) {
                    type2 = Object.class;
                }
            }
            cVar.a(type2, r2, obj);
            return r2;
        }
    }
}
