package com.alibaba.appmonitor.f;

import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.c;
import com.alibaba.appmonitor.model.b;
import com.alibaba.fastjson.e;
import com.alibaba.mtl.appmonitor.model.Dimension;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class j extends e {
    private b a;
    private Map<DimensionValueSet, c> b;

    public final synchronized void a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        Object obj = 1;
        synchronized (this) {
            c cVar;
            if (dimensionValueSet == null) {
                dimensionValueSet = (DimensionValueSet) com.alibaba.appmonitor.e.b.a().a(DimensionValueSet.class, new Object[0]);
            }
            if (this.b.containsKey(dimensionValueSet)) {
                cVar = (c) this.b.get(dimensionValueSet);
            } else {
                DimensionValueSet dimensionValueSet2 = (DimensionValueSet) com.alibaba.appmonitor.e.b.a().a(DimensionValueSet.class, new Object[0]);
                dimensionValueSet2.a(dimensionValueSet);
                cVar = new c(this);
                this.b.put(dimensionValueSet2, cVar);
            }
            if (this.a != null) {
                Object obj2;
                b bVar = this.a;
                int i;
                if (bVar.c != null) {
                    DimensionSet dimensionSet = bVar.c;
                    if (dimensionSet.a != null) {
                        if (dimensionValueSet != null) {
                            for (Dimension a : dimensionSet.a) {
                                if (!dimensionValueSet.a.containsKey(a.a())) {
                                    obj2 = null;
                                    break;
                                }
                            }
                        }
                        obj2 = null;
                    }
                    i = 1;
                } else {
                    i = 1;
                }
                if (bVar.d == null) {
                    obj = obj2;
                } else if (obj2 == null || !bVar.d.a(measureValueSet)) {
                    obj = null;
                }
            } else {
                obj = null;
            }
            if (obj != null) {
                cVar.a++;
                cVar.a(measureValueSet);
            } else {
                cVar.b++;
                if (this.a != null && this.a.e()) {
                    cVar.a(measureValueSet);
                }
            }
            super.c(null);
        }
    }

    public final synchronized e b() {
        e b;
        b = super.b();
        if (this.a != null) {
            b.a("isCommitDetail", String.valueOf(this.a.e()));
        }
        com.alibaba.fastjson.b bVar = (com.alibaba.fastjson.b) com.alibaba.appmonitor.e.b.a().a(c.class, new Object[0]);
        if (this.b != null) {
            for (Entry entry : this.b.entrySet()) {
                e eVar = (e) com.alibaba.appmonitor.e.b.a().a(com.alibaba.appmonitor.e.e.class, new Object[0]);
                DimensionValueSet dimensionValueSet = (DimensionValueSet) entry.getKey();
                c cVar = (c) entry.getValue();
                Integer valueOf = Integer.valueOf(cVar.a);
                Integer valueOf2 = Integer.valueOf(cVar.b);
                eVar.a("count", valueOf);
                eVar.a("noise", valueOf2);
                eVar.a("dimensions", dimensionValueSet != null ? new HashMap(dimensionValueSet.a) : null);
                eVar.a("measures", cVar.a());
                bVar.add(eVar);
            }
        }
        b.a("values", bVar);
        return b;
    }

    public final synchronized void a() {
        super.a();
        this.a = null;
        for (a a : this.b.keySet()) {
            com.alibaba.appmonitor.e.b.a().a(a);
        }
        this.b.clear();
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.a = com.alibaba.appmonitor.model.a.a().a(this.e, this.f);
    }
}
