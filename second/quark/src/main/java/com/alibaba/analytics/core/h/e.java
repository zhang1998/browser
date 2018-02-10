package com.alibaba.analytics.core.h;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.db.a;
import com.alibaba.analytics.core.model.LogField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class e extends m {
    private static e a = null;
    private final Map<String, String> b = Collections.synchronizedMap(new HashMap());
    private final Map<String, List<q>> c = Collections.synchronizedMap(new HashMap());
    private final String[] d = new String[]{"utap_system"};
    private final Map<String, o> e = new HashMap();

    private e() {
        try {
            if (b.a().n != null) {
                List a = b.a().n.a(a.class, null, null, -1);
                if (a.size() > 0) {
                    Map synchronizedMap = Collections.synchronizedMap(new HashMap(a.size()));
                    for (int i = 0; i < a.size(); i++) {
                        synchronizedMap.put(((a) a.get(i)).a, ((a) a.get(i)).b);
                    }
                    b(synchronizedMap);
                }
            }
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public final String a(String str) {
        return (String) this.b.get(str);
    }

    public final void a(String str, q qVar) {
        synchronized (this.c) {
            List arrayList;
            if (this.c.get(str) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (List) this.c.get(str);
            }
            arrayList.add(qVar);
            this.c.put(str, arrayList);
        }
    }

    public final String[] c() {
        return this.d;
    }

    public final void a(String str, Map<String, String> map) {
        if ("utap_system".equalsIgnoreCase(str)) {
            b((Map) map);
            b.a().n.c(a.class);
            a aVar = b.a().n;
            Map map2 = this.b;
            List arrayList = new ArrayList(map2.size());
            for (String str2 : map2.keySet()) {
                a aVar2 = new a();
                aVar2.a = str2;
                aVar2.b = (String) map2.get(str2);
                arrayList.add(aVar2);
            }
            aVar.a(arrayList);
        }
    }

    private void b(Map<String, String> map) {
        c(map);
        Map hashMap = new HashMap(this.b.size());
        hashMap.putAll(this.b);
        this.b.clear();
        this.b.putAll(map);
        for (String str : this.b.keySet()) {
            if ((this.b.get(str) == null && hashMap.get(str) != null) || !(this.b.get(str) == null || ((String) this.b.get(str)).equalsIgnoreCase((String) hashMap.get(str)))) {
                a(str, (String) this.b.get(str));
            }
            hashMap.remove(str);
        }
        for (String str2 : hashMap.keySet()) {
            a(str2, (String) this.b.get(str2));
        }
    }

    private void a(String str, String str2) {
        List list = (List) this.c.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                ((q) list.get(i)).b(str, str2);
            }
        }
    }

    public final int b(String str) {
        int i = 0;
        Object a = a(str);
        if (!TextUtils.isEmpty(a)) {
            try {
                i = Integer.valueOf(a).intValue();
            } catch (Exception e) {
            }
        }
        return i;
    }

    private synchronized void c(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey("delay")) {
                if ((this.b.get("delay") == null || !((String) map.get("delay")).equals(this.b.get("delay"))) && this.e != null) {
                    this.e.clear();
                    try {
                        JSONObject jSONObject = new JSONObject((String) map.get("delay"));
                        Iterator keys = jSONObject.keys();
                        if (keys != null) {
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                Object string = jSONObject.getString(str);
                                if (!TextUtils.isEmpty(string)) {
                                    o a = o.a(string);
                                    if (a != null) {
                                        this.e.put(str, a);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        if (this.e != null) {
            this.e.clear();
        }
    }

    public final synchronized boolean a(Map<String, String> map) {
        boolean z;
        if (this.e == null || this.e.size() <= 0) {
            z = false;
        } else {
            int parseInt;
            if (map.containsKey(LogField.EVENTID.toString())) {
                try {
                    parseInt = Integer.parseInt((String) map.get(LogField.EVENTID.toString()));
                } catch (Exception e) {
                }
                if (this.e.containsKey(String.valueOf(parseInt))) {
                    parseInt -= parseInt % 10;
                    if (this.e.containsKey(String.valueOf(parseInt))) {
                        parseInt -= parseInt % 100;
                        if (this.e.containsKey(String.valueOf(parseInt))) {
                            parseInt -= parseInt % 1000;
                            z = this.e.containsKey(String.valueOf(parseInt)) ? a((Map) map, parseInt) : this.e.containsKey("-1") ? a((Map) map, -1) : false;
                        } else {
                            z = a((Map) map, parseInt);
                        }
                    } else {
                        z = a((Map) map, parseInt);
                    }
                } else {
                    z = a((Map) map, parseInt);
                }
            }
            parseInt = -1;
            if (this.e.containsKey(String.valueOf(parseInt))) {
                parseInt -= parseInt % 10;
                if (this.e.containsKey(String.valueOf(parseInt))) {
                    parseInt -= parseInt % 100;
                    if (this.e.containsKey(String.valueOf(parseInt))) {
                        parseInt -= parseInt % 1000;
                        if (this.e.containsKey(String.valueOf(parseInt))) {
                        }
                    } else {
                        z = a((Map) map, parseInt);
                    }
                } else {
                    z = a((Map) map, parseInt);
                }
            } else {
                z = a((Map) map, parseInt);
            }
        }
        return z;
    }

    private boolean a(Map<String, String> map, int i) {
        o oVar = (o) this.e.get(String.valueOf(i));
        if (oVar == null) {
            return false;
        }
        String str = null;
        if (map.containsKey(LogField.ARG1.toString())) {
            str = (String) map.get(LogField.ARG1.toString());
        }
        if (oVar.a == 0) {
            return oVar.b(str);
        }
        if (1 == oVar.a) {
            return !oVar.b(str);
        } else {
            return false;
        }
    }
}
