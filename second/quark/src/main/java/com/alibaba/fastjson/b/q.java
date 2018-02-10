package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: ProGuard */
public final class q implements u {
    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        if (obj == null) {
            aaVar.write("null");
            return;
        }
        Map treeMap;
        x xVar;
        Object obj3;
        Class cls;
        u uVar;
        Object obj4;
        Object value;
        Object a;
        Class cls2;
        Map map = (Map) obj;
        Class cls3 = map.getClass();
        Object obj5 = ((cls3 == e.class || cls3 == HashMap.class || cls3 == LinkedHashMap.class) && map.containsKey("@type")) ? 1 : null;
        if (!((aaVar.c & z.SortField.x) == 0 || (map instanceof SortedMap) || (map instanceof LinkedHashMap))) {
            try {
                treeMap = new TreeMap(map);
            } catch (Exception e) {
            }
            if (oVar.i == null && oVar.i.containsKey(obj)) {
                oVar.a(obj);
                return;
            }
            xVar = oVar.j;
            oVar.a(xVar, obj, obj2);
            aaVar.write(123);
            oVar.b();
            obj3 = 1;
            if ((aaVar.c & z.WriteClassName.x) != 0 && obj5 == null) {
                aaVar.a(oVar.a.b, false);
                aaVar.a(obj.getClass().getName());
                obj3 = null;
            }
            cls = null;
            uVar = null;
            obj4 = obj3;
            for (Entry entry : r3.entrySet()) {
                value = entry.getValue();
                obj3 = entry.getKey();
                if (oVar.d(obj3) && oVar.e(obj3)) {
                    obj5 = oVar.c(obj3);
                    a = o.a(oVar, obj5, value);
                    if (a == null || (aaVar.c & z.WriteMapNullValue.x) != 0) {
                        if (obj5 instanceof String) {
                            if (obj4 == null) {
                                aaVar.write(44);
                            }
                            if ((aaVar.c & z.BrowserCompatible.x) == 0 || (aaVar.c & z.WriteNonStringKeyAsString.x) != 0) {
                                oVar.a(a.a(obj5));
                            } else {
                                oVar.b(obj5);
                            }
                            aaVar.write(58);
                        } else {
                            String str = (String) obj5;
                            if (obj4 == null) {
                                aaVar.write(44);
                            }
                            if ((aaVar.c & z.PrettyFormat.x) != 0) {
                                oVar.d();
                            }
                            aaVar.a(str, true);
                        }
                        if (a != null) {
                            aaVar.write("null");
                            obj4 = null;
                        } else {
                            cls2 = a.getClass();
                            if (cls2 != cls) {
                                uVar.a(oVar, a, obj5, null);
                                obj4 = null;
                            } else {
                                u a2 = oVar.a.a(cls2);
                                a2.a(oVar, a, obj5, null);
                                uVar = a2;
                                cls = cls2;
                                obj4 = null;
                            }
                        }
                    }
                }
            }
            oVar.c();
            if ((aaVar.c & z.PrettyFormat.x) != 0 && r3.size() > 0) {
                oVar.d();
            }
            aaVar.write(125);
        }
        treeMap = map;
        if (oVar.i == null) {
        }
        xVar = oVar.j;
        oVar.a(xVar, obj, obj2);
        try {
            aaVar.write(123);
            oVar.b();
            obj3 = 1;
            aaVar.a(oVar.a.b, false);
            aaVar.a(obj.getClass().getName());
            obj3 = null;
            cls = null;
            uVar = null;
            obj4 = obj3;
            for (Entry entry2 : r3.entrySet()) {
                value = entry2.getValue();
                obj3 = entry2.getKey();
                obj5 = oVar.c(obj3);
                a = o.a(oVar, obj5, value);
                if (a == null) {
                }
                if (obj5 instanceof String) {
                    if (obj4 == null) {
                        aaVar.write(44);
                    }
                    if ((aaVar.c & z.BrowserCompatible.x) == 0) {
                    }
                    oVar.a(a.a(obj5));
                    aaVar.write(58);
                } else {
                    String str2 = (String) obj5;
                    if (obj4 == null) {
                        aaVar.write(44);
                    }
                    if ((aaVar.c & z.PrettyFormat.x) != 0) {
                        oVar.d();
                    }
                    aaVar.a(str2, true);
                }
                if (a != null) {
                    cls2 = a.getClass();
                    if (cls2 != cls) {
                        u a22 = oVar.a.a(cls2);
                        a22.a(oVar, a, obj5, null);
                        uVar = a22;
                        cls = cls2;
                        obj4 = null;
                    } else {
                        uVar.a(oVar, a, obj5, null);
                        obj4 = null;
                    }
                } else {
                    aaVar.write("null");
                    obj4 = null;
                }
            }
            oVar.c();
            oVar.d();
            aaVar.write(125);
        } finally {
            oVar.j = xVar;
        }
    }
}
