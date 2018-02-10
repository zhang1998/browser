package com.alibaba.appmonitor.f;

import com.alibaba.appmonitor.e.b;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class c {
    int a = 0;
    int b = 0;
    final /* synthetic */ j c;
    private List<MeasureValueSet> d = new ArrayList();

    public c(j jVar) {
        this.c = jVar;
    }

    public final void a(MeasureValueSet measureValueSet) {
        if (measureValueSet == null) {
            return;
        }
        if (this.c.a != null && this.c.a.e()) {
            this.d.add(b(measureValueSet));
        } else if (this.d.isEmpty()) {
            r0 = b(measureValueSet);
            if (!(this.c.a == null || this.c.a.d() == null)) {
                r0.a(this.c.a.d().a);
            }
            this.d.add(r0);
        } else {
            r0 = (MeasureValueSet) this.d.get(0);
            for (String str : r0.a.keySet()) {
                ((MeasureValue) r0.a.get(str)).a(measureValueSet.a(str));
            }
        }
    }

    private MeasureValueSet b(MeasureValueSet measureValueSet) {
        MeasureValueSet measureValueSet2 = (MeasureValueSet) b.a().a(MeasureValueSet.class, new Object[0]);
        if (!(this.c.a == null || this.c.a.d() == null)) {
            List list = this.c.a.d().a;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Measure measure = (Measure) list.get(i);
                    if (measure != null) {
                        MeasureValue measureValue = (MeasureValue) b.a().a(MeasureValue.class, new Object[0]);
                        MeasureValue a = measureValueSet.a(measure.a);
                        if (a.b != null) {
                            measureValue.b = Double.valueOf(a.b.doubleValue());
                        }
                        measureValue.c = a.c;
                        measureValueSet2.a(measure.a, measureValue);
                    }
                }
            }
        }
        return measureValueSet2;
    }

    public final List<Map<String, Map<String, Object>>> a() {
        if (this.d == null || this.d.isEmpty()) {
            return null;
        }
        List<Map<String, Map<String, Object>>> arrayList = new ArrayList();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            MeasureValueSet measureValueSet = (MeasureValueSet) this.d.get(i);
            if (measureValueSet != null) {
                Map map = measureValueSet.a;
                if (!(map == null || map.isEmpty())) {
                    Map hashMap = new HashMap();
                    for (Entry entry : map.entrySet()) {
                        Map hashMap2 = new HashMap();
                        String str = (String) entry.getKey();
                        MeasureValue measureValue = (MeasureValue) entry.getValue();
                        hashMap2.put("value", Double.valueOf(measureValue.c));
                        if (measureValue.b != null) {
                            hashMap2.put("offset", measureValue.b);
                        }
                        map = measureValue.b();
                        if (map != null) {
                            hashMap2.put("buckets", map);
                        }
                        hashMap.put(str, hashMap2);
                    }
                    arrayList.add(hashMap);
                }
            }
        }
        return arrayList;
    }
}
