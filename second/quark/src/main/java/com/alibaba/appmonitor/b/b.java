package com.alibaba.appmonitor.b;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.g;

/* compiled from: ProGuard */
public class b extends g {
    @Column("module")
    public String c;
    @Column("monitor_point")
    public String d;
    @Column("commit_time")
    public long e;
    @Column("access")
    public String f;
    @Column("sub_access")
    public String g;

    protected b() {
    }

    public b(String str, String str2, String str3, String str4) {
        this.c = str;
        this.d = str2;
        this.e = System.currentTimeMillis() / 1000;
        this.f = str3;
        this.g = str4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TempEvent{");
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
