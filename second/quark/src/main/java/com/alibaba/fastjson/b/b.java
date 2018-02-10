package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.i;
import com.alibaba.fastjson.d;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: ProGuard */
public final class b implements e, u {
    public static final b a = new b();

    private b() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        int i = 0;
        Class cls = null;
        aa aaVar = oVar.b;
        Object[] objArr = (Object[]) obj;
        if (obj != null) {
            int length = objArr.length;
            int i2 = length - 1;
            if (i2 == -1) {
                aaVar.a((CharSequence) "[]");
                return;
            }
            x xVar = oVar.j;
            oVar.a(xVar, obj, obj2);
            aaVar.write(91);
            if ((aaVar.c & z.PrettyFormat.x) != 0) {
                oVar.b();
                oVar.d();
                while (i < length) {
                    if (i != 0) {
                        aaVar.write(44);
                        oVar.d();
                    }
                    oVar.b(objArr[i]);
                    i++;
                }
                oVar.c();
                oVar.d();
                aaVar.write(93);
                oVar.j = xVar;
                return;
            }
            length = 0;
            u uVar = null;
            while (length < i2) {
                try {
                    Object obj3 = objArr[length];
                    if (obj3 == null) {
                        aaVar.a((CharSequence) "null,");
                    } else {
                        if (oVar.i == null || !oVar.i.containsKey(obj3)) {
                            Class cls2 = obj3.getClass();
                            if (cls2 == cls) {
                                uVar.a(oVar, obj3, null, null);
                            } else {
                                uVar = oVar.a.a(cls2);
                                uVar.a(oVar, obj3, null, null);
                                cls = cls2;
                            }
                        } else {
                            oVar.a(obj3);
                        }
                        aaVar.write(44);
                    }
                    length++;
                } catch (Throwable e) {
                    throw new d(e.getMessage(), e);
                } catch (Throwable th) {
                    oVar.j = xVar;
                }
            }
            Object obj4 = objArr[i2];
            if (obj4 == null) {
                aaVar.a((CharSequence) "null]");
            } else {
                if (oVar.i == null || !oVar.i.containsKey(obj4)) {
                    Integer valueOf = Integer.valueOf(i2);
                    if (obj4 == null) {
                        oVar.b.write("null");
                    } else {
                        oVar.a.a(obj4.getClass()).a(oVar, obj4, valueOf, null);
                    }
                } else {
                    oVar.a(obj4);
                }
                aaVar.write(93);
            }
            oVar.j = xVar;
        } else if ((aaVar.c & z.WriteNullListAsEmpty.x) != 0) {
            aaVar.write("[]");
        } else {
            aaVar.write("null");
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        i iVar = cVar.e;
        int a = iVar.a();
        if (a == 8) {
            iVar.a(16);
            return null;
        } else if (type == char[].class) {
            if (a == 4) {
                String p = iVar.p();
                iVar.a(16);
                return p.toCharArray();
            } else if (a != 2) {
                return a.a(cVar.a(null)).toCharArray();
            } else {
                Number i = iVar.i();
                iVar.a(16);
                return i.toString().toCharArray();
            }
        } else if (a == 4) {
            T o = iVar.o();
            iVar.a(16);
            return o;
        } else {
            Class componentType = ((Class) type).getComponentType();
            com.alibaba.fastjson.b bVar = new com.alibaba.fastjson.b();
            cVar.a((Type) componentType, (Collection) bVar, obj);
            return a(cVar, componentType, bVar);
        }
    }

    private <T> T a(c cVar, Class<?> cls, com.alibaba.fastjson.b bVar) {
        if (bVar == null) {
            return null;
        }
        int size = bVar.size();
        T newInstance = Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object obj = bVar.get(i);
            if (obj == bVar) {
                Array.set(newInstance, i, newInstance);
            } else {
                if (!cls.isArray()) {
                    obj = com.alibaba.fastjson.c.e.a(obj, (Class) cls, cVar.b);
                } else if (!cls.isInstance(obj)) {
                    obj = a(cVar, (Class) cls, (com.alibaba.fastjson.b) obj);
                }
                Array.set(newInstance, i, obj);
            }
        }
        bVar.c((Object) newInstance);
        bVar.a((Type) cls);
        return newInstance;
    }
}
