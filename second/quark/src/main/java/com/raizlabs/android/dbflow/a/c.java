package com.raizlabs.android.dbflow.a;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.b;
import com.raizlabs.android.dbflow.structure.database.transaction.g;

/* compiled from: ProGuard */
public class c<TAsync> {
    private final Class<?> a;
    com.raizlabs.android.dbflow.structure.database.transaction.c c;
    public b d;
    public g e;
    public final com.raizlabs.android.dbflow.config.c f;
    public final b g = new a(this);
    public final com.raizlabs.android.dbflow.structure.database.transaction.c h = new b(this);

    public c(@NonNull Class<?> cls) {
        this.a = cls;
        this.f = FlowManager.b(cls);
    }
}
