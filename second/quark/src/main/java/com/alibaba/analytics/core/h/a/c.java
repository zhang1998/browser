package com.alibaba.analytics.core.h.a;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.core.db.g;

@TableName("timestamp_config")
/* compiled from: ProGuard */
public class c extends g {
    @Column("namespace")
    public String a;
    @Column("timestamp")
    public String b;

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
