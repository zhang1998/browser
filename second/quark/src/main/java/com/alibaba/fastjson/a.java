package com.alibaba.fastjson;

import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.e;
import com.alibaba.fastjson.a.i;
import com.alibaba.fastjson.a.n;
import com.alibaba.fastjson.b.aa;
import com.alibaba.fastjson.b.k;
import com.alibaba.fastjson.b.m;
import com.alibaba.fastjson.b.o;
import com.alibaba.fastjson.b.u;
import com.alibaba.fastjson.b.y;
import com.alibaba.fastjson.b.z;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

/* compiled from: ProGuard */
public abstract class a implements c, f {
    public static TimeZone a = TimeZone.getDefault();
    public static Locale b = Locale.getDefault();
    public static int c = ((((((((e.AutoCloseSource.q | 0) | e.InternFieldNames.q) | e.UseBigDecimal.q) | e.AllowUnQuotedFieldNames.q) | e.AllowSingleQuotes.q) | e.AllowArbitraryCommas.q) | e.SortFeidFastMatch.q) | e.IgnoreNotMatch.q);
    public static String d = "yyyy-MM-dd HH:mm:ss";
    public static int e = ((((z.QuoteFieldNames.x | 0) | z.SkipTransientField.x) | z.WriteEnumUsingToString.x) | z.SortField.x);

    public static final Object a(String str) {
        int i = c;
        if (str == null) {
            return null;
        }
        c cVar = new c(str, n.a, i);
        Object a = cVar.a(null);
        cVar.c();
        cVar.close();
        return a;
    }

    public static final e b(String str) {
        Object a = a(str);
        if (a instanceof e) {
            return (e) a;
        }
        return (e) a(a, y.a);
    }

    public static final <T> T a(String str, Type type, e... eVarArr) {
        return a(str, type, n.a, c, eVarArr);
    }

    private static <T> T a(String str, Type type, n nVar, int i, e... eVarArr) {
        if (str == null) {
            return null;
        }
        for (e eVar : eVarArr) {
            i |= eVar.q;
        }
        c cVar = new c(str, nVar, i);
        T a = cVar.a(type, null);
        cVar.c();
        cVar.close();
        return a;
    }

    public static final <T> T a(String str, Class<T> cls) {
        return a(str, cls, n.a, c, new e[0]);
    }

    public static final b c(String str) {
        b bVar = null;
        if (str != null) {
            c cVar = new c(str, n.a);
            i iVar = cVar.e;
            int a = iVar.a();
            if (a == 8) {
                iVar.g();
            } else if (a != 20) {
                Collection bVar2 = new b();
                cVar.b(bVar2);
                cVar.c();
            }
            cVar.close();
        }
        return bVar;
    }

    public static final String a(Object obj) {
        return a(obj, y.a, e, new z[0]);
    }

    public static final String a(Object obj, z... zVarArr) {
        return a(obj, y.a, e, zVarArr);
    }

    public String toString() {
        return n_();
    }

    public final String n_() {
        aa aaVar = new aa(e, z.y);
        try {
            new o(aaVar, y.a).b(this);
            String aaVar2 = aaVar.toString();
            return aaVar2;
        } finally {
            aaVar.close();
        }
    }

    public final void a(Appendable appendable) {
        aa aaVar = new aa(e, z.y);
        try {
            new o(aaVar, y.a).b(this);
            appendable.append(aaVar.toString());
            aaVar.close();
        } catch (Throwable e) {
            throw new d(e.getMessage(), e);
        } catch (Throwable th) {
            aaVar.close();
        }
    }

    public static final Object b(Object obj) {
        return a(obj, y.a);
    }

    public static Object a(Object obj, y yVar) {
        int i = 0;
        if (obj == null) {
            return null;
        }
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            e eVar = new e(map.size());
            for (Entry entry : map.entrySet()) {
                eVar.a(com.alibaba.fastjson.c.e.a(entry.getKey()), a(entry.getValue(), y.a));
            }
            return eVar;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            r1 = new b(collection.size());
            for (Object a : collection) {
                r1.add(a(a, y.a));
            }
            return r1;
        } else {
            Class cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                r1 = new b(length);
                while (i < length) {
                    r1.add(a(Array.get(obj, i), y.a));
                    i++;
                }
                return r1;
            } else if (n.a(cls)) {
                return obj;
            } else {
                u a2 = yVar.a(cls);
                if (!(a2 instanceof m)) {
                    return null;
                }
                m mVar = (m) a2;
                e eVar2 = new e();
                try {
                    Map linkedHashMap = new LinkedHashMap(mVar.a.length);
                    for (k kVar : mVar.a) {
                        linkedHashMap.put(kVar.a.a, kVar.a(obj));
                    }
                    for (Entry entry2 : linkedHashMap.entrySet()) {
                        eVar2.a((String) entry2.getKey(), a(entry2.getValue(), y.a));
                    }
                    return eVar2;
                } catch (Throwable e) {
                    throw new d("toJSON error", e);
                }
            }
        }
    }

    private static String a(Object obj, y yVar, int i, z... zVarArr) {
        aa aaVar = new aa(i, zVarArr);
        try {
            o oVar = new o(aaVar, yVar);
            for (z a : zVarArr) {
                oVar.b.a(a);
            }
            oVar.b(obj);
            String aaVar2 = aaVar.toString();
            return aaVar2;
        } finally {
            aaVar.close();
        }
    }
}
