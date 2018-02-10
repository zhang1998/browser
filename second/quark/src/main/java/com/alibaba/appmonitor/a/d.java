package com.alibaba.appmonitor.a;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.h.m;
import com.alibaba.appmonitor.f.h;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: ProGuard */
public class d extends m {
    private static d c = null;
    private static final String[] d = new String[]{"ap_stat", "ap_counter", "ap_alarm"};
    public Map<h, a> a = Collections.synchronizedMap(new HashMap(3));
    public int b;

    private d() {
        a aVar;
        b();
        for (h hVar : h.values()) {
            Object obj;
            Class cls = hVar.j;
            a a = a(b.a().n.a(cls, null, "module,mp ASC ", -1));
            if (a == null) {
                try {
                    obj = (a) cls.newInstance();
                    try {
                        obj.b = "event_type";
                        obj.a(hVar.k);
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    aVar = a;
                }
            } else {
                aVar = a;
            }
            this.a.put(hVar, obj);
        }
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public final boolean a(h hVar, String str, String str2) {
        a aVar = (a) this.a.get(hVar);
        if (aVar != null) {
            int i = this.b;
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(str);
            arrayList.add(str2);
            return aVar.a(i, arrayList);
        }
        af.a("eventTypeSample  ==null", new Object[0]);
        return false;
    }

    public final void b() {
        this.b = new Random(System.currentTimeMillis()).nextInt(10000);
    }

    public final void a(h hVar, int i) {
        a aVar = (a) this.a.get(hVar);
        if (aVar != null) {
            aVar.a(i);
        }
        af.a("setSampling end", new Object[0]);
    }

    private static a a(Class<? extends a> cls, e eVar) {
        a aVar = null;
        try {
            a aVar2 = (a) cls.newInstance();
            try {
                if (eVar.containsKey("offline")) {
                    aVar2.c = eVar.h("offline");
                }
                if (eVar.containsKey("cp")) {
                    aVar2.a(eVar.g("cp"));
                }
                if (aVar2 instanceof e) {
                    aVar = (e) aVar2;
                    if (eVar.containsKey("scp")) {
                        aVar.d = eVar.g("scp");
                    }
                    if (!eVar.containsKey("fcp")) {
                        return aVar;
                    }
                    aVar.e = eVar.g("fcp");
                    return aVar;
                }
                if (aVar2 instanceof c) {
                    c cVar = (c) aVar2;
                    if (eVar.containsKey("detail")) {
                        cVar.d = eVar.g("detail");
                    }
                }
                return aVar2;
            } catch (Throwable th) {
                aVar = aVar2;
                af.d("new AppMonitorConfig error", new Object[0]);
                return aVar;
            }
        } catch (Throwable th2) {
            af.d("new AppMonitorConfig error", new Object[0]);
            return aVar;
        }
    }

    private static a a(List<a> list) {
        a aVar;
        int size = list.size();
        int i = 0;
        while (i < size && !"event_type".equalsIgnoreCase(((a) list.get(i)).b)) {
            i++;
        }
        if (i < size) {
            a aVar2 = (a) list.remove(i);
            af.a("remove root element", new Object[0]);
            aVar = aVar2;
        } else {
            af.c("cannot found the root element", new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            aVar2 = (a) list.get(i2);
            if (TextUtils.isEmpty(aVar2.a)) {
                aVar.a(aVar2.b, aVar2);
            } else {
                aVar.b(aVar2.b).a(aVar2.a, aVar2);
            }
        }
        return aVar;
    }

    public final String[] c() {
        return d;
    }

    public final void a(String str, Map<String, String> map) {
        af.a("", "namespace", str, "config:", map);
        if (!com.alibaba.analytics.a.b.c(str) && map != null) {
            List arrayList = new ArrayList();
            h a = h.a(str);
            Class cls = a.j;
            e b;
            try {
                a aVar;
                a a2;
                if (map.containsKey("event_type")) {
                    a2 = a(cls, a.b((String) map.get("event_type")));
                    map.remove("event_type");
                    aVar = a2;
                } else {
                    try {
                        a2 = (a) cls.newInstance();
                        if (a2 instanceof e) {
                            e eVar = (e) a2;
                            eVar.d = a.k;
                            eVar.e = a.k;
                            aVar = a2;
                        } else {
                            a2.a(a.k);
                            aVar = a2;
                        }
                    } catch (Throwable th) {
                        return;
                    }
                }
                aVar.b = "event_type";
                for (String str2 : map.keySet()) {
                    b = a.b((String) map.get(str2));
                    if (b != null) {
                        try {
                            a a3 = a(cls, b);
                            a3.b = str2;
                            e d = b.d("mps");
                            if (d != null) {
                                for (String str3 : d.keySet()) {
                                    a a4 = a(cls, d.d(str3));
                                    a4.b = str2;
                                    a4.a = str3;
                                    a3.a(str3, a4);
                                    arrayList.add(a4);
                                }
                            }
                            aVar.a(str2, a3);
                            arrayList.add(a3);
                        } catch (Throwable th2) {
                        }
                    }
                }
                arrayList.add(aVar);
                this.a.put(a, aVar);
                b.a().n.c(aVar.getClass());
                b.a().n.a(arrayList);
            } catch (Throwable th3) {
                af.d("", "parse config error", th3);
            }
        }
    }

    public final boolean b(h hVar, String str, String str2) {
        boolean z;
        if (hVar != null && hVar == h.COUNTER && "AppMonitor".equalsIgnoreCase(str) && ("upload_traffic".equalsIgnoreCase(str2) || "tnet_request_send".equalsIgnoreCase(str2))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        a aVar = (a) this.a.get(hVar);
        if (aVar == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(str);
        arrayList.add(str2);
        return aVar.a(arrayList);
    }

    public final boolean a(String str, String str2, Boolean bool) {
        a aVar = (a) this.a.get(h.ALARM);
        if (aVar == null || !(aVar instanceof e)) {
            return false;
        }
        e eVar = (e) aVar;
        int i = this.b;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(str);
        arrayList.add(str2);
        return eVar.a(i, arrayList, bool.booleanValue());
    }
}
