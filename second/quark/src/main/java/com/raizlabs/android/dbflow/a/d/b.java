package com.raizlabs.android.dbflow.a.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.c;

/* compiled from: ProGuard */
public abstract class b<TModel, TReturn> {
    private final Class<TModel> a;
    private c b;
    private com.raizlabs.android.dbflow.structure.b<TModel> c;

    @Nullable
    public abstract TReturn a(@NonNull com.raizlabs.android.dbflow.structure.database.c cVar, @Nullable TReturn tReturn);

    public b(@NonNull Class<TModel> cls) {
        this.a = cls;
    }

    @Nullable
    public TReturn a(@NonNull com.raizlabs.android.dbflow.structure.database.b bVar, @NonNull String str) {
        return a(bVar, str, null);
    }

    @Nullable
    public TReturn a(@NonNull com.raizlabs.android.dbflow.structure.database.b bVar, @NonNull String str, @Nullable TReturn tReturn) {
        return b(bVar.c(str), tReturn);
    }

    @Nullable
    public TReturn a(@Nullable com.raizlabs.android.dbflow.structure.database.c cVar) {
        return b(cVar, null);
    }

    @Nullable
    public TReturn b(@Nullable com.raizlabs.android.dbflow.structure.database.c cVar, @Nullable TReturn tReturn) {
        if (cVar != null) {
            try {
                tReturn = a(cVar, (Object) tReturn);
            } finally {
                cVar.close();
            }
        }
        return tReturn;
    }

    @NonNull
    public final com.raizlabs.android.dbflow.structure.b<TModel> a() {
        if (this.c == null) {
            this.c = FlowManager.f(this.a);
        }
        return this.c;
    }

    @Nullable
    public TReturn a(@NonNull String str) {
        if (this.b == null) {
            this.b = FlowManager.b(this.a);
        }
        return a(this.b.a(), str);
    }
}
