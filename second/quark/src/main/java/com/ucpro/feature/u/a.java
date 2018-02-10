package com.ucpro.feature.u;

import com.ucpro.c.b;
import com.ucpro.ui.b.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a {
    private static HashMap<String, ArrayList<WeakReference<Object>>> a = null;

    public static void a(String str, Object obj) {
        if (b.b()) {
            ArrayList arrayList;
            if (a == null) {
                a = new HashMap();
            }
            if (a.containsKey(str)) {
                arrayList = (ArrayList) a.get(str);
            } else {
                arrayList = new ArrayList(32);
                a.put(str, arrayList);
            }
            arrayList.add(new WeakReference(obj));
        }
    }

    public static HashMap<String, Integer> a() {
        if (b.b()) {
            if (a == null) {
                a = new HashMap();
            }
            HashMap<String, Integer> hashMap = new HashMap(4);
            for (Entry entry : a.entrySet()) {
                ArrayList arrayList = (ArrayList) entry.getValue();
                int i = 0;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((WeakReference) arrayList.get(i2)).get() != null) {
                        i++;
                    }
                }
                hashMap.put(entry.getKey(), Integer.valueOf(i));
            }
            return hashMap;
        }
        e.a().a("本功能不开放", 1);
        return null;
    }
}
