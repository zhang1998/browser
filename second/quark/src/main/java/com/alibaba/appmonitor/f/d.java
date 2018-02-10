package com.alibaba.appmonitor.f;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.d.e;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.c.a;
import com.alibaba.appmonitor.e.b;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.appmonitor.model.c;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public final class d {
    private static d c;
    public Map<String, f> a = new ConcurrentHashMap();
    private Map<UTDimensionValueSet, c> b = new ConcurrentHashMap();
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);
    private SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd");

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (c == null) {
                c = new d();
            }
            dVar = c;
        }
        return dVar;
    }

    private d() {
    }

    private UTDimensionValueSet a(int i, Long l, String str, String str2) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) b.a().a(UTDimensionValueSet.class, new Object[0]);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String logField = LogField.ACCESS.toString();
            Context context = com.alibaba.analytics.core.b.a().b;
            uTDimensionValueSet.a(logField, e.c());
            logField = LogField.ACCESS_SUBTYPE.toString();
            context = com.alibaba.analytics.core.b.a().b;
            uTDimensionValueSet.a(logField, e.d());
        } else {
            uTDimensionValueSet.a(LogField.ACCESS.toString(), str);
            uTDimensionValueSet.a(LogField.ACCESS_SUBTYPE.toString(), str2);
        }
        uTDimensionValueSet.a(LogField.USERID.toString(), com.alibaba.analytics.core.b.a().j);
        uTDimensionValueSet.a(LogField.USERNICK.toString(), com.alibaba.analytics.core.b.a().h);
        uTDimensionValueSet.a(LogField.EVENTID.toString(), String.valueOf(i));
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        uTDimensionValueSet.a("commitDay", this.g.format(new Date(l.longValue() * 1000)));
        return uTDimensionValueSet;
    }

    public final void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, null, null, null);
    }

    public final void a(int i, String str, String str2, String str3, Long l, String str4, String str5) {
        UTDimensionValueSet a = a(i, l, str4, str5);
        a aVar = (a) a(a, str, str2, str3, a.class);
        if (aVar != null) {
            aVar.a(l);
        }
        if (com.alibaba.analytics.core.b.a().r) {
            aVar = (a) b.a().a(a.class, Integer.valueOf(i), str, str2, str3);
            aVar.a(l);
            a.a(a, aVar);
        }
        a(h.a(i), this.d);
    }

    public final void a(int i, String str, String str2, String str3, String str4, String str5) {
        a(i, str, str2, str3, str4, str5, null, null, null);
    }

    public final void a(int i, String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7) {
        UTDimensionValueSet a = a(i, l, str6, str7);
        a aVar = (a) a(a, str, str2, str3, a.class);
        if (aVar != null) {
            aVar.b(l);
            aVar.a(str4, str5);
        }
        if (com.alibaba.analytics.core.b.a().r) {
            aVar = (a) b.a().a(a.class, Integer.valueOf(i), str, str2, str3);
            aVar.b(l);
            aVar.a(str4, str5);
            a.a(a, aVar);
        }
        a(h.a(i), this.d);
    }

    public final void a(int i, String str, String str2, String str3, double d) {
        a(i, str, str2, str3, d, null, null, null);
    }

    public final void a(int i, String str, String str2, String str3, double d, Long l, String str4, String str5) {
        UTDimensionValueSet a = a(i, l, str4, str5);
        i iVar = (i) a(a, str, str2, str3, i.class);
        if (iVar != null) {
            iVar.a(d, l);
        }
        if (com.alibaba.analytics.core.b.a().r) {
            iVar = (i) b.a().a(i.class, Integer.valueOf(i), str, str2, str3);
            iVar.a(d, l);
            a.a(a, iVar);
        }
        a(h.a(i), this.e);
    }

    public final void a(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet) {
        com.alibaba.appmonitor.model.b a = com.alibaba.appmonitor.model.a.a().a(str, str2);
        if (a != null) {
            if (a.c() != null) {
                a.c().a(dimensionValueSet);
            }
            if (a.d() != null) {
                MeasureSet d = a.d();
                if (!(d.a == null || measureValueSet == null)) {
                    for (Measure measure : d.a) {
                        if (measure.c() != null && measureValueSet.a(measure.a) == null) {
                            measureValueSet.a(measure.a, measure.c().doubleValue());
                        }
                    }
                }
            }
            UTDimensionValueSet a2 = a(i, null, null, null);
            j jVar = (j) a(a2, str, str2, null, j.class);
            if (jVar != null) {
                jVar.a(dimensionValueSet, measureValueSet);
            }
            if (com.alibaba.analytics.core.b.a().r) {
                jVar = (j) b.a().a(j.class, Integer.valueOf(i), str, str2);
                jVar.a(dimensionValueSet, measureValueSet);
                a.a(a2, jVar);
            }
            a(h.a(i), this.f);
            return;
        }
        af.d("metric is null,stat commit failed,please call AppMonitor.register() once before AppMonitor.STAT.commit()", new Object[0]);
    }

    public final void a(String str, Integer num, String str2, String str3, String str4) {
        com.alibaba.appmonitor.model.b a = com.alibaba.appmonitor.model.a.a().a(str2, str3);
        if (a == null || a.d() == null) {
            af.d("log discard!,metric is null,please call AppMonitor.register() once before Transaction.begin(measure)", new Object[0]);
            return;
        }
        for (Measure measure : a.d().a) {
            if (measure.a.equals(str4)) {
                break;
            }
        }
        Measure measure2 = null;
        if (measure2 != null) {
            f fVar;
            synchronized (f.class) {
                fVar = (f) this.a.get(str);
                if (fVar == null) {
                    fVar = (f) b.a().a(f.class, num, str2, str3);
                    this.a.put(str, fVar);
                }
            }
            fVar.a(str4);
        }
    }

    public final void a(String str, String str2, boolean z) {
        com.alibaba.appmonitor.e.a aVar = (f) this.a.get(str);
        if (aVar != null && aVar.b(str2)) {
            this.a.remove(str);
            if (z) {
                com.alibaba.appmonitor.model.b a = com.alibaba.appmonitor.model.a.a().a(aVar.e, aVar.f);
                if (a != null) {
                    a.e = null;
                }
            }
            a(aVar.h, aVar.e, aVar.f, aVar.a, aVar.b);
            b.a().a(aVar);
        }
    }

    public static String a(String str, String str2) {
        com.alibaba.appmonitor.model.b a = com.alibaba.appmonitor.model.a.a().a(str, str2);
        if (a != null) {
            return a.b();
        }
        return null;
    }

    private e a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends e> cls) {
        if (com.alibaba.analytics.a.b.b(str) && com.alibaba.analytics.a.b.b(str2)) {
            Integer b = uTDimensionValueSet.b();
            if (b != null) {
                c cVar;
                synchronized (this.b) {
                    cVar = (c) this.b.get(uTDimensionValueSet);
                    if (cVar == null) {
                        cVar = (c) b.a().a(c.class, new Object[0]);
                        this.b.put(uTDimensionValueSet, cVar);
                        af.a("EventRepo", "put in Map utDimensionValues", uTDimensionValueSet);
                    }
                }
                return cVar.a(b, str, str2, str3, cls);
            }
        }
        return null;
    }

    private void a(h hVar, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.incrementAndGet();
        af.b(hVar.toString(), " EVENT size:", String.valueOf(incrementAndGet));
        if (incrementAndGet >= hVar.f) {
            af.a("EventRepo", hVar.toString(), " event size exceed trigger count.");
            a(hVar.d);
        }
    }

    private Map<UTDimensionValueSet, List<e>> b(int i) {
        AtomicInteger atomicInteger;
        Map<UTDimensionValueSet, List<e>> hashMap = new HashMap();
        synchronized (this.b) {
            Iterator it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) entry.getKey();
                c cVar = (c) entry.getValue();
                if (uTDimensionValueSet.b().intValue() == i) {
                    if (cVar != null) {
                        hashMap.put(uTDimensionValueSet, new ArrayList(cVar.a.values()));
                    } else {
                        af.a("error", "utDimensionValues", uTDimensionValueSet);
                    }
                    it.remove();
                }
            }
        }
        if (65501 == i) {
            atomicInteger = this.d;
        } else if (65502 == i) {
            atomicInteger = this.e;
        } else if (65503 == i) {
            atomicInteger = this.f;
        } else {
            atomicInteger = null;
        }
        atomicInteger.set(0);
        return hashMap;
    }

    public final void a(int i) {
        Map b = b(i);
        i.a();
        i.a(new g(this, b));
    }
}
