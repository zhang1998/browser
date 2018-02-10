package com.uc.base.wa.b;

import android.util.Log;
import com.uc.base.wa.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class q {
    public HashMap<String, String> a;
    public HashMap<String, a> b;
    public HashMap<String, b> c;
    public HashMap<String, Long> d;
    public HashMap<String, Long> e;

    public final int a() {
        int i = 0;
        if (this.a != null) {
            i = this.a.size() + 0;
        }
        if (this.b != null) {
            i += this.b.size();
        }
        if (this.c != null) {
            i += this.c.size();
        }
        if (this.d != null) {
            i += this.d.size();
        }
        if (this.e != null) {
            return i + this.e.size();
        }
        return i;
    }

    public final String toString() {
        return "last" + (this.a == null ? "{}" : this.a.toString()) + "; avg" + (this.b == null ? "{}" : this.b.toString()) + "; sum" + (this.c == null ? "{}" : this.c.toString()) + "; max" + (this.d == null ? "{}" : this.d.toString()) + "; min" + (this.e == null ? "{}" : this.e.toString()) + ";";
    }

    public static void a(q qVar, String str, a aVar) {
        if (qVar != null && str != null && aVar != null) {
            HashMap h = qVar.h();
            a aVar2 = (a) h.get(str);
            if (aVar2 == null) {
                aVar2 = new a(0.0d, 0);
                h.put(str, aVar2);
            }
            if (aVar.b <= 0) {
                return;
            }
            if (aVar2.b <= 0) {
                aVar2.a(aVar.b, aVar.a);
                return;
            }
            int i = aVar2.b + aVar.b;
            if (i <= 1) {
                Log.e("gzm_WebAnalyse", "", new Throwable());
            } else {
                aVar2.a(i, ((((double) aVar2.b) / ((double) i)) * aVar2.a) + ((((double) aVar.b) / ((double) i)) * aVar.a));
            }
        }
    }

    public static void a(q qVar, HashMap<String, a> hashMap) {
        if (qVar != null && hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                a(qVar, (String) entry.getKey(), (a) entry.getValue());
            }
        }
    }

    public static void a(q qVar, String str, b bVar) {
        if (qVar != null && str != null && bVar != null) {
            HashMap i = qVar.i();
            b bVar2 = (b) i.get(str);
            if (bVar2 == null) {
                bVar2 = new b(0, 0, bVar.c);
                i.put(str, bVar2);
            }
            if (bVar.b <= 0) {
                return;
            }
            if (bVar2.b <= 0) {
                bVar2.a(bVar.a, bVar.b);
                return;
            }
            int i2 = bVar2.b + bVar.b;
            if (i2 <= 1) {
                Log.e("gzm_WebAnalyse", "", new Throwable());
            } else {
                bVar2.a(bVar.a + bVar2.a, i2);
            }
            if (bVar.c) {
                bVar2.c |= 1;
            }
        }
    }

    public static void b(q qVar, HashMap<String, b> hashMap) {
        if (qVar != null && hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                a(qVar, (String) entry.getKey(), (b) entry.getValue());
            }
        }
    }

    public static void a(q qVar, String str, Long l) {
        if (qVar != null && str != null && l != null) {
            HashMap j = qVar.j();
            Long l2 = (Long) j.get(str);
            if (l2 == null) {
                j.put(str, l);
            } else {
                j.put(str, Long.valueOf(Math.max(l.longValue(), l2.longValue())));
            }
        }
    }

    public static void c(q qVar, HashMap<String, Long> hashMap) {
        if (qVar != null && hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                a(qVar, (String) entry.getKey(), (Long) entry.getValue());
            }
        }
    }

    public static void b(q qVar, String str, Long l) {
        if (qVar != null && str != null && l != null) {
            HashMap k = qVar.k();
            Long l2 = (Long) k.get(str);
            if (l2 == null) {
                k.put(str, l);
            } else {
                k.put(str, Long.valueOf(Math.min(l.longValue(), l2.longValue())));
            }
        }
    }

    public static void d(q qVar, HashMap<String, Long> hashMap) {
        if (qVar != null && hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                b(qVar, (String) entry.getKey(), (Long) entry.getValue());
            }
        }
    }

    public final boolean b() {
        return this.a != null;
    }

    public final boolean c() {
        return this.b != null;
    }

    public final boolean d() {
        return this.c != null;
    }

    public final boolean e() {
        return this.d != null;
    }

    public final boolean f() {
        return this.e != null;
    }

    public final HashMap<String, String> g() {
        if (this.a == null) {
            this.a = new HashMap();
        }
        return this.a;
    }

    public final HashMap<String, a> h() {
        if (this.b == null) {
            this.b = new HashMap();
        }
        return this.b;
    }

    public final HashMap<String, b> i() {
        if (this.c == null) {
            this.c = new HashMap();
        }
        return this.c;
    }

    public final HashMap<String, Long> j() {
        if (this.d == null) {
            this.d = new HashMap();
        }
        return this.d;
    }

    public final HashMap<String, Long> k() {
        if (this.e == null) {
            this.e = new HashMap();
        }
        return this.e;
    }

    public final ArrayList<HashMap<String, String>> a(HashMap<String, String> hashMap) {
        HashMap hashMap2;
        Long l;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList();
        if (this.a != null) {
            for (Entry entry : this.a.entrySet()) {
                hashMap2 = new HashMap();
                hashMap2.putAll(hashMap);
                String str = (String) entry.getValue();
                if (str != null) {
                    hashMap2.put(entry.getKey(), str);
                }
                arrayList.add(hashMap2);
            }
        }
        if (this.b != null) {
            for (Entry entry2 : this.b.entrySet()) {
                hashMap2 = new HashMap();
                hashMap2.putAll(hashMap);
                a aVar = (a) entry2.getValue();
                if (aVar != null) {
                    hashMap2.put(entry2.getKey(), String.valueOf(aVar.a));
                }
                arrayList.add(hashMap2);
            }
        }
        if (this.c != null) {
            for (Entry entry22 : this.c.entrySet()) {
                hashMap2 = new HashMap();
                hashMap2.putAll(hashMap);
                b bVar = (b) entry22.getValue();
                if (bVar != null) {
                    hashMap2.put(entry22.getKey(), String.valueOf(bVar.a));
                    if (bVar.c) {
                        hashMap2.put("ev_an", String.valueOf(bVar.b));
                    }
                }
                arrayList.add(hashMap2);
            }
        }
        if (this.d != null) {
            for (Entry entry222 : this.d.entrySet()) {
                hashMap2 = new HashMap();
                hashMap2.putAll(hashMap);
                l = (Long) entry222.getValue();
                if (l != null) {
                    hashMap2.put(entry222.getKey(), String.valueOf(l));
                }
                arrayList.add(hashMap2);
            }
        }
        if (this.e != null) {
            for (Entry entry2222 : this.e.entrySet()) {
                hashMap2 = new HashMap();
                hashMap2.putAll(hashMap);
                l = (Long) entry2222.getValue();
                if (l != null) {
                    hashMap2.put(entry2222.getKey(), String.valueOf(l));
                }
                arrayList.add(hashMap2);
            }
        }
        return arrayList;
    }

    public final q a(HashMap<String, String> hashMap, String str) {
        q qVar = new q();
        if (hashMap == null) {
            return qVar;
        }
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = (String) hashMap.remove("lt");
        if (str2 != null) {
            stringBuilder.append("lt=" + str2);
        } else {
            stringBuilder.append("lt=ev");
            c.a().b("lt is null");
        }
        stringBuilder.append("`ct=" + str);
        Iterator it = hashMap.entrySet().iterator();
        if (it.hasNext()) {
            stringBuilder.append("`");
            while (true) {
                Entry entry = (Entry) it.next();
                stringBuilder.append((String) entry.getKey()).append("=").append((String) entry.getValue());
                if (!it.hasNext()) {
                    break;
                }
                stringBuilder.append("`");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (this.a != null) {
            qVar.a = new HashMap();
            for (Entry entry2 : this.a.entrySet()) {
                qVar.a.put(a(stringBuilder2, (String) entry2.getKey()), (String) entry2.getValue());
            }
        }
        if (this.b != null) {
            qVar.b = new HashMap();
            for (Entry entry3 : this.b.entrySet()) {
                String a = a(stringBuilder2, (String) entry3.getKey());
                a aVar = (a) entry3.getValue();
                HashMap hashMap2 = qVar.b;
                if (aVar == null) {
                    obj = null;
                } else {
                    aVar = new a(aVar.a, aVar.b);
                }
                hashMap2.put(a, obj);
            }
        }
        if (this.c != null) {
            qVar.c = new HashMap();
            for (Entry entry32 : this.c.entrySet()) {
                a = a(stringBuilder2, (String) entry32.getKey());
                b bVar = (b) entry32.getValue();
                hashMap2 = qVar.c;
                if (bVar == null) {
                    obj = null;
                } else {
                    bVar = new b(bVar.a, bVar.b, bVar.c);
                }
                hashMap2.put(a, obj);
            }
        }
        if (this.d != null) {
            qVar.d = new HashMap();
            for (Entry entry322 : this.d.entrySet()) {
                qVar.d.put(a(stringBuilder2, (String) entry322.getKey()), (Long) entry322.getValue());
            }
        }
        if (this.e != null) {
            qVar.e = new HashMap();
            for (Entry entry3222 : this.e.entrySet()) {
                qVar.e.put(a(stringBuilder2, (String) entry3222.getKey()), (Long) entry3222.getValue());
            }
        }
        return qVar;
    }

    private static String a(String str, String str2) {
        if (str2 == null || str == null) {
            return "";
        }
        if (str2.startsWith("`")) {
            return "`" + str + "`" + str2.substring(1);
        }
        return str2;
    }
}
