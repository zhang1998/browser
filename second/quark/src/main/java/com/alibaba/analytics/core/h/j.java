package com.alibaba.analytics.core.h;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.core.db.g;

@TableName("onlineconfig")
/* compiled from: ProGuard */
public class j extends g {
    @Column("groupname")
    public String a = null;
    @Column("content")
    public String b = null;
    @Column("timestamp")
    long c = 0;
    @Ingore
    boolean d = false;
}
