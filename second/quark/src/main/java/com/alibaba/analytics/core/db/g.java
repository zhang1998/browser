package com.alibaba.analytics.core.db;

import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class g {
    @Ingore
    private static boolean a = false;
    @Column("_id")
    public long j = -1;

    public final void f() {
        a aVar = b.a().n;
        if (this != null) {
            List arrayList = new ArrayList(1);
            arrayList.add(this);
            aVar.a(arrayList);
        }
    }
}
