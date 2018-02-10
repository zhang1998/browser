package com.raizlabs.android.dbflow.config;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class e {
    final Set<Class<? extends f>> a;
    public final Map<Class<?>, k> b;
    final Context c;
    final boolean d;

    public e(d dVar) {
        this.a = Collections.unmodifiableSet(dVar.b);
        this.b = dVar.c;
        this.c = dVar.a;
        this.d = dVar.d;
    }
}
