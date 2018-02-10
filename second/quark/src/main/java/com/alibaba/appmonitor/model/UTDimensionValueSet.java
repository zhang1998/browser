package com.alibaba.appmonitor.model;

import com.alibaba.analytics.a.c;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.Set;

/* compiled from: ProGuard */
public class UTDimensionValueSet extends DimensionValueSet {
    private static final Set<LogField> b = new d();

    public final Integer b() {
        int a;
        if (this.a != null) {
            String str = (String) this.a.get(LogField.EVENTID.toString());
            if (str != null) {
                try {
                    a = c.a(str);
                } catch (NumberFormatException e) {
                }
                return Integer.valueOf(a);
            }
        }
        a = 0;
        return Integer.valueOf(a);
    }

    public final void a() {
        super.a();
    }

    public final void a(Object... objArr) {
        super.a(objArr);
    }
}
