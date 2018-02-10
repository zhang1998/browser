package com.alibaba.appmonitor.b;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.fastjson.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

@TableName("stat_temp")
/* compiled from: ProGuard */
public class h extends b {
    @Column("dimension_values")
    String a;
    @Column("measure_values")
    String b;

    public h(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, String str3, String str4) {
        super(str, str2, str3, str4);
        this.a = a.a((Object) dimensionValueSet);
        this.b = a.a((Object) measureValueSet);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TempStat{");
        stringBuilder.append("module='").append(this.c).append('\'');
        stringBuilder.append("monitorPoint='").append(this.d).append('\'');
        stringBuilder.append("dimension_values='").append(this.a).append('\'');
        stringBuilder.append(", measure_values='").append(this.b).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
