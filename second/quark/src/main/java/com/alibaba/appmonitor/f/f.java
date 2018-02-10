package com.alibaba.appmonitor.f;

import com.alibaba.analytics.a.af;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.model.b;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class f extends e {
    private static final Long c = Long.valueOf(300000);
    MeasureValueSet a;
    public DimensionValueSet b;
    private b d;
    private Map<String, MeasureValue> k;
    private Long l;

    public final boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        List list = this.d.d().a;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Measure measure = (Measure) list.get(i);
                if (measure != null) {
                    double doubleValue = measure.b() != null ? measure.b().doubleValue() : (double) c.longValue();
                    MeasureValue measureValue = (MeasureValue) this.k.get(measure.a);
                    if (!(measureValue == null || measureValue.a || ((double) currentTimeMillis) - measureValue.c <= doubleValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.k.isEmpty()) {
            this.l = Long.valueOf(currentTimeMillis);
        }
        this.k.put(str, (MeasureValue) com.alibaba.appmonitor.e.b.a().a(MeasureValue.class, Double.valueOf((double) currentTimeMillis), Double.valueOf((double) (currentTimeMillis - this.l.longValue()))));
        super.c(null);
    }

    public final boolean b(String str) {
        MeasureValue measureValue = (MeasureValue) this.k.get(str);
        if (measureValue != null) {
            af.a("DurationEvent", "statEvent consumeTime. module:", this.e, " monitorPoint:", this.f, " measureName:", str, " time:", Double.valueOf(((double) System.currentTimeMillis()) - measureValue.c));
            measureValue.c = ((double) r4) - measureValue.c;
            measureValue.a = true;
            this.a.a(str, measureValue);
            if (this.d.d().a(this.a)) {
                return true;
            }
        }
        super.c(null);
        return false;
    }

    public final void a() {
        super.a();
        this.d = null;
        this.l = null;
        for (a a : this.k.values()) {
            com.alibaba.appmonitor.e.b.a().a(a);
        }
        this.k.clear();
        if (this.a != null) {
            com.alibaba.appmonitor.e.b.a().a(this.a);
            this.a = null;
        }
        if (this.b != null) {
            com.alibaba.appmonitor.e.b.a().a(this.b);
            this.b = null;
        }
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        if (this.k == null) {
            this.k = new HashMap();
        }
        this.d = com.alibaba.appmonitor.model.a.a().a(this.e, this.f);
        if (this.d.c() != null) {
            this.b = (DimensionValueSet) com.alibaba.appmonitor.e.b.a().a(DimensionValueSet.class, new Object[0]);
            this.d.c().a(this.b);
        }
        this.a = (MeasureValueSet) com.alibaba.appmonitor.e.b.a().a(MeasureValueSet.class, new Object[0]);
    }
}
