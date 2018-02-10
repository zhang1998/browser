package com.alibaba.appmonitor.b;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;

@TableName("counter_temp")
/* compiled from: ProGuard */
public class a extends b {
    @Column("arg")
    public String a;
    @Column("value")
    public double b;

    public a(String str, String str2, String str3, double d, String str4, String str5) {
        super(str, str2, str4, str5);
        this.a = str3;
        this.b = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TempCounter{");
        stringBuilder.append("arg='").append(this.a).append('\'');
        stringBuilder.append(", value=").append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
