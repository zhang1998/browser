package com.alibaba.appmonitor.a;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import java.util.ArrayList;

@TableName("ap_alarm")
/* compiled from: ProGuard */
public final class e extends a {
    @Ingore
    private static String f = "AlarmSampling";
    @Column("scp")
    protected int d = 0;
    @Column("fcp")
    protected int e = 0;

    final boolean a(int i, ArrayList<String> arrayList, boolean z) {
        while (arrayList.size() != 0) {
            String str = (String) arrayList.remove(0);
            if (!a(str)) {
                return a(i, z);
            }
            this = (e) c(str);
        }
        return a(i, z);
    }

    private boolean a(int i, boolean z) {
        if (z) {
            af.a("", "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.d));
            if (i < this.d) {
                return true;
            }
            return false;
        }
        af.a("", "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.e));
        if (i >= this.e) {
            return false;
        }
        return true;
    }

    public final void a(int i) {
        this.d = i;
        this.e = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AlarmConfig{");
        stringBuilder.append("module=").append(this.b);
        stringBuilder.append(", monitorPoint=").append(this.a);
        stringBuilder.append(", offline=").append(this.c);
        stringBuilder.append(", failSampling=").append(this.e);
        stringBuilder.append(", successSampling=").append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
