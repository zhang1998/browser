package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.config.FlowManager;

/* compiled from: ProGuard */
public class f implements g {
    @ColumnIgnore
    private transient a a;

    public final boolean a() {
        return c().a(this);
    }

    public final boolean b() {
        return c().c(this);
    }

    public final a c() {
        if (this.a == null) {
            this.a = FlowManager.g(getClass());
        }
        return this.a;
    }
}
