package com.raizlabs.android.dbflow.runtime;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.c;
import com.raizlabs.android.dbflow.structure.database.transaction.h;

/* compiled from: ProGuard */
public abstract class e {
    public final h a;
    private i b;

    public e(@NonNull h hVar, @NonNull c cVar) {
        this.a = hVar;
        this.b = new i(cVar);
        this.a.a();
    }
}
