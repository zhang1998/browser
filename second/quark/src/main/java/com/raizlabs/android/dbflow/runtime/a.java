package com.raizlabs.android.dbflow.runtime;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.d;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.e;

/* compiled from: ProGuard */
public final class a implements b {
    public final <T> void a(@NonNull T t, @NonNull com.raizlabs.android.dbflow.structure.a<T> aVar, @NonNull e eVar) {
        if (j.a()) {
            FlowManager.b().getContentResolver().notifyChange(d.a(aVar.i(), eVar, aVar.e(t).g), null, true);
        }
    }

    public final <T> void a(@NonNull Class<T> cls, @NonNull e eVar) {
        if (j.a()) {
            FlowManager.b().getContentResolver().notifyChange(d.a((Class) cls, eVar, null), null, true);
        }
    }
}
