package com.uc.base.wa.b;

import android.util.Log;
import com.uc.base.wa.config.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class i {
    private static String[] a = null;
    private static String[] b = null;
    private static String[] c = null;
    private static String[] d = null;
    private static String[] e = null;
    private static String[] f = null;

    public static j a(String str) {
        return new g(str);
    }

    public static h a(String str, j jVar, o oVar) {
        if (!(jVar instanceof g)) {
            Log.e("gzm_wa_WaCacheCreater", "", new Throwable());
            return null;
        } else if (str == null) {
            Log.e("gzm_wa_WaCacheCreater", "", new Throwable());
            return null;
        } else {
            Object obj;
            h hVar;
            g gVar = (g) jVar;
            if (oVar == null) {
                obj = str;
            } else {
                String str2 = str + "#" + oVar.getClass().getCanonicalName();
            }
            if (gVar.j == null) {
                hVar = null;
            } else {
                hVar = (h) gVar.j.get(obj);
            }
            if (hVar != null) {
                return hVar;
            }
            HashMap hashMap;
            HashMap hashMap2;
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            if (oVar != null) {
                HashMap hashMap3 = new HashMap();
                oVar.a(hashMap3);
                hashMap = new HashMap();
                oVar.a(hashMap);
                oVar.b(hashMap);
                hashMap2 = hashMap;
                hashMap = hashMap3;
            } else {
                hashMap2 = null;
                hashMap = null;
            }
            HashMap hashMap4 = new HashMap();
            p.a().a(hashMap4);
            HashMap hashMap5 = new HashMap();
            p.a().a(hashMap5);
            p.a().b(hashMap5);
            c cVar = new c();
            c cVar2 = new c();
            c cVar3 = new c();
            String[] strArr = new String[0];
            if (hashMap != null) {
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
                for (Entry entry : hashMap.entrySet()) {
                    if (((Integer) entry.getValue()).intValue() == 0) {
                        arrayList.add(entry.getKey());
                    } else if (((Integer) entry.getValue()).intValue() == 2) {
                        arrayList2.add(entry.getKey());
                    } else {
                        arrayList3.add(entry.getKey());
                    }
                }
                cVar.a = (String[]) arrayList.toArray(strArr);
                cVar2.a = (String[]) arrayList2.toArray(strArr);
                cVar3.a = (String[]) arrayList3.toArray(strArr);
            }
            if (hashMap2 != null) {
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
                for (Entry entry2 : hashMap2.entrySet()) {
                    if (((Integer) entry2.getValue()).intValue() == 0) {
                        arrayList.add(entry2.getKey());
                    } else if (((Integer) entry2.getValue()).intValue() == 2) {
                        arrayList2.add(entry2.getKey());
                    } else {
                        arrayList3.add(entry2.getKey());
                    }
                }
                cVar.b = (String[]) arrayList.toArray(strArr);
                cVar2.b = (String[]) arrayList2.toArray(strArr);
                cVar3.b = (String[]) arrayList3.toArray(strArr);
            }
            if (a == null || b == null || c == null) {
                arrayList4 = new ArrayList();
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                for (Entry entry22 : hashMap4.entrySet()) {
                    if (((Integer) entry22.getValue()).intValue() == 0) {
                        arrayList4.add(entry22.getKey());
                    } else if (((Integer) entry22.getValue()).intValue() == 2) {
                        arrayList.add(entry22.getKey());
                    } else {
                        arrayList2.add(entry22.getKey());
                    }
                }
                a = (String[]) arrayList4.toArray(strArr);
                b = (String[]) arrayList.toArray(strArr);
                c = (String[]) arrayList2.toArray(strArr);
            }
            cVar.c = a;
            cVar2.c = b;
            cVar3.c = c;
            if (d == null || e == null || f == null) {
                arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                arrayList = new ArrayList();
                for (Entry entry222 : hashMap5.entrySet()) {
                    if (((Integer) entry222.getValue()).intValue() == 0) {
                        arrayList4.add(entry222.getKey());
                    } else if (((Integer) entry222.getValue()).intValue() == 2) {
                        arrayList5.add(entry222.getKey());
                    } else {
                        arrayList.add(entry222.getKey());
                    }
                }
                d = (String[]) arrayList4.toArray(strArr);
                e = (String[]) arrayList5.toArray(strArr);
                f = (String[]) arrayList.toArray(strArr);
            }
            cVar.d = d;
            cVar2.d = e;
            cVar3.d = f;
            hVar = new h(str);
            if (!cVar.a()) {
                hVar.a = cVar;
            }
            if (!cVar2.a()) {
                hVar.b = cVar2;
            }
            if (!cVar3.a()) {
                hVar.c = cVar3;
            }
            if (gVar.j == null) {
                gVar.j = new HashMap();
            }
            if (obj != null) {
                Object obj2;
                if (hVar.a == null && hVar.b == null && hVar.c == null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 == null) {
                    gVar.j.put(obj, hVar);
                    return hVar;
                }
            }
            gVar.j.put(obj, g.b);
            return hVar;
        }
    }
}
