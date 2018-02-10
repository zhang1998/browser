package com.raizlabs.android.dbflow.runtime;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.a;
import com.raizlabs.android.dbflow.structure.e;

/* compiled from: ProGuard */
public final class n implements b {
    private static n a;

    @NonNull
    public static n a() {
        if (a == null) {
            a = new n();
        }
        return a;
    }

    public final <TModel> void a(@NonNull TModel tModel, @NonNull a<TModel> aVar, @NonNull e eVar) {
        FlowManager.h(aVar.i()).a(tModel, aVar, eVar);
    }

    public final <TModel> void a(@NonNull Class<TModel> cls, @NonNull e eVar) {
        FlowManager.h(cls).a(cls, eVar);
    }
}
