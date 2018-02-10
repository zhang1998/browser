package com.alibaba.fastjson.b;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class p implements u {
    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        Object obj3;
        Type type2;
        aa aaVar = oVar.b;
        if ((aaVar.c & z.WriteClassName.x) != 0) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj3 == null || !(type instanceof ParameterizedType)) {
            type2 = null;
        } else {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        if (obj != null) {
            List list = (List) obj;
            int size = list.size();
            if (size == 0) {
                aaVar.a((CharSequence) "[]");
                return;
            }
            x xVar = oVar.j;
            if ((aaVar.c & z.DisableCircularReferenceDetect.x) == 0) {
                oVar.j = new x(xVar, obj, obj2, 0);
                if (oVar.i == null) {
                    oVar.i = new IdentityHashMap();
                }
                oVar.i.put(obj, xVar);
            }
            try {
                int i;
                if ((aaVar.c & z.PrettyFormat.x) != 0) {
                    aaVar.write(91);
                    oVar.b();
                    for (i = 0; i < size; i++) {
                        Object obj4 = list.get(i);
                        if (i != 0) {
                            aaVar.write(44);
                        }
                        oVar.d();
                        if (obj4 == null) {
                            oVar.b.write("null");
                        } else if (oVar.i == null || !oVar.i.containsKey(obj4)) {
                            u a = oVar.a.a(obj4.getClass());
                            oVar.j = new x(xVar, obj, obj2, 0);
                            a.a(oVar, obj4, Integer.valueOf(i), type2);
                        } else {
                            oVar.a(obj4);
                        }
                    }
                    oVar.c();
                    oVar.d();
                    aaVar.write(93);
                    oVar.j = xVar;
                    return;
                }
                i = aaVar.b + 1;
                if (i > aaVar.a.length) {
                    if (aaVar.d == null) {
                        aaVar.a(i);
                    } else {
                        aaVar.flush();
                        i = 1;
                    }
                }
                aaVar.a[aaVar.b] = '[';
                aaVar.b = i;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Object obj5 = list.get(i2);
                    if (i2 != 0) {
                        size = aaVar.b + 1;
                        if (size > aaVar.a.length) {
                            if (aaVar.d == null) {
                                aaVar.a(size);
                            } else {
                                aaVar.flush();
                                size = 1;
                            }
                        }
                        aaVar.a[aaVar.b] = ',';
                        aaVar.b = size;
                    }
                    if (obj5 == null) {
                        aaVar.a((CharSequence) "null");
                    } else {
                        Class cls = obj5.getClass();
                        if (cls == Integer.class) {
                            aaVar.b(((Integer) obj5).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj5).longValue();
                            if (obj3 != null) {
                                aaVar.a(longValue);
                                aaVar.write(76);
                            } else {
                                aaVar.a(longValue);
                            }
                        } else if (cls == String.class) {
                            String str = (String) obj5;
                            if ((aaVar.c & z.UseSingleQuotes.x) != 0) {
                                aaVar.b(str);
                            } else {
                                aaVar.a(str, '\u0000', true);
                            }
                        } else {
                            if ((aaVar.c & z.DisableCircularReferenceDetect.x) == 0) {
                                oVar.j = new x(xVar, obj, obj2, 0);
                            }
                            if (oVar.i == null || !oVar.i.containsKey(obj5)) {
                                oVar.a.a(obj5.getClass()).a(oVar, obj5, Integer.valueOf(i2), type2);
                            } else {
                                oVar.a(obj5);
                            }
                        }
                    }
                }
                int i3 = aaVar.b + 1;
                if (i3 > aaVar.a.length) {
                    if (aaVar.d == null) {
                        aaVar.a(i3);
                    } else {
                        aaVar.flush();
                        i3 = 1;
                    }
                }
                aaVar.a[aaVar.b] = ']';
                aaVar.b = i3;
                oVar.j = xVar;
            } catch (Throwable th) {
                oVar.j = xVar;
            }
        } else if ((aaVar.c & z.WriteNullListAsEmpty.x) != 0) {
            aaVar.write("[]");
        } else {
            aaVar.write("null");
        }
    }
}
