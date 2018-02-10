package com.alibaba.appmonitor.b;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.c.h;
import com.alibaba.analytics.core.c.j;
import com.alibaba.analytics.core.db.a;
import com.alibaba.analytics.core.db.g;
import com.alibaba.analytics.core.h.q;
import com.alibaba.appmonitor.d.e;
import com.alibaba.appmonitor.f.d;
import com.alibaba.appmonitor.model.b;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
public final class f implements j, q, e {
    private static f d = new f();
    public List<b> a = Collections.synchronizedList(new ArrayList());
    public ScheduledFuture b = null;
    public Runnable c = new e(this);
    private List<b> e = Collections.synchronizedList(new ArrayList());
    private List<b> f = Collections.synchronizedList(new ArrayList());
    private List<b> g = Collections.synchronizedList(new ArrayList());
    private long h = -2;
    private ScheduledFuture i = null;
    private Runnable j = new d(this);

    private f() {
        com.alibaba.appmonitor.d.b.a((e) this);
        h.a().b.add(this);
        com.alibaba.analytics.core.h.e.a().a("offline_duration", (q) this);
        i.a();
        i.a(new i());
        j();
    }

    public static f a() {
        return d;
    }

    public final void a(com.alibaba.appmonitor.f.h hVar, b bVar) {
        af.b();
        if (com.alibaba.appmonitor.f.h.ALARM == hVar) {
            this.e.add(bVar);
        } else if (com.alibaba.appmonitor.f.h.COUNTER == hVar) {
            this.f.add(bVar);
        } else if (com.alibaba.appmonitor.f.h.STAT == hVar) {
            this.g.add(bVar);
        }
        if (this.e.size() >= 100 || this.f.size() >= 100 || this.g.size() >= 100) {
            i.a();
            this.b = i.a(null, this.c, 0);
        } else if (this.b == null || (this.b != null && this.b.isDone())) {
            i.a();
            this.b = i.a(this.b, this.c, 30000);
        }
    }

    public static b a(String str, String str2) {
        List a = com.alibaba.analytics.core.b.a().n.a(b.class, "module=\"" + str + "\" and monitor_point=\"" + str2 + "\"", null, 1);
        if (a == null || a.size() <= 0) {
            return null;
        }
        return (b) a.get(0);
    }

    public final void b() {
        af.b();
        a(this.e);
        a(this.f);
        a(this.g);
        List list = this.a;
        if (list != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            synchronized (list) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = (b) list.get(i);
                    b a = a(bVar.a, bVar.b);
                    if (a != null) {
                        bVar.j = a.j;
                        arrayList.add(bVar);
                    } else {
                        arrayList2.add(bVar);
                    }
                }
                list.clear();
            }
            if (arrayList.size() > 0) {
                com.alibaba.analytics.core.b.a().n.c(arrayList);
            }
            if (arrayList2.size() > 0) {
                com.alibaba.analytics.core.b.a().n.a(arrayList2);
            }
        }
    }

    private static void a(List<?> list) {
        if (list != null && list.size() > 0) {
            List arrayList;
            synchronized (list) {
                arrayList = new ArrayList(list);
                list.clear();
            }
            com.alibaba.analytics.core.b.a().n.a(arrayList);
        }
    }

    public final void c() {
        af.b();
        i.a();
        this.b = i.a(null, this.c, 0);
    }

    public final void d() {
    }

    public final void e() {
        af.b();
        b();
    }

    public final void b(String str, String str2) {
        if ("offline_duration".equalsIgnoreCase(str)) {
            j();
        }
    }

    private void j() {
        long k = k();
        if (this.h != k) {
            this.h = k;
            i.a();
            this.i = i.b(this.i, this.j, this.h);
        }
    }

    private static long k() {
        int b = com.alibaba.analytics.core.h.e.a().b("offline_duration");
        if (b <= 0) {
            b = 21600000;
        } else if (b <= 3600) {
            b = 3600000;
        } else {
            b *= 1000;
        }
        return (long) b;
    }

    private static void a(Class<? extends g> cls) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -7);
        com.alibaba.analytics.core.b.a().n.a((Class) cls, "commit_time< " + (instance.getTimeInMillis() / 1000), null);
        if (com.alibaba.analytics.core.b.a().n.b((Class) cls) > 50000) {
            com.alibaba.analytics.core.b.a().n.a((Class) cls, " _id in ( select _id from " + com.alibaba.analytics.core.b.a().n.a((Class) cls) + "  ORDER BY  _id ASC LIMIT 10000 )", null);
        }
    }

    static /* synthetic */ void f() {
        af.b();
        com.alibaba.appmonitor.f.h[] values = com.alibaba.appmonitor.f.h.values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            com.alibaba.appmonitor.f.h hVar = values[i];
            while (true) {
                Class cls;
                long currentTimeMillis = (System.currentTimeMillis() / 1000) - (k() / 1000);
                a aVar = com.alibaba.analytics.core.b.a().n;
                if (com.alibaba.appmonitor.f.h.ALARM == hVar) {
                    cls = c.class;
                } else if (com.alibaba.appmonitor.f.h.COUNTER == hVar) {
                    cls = a.class;
                } else if (com.alibaba.appmonitor.f.h.STAT == hVar) {
                    cls = h.class;
                } else {
                    cls = b.class;
                }
                List a = aVar.a(cls, "commit_time<" + currentTimeMillis, "access,sub_access,module,monitor_point", SecExceptionCode.SEC_ERROR_DYN_STORE);
                af.a(null, "type", hVar, "events.size()", Integer.valueOf(a.size()));
                if (a.size() != 0) {
                    for (int i2 = 0; i2 < a.size(); i2++) {
                        switch (g.a[hVar.ordinal()]) {
                            case 1:
                                c cVar = (c) a.get(i2);
                                if (!SettingsConst.TRUE.equalsIgnoreCase(cVar.i)) {
                                    d.a().a(hVar.d, cVar.c, cVar.d, cVar.h, cVar.a, cVar.b, Long.valueOf(cVar.e), cVar.f, cVar.g);
                                    break;
                                } else {
                                    d.a().a(hVar.d, cVar.c, cVar.d, cVar.h, Long.valueOf(cVar.e), cVar.f, cVar.g);
                                    break;
                                }
                            case 2:
                                a aVar2 = (a) a.get(i2);
                                d.a().a(hVar.d, aVar2.c, aVar2.d, aVar2.a, aVar2.b, Long.valueOf(aVar2.e), aVar2.f, aVar2.g);
                                break;
                            case 3:
                                MeasureValueSet measureValueSet;
                                DimensionValueSet dimensionValueSet;
                                h hVar2 = (h) a.get(i2);
                                d a2 = d.a();
                                int i3 = hVar.d;
                                String str = hVar2.c;
                                String str2 = hVar2.d;
                                if (TextUtils.isEmpty(hVar2.b)) {
                                    measureValueSet = null;
                                } else {
                                    measureValueSet = (MeasureValueSet) com.alibaba.fastjson.a.a(hVar2.b, MeasureValueSet.class);
                                }
                                if (TextUtils.isEmpty(hVar2.a)) {
                                    dimensionValueSet = null;
                                } else {
                                    dimensionValueSet = (DimensionValueSet) com.alibaba.fastjson.a.a(hVar2.a, DimensionValueSet.class);
                                }
                                a2.a(i3, str, str2, measureValueSet, dimensionValueSet);
                                break;
                            default:
                                break;
                        }
                    }
                    com.alibaba.analytics.core.b.a().n.b(a);
                } else {
                    i++;
                }
            }
        }
    }
}
