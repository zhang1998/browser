package com.raizlabs.android.dbflow.structure;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.d.a;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.e;
import com.raizlabs.android.dbflow.config.g;
import com.raizlabs.android.dbflow.config.k;
import com.raizlabs.android.dbflow.structure.database.b;

/* compiled from: ProGuard */
public abstract class c<TModel> {
    public a<TModel> c;
    public com.raizlabs.android.dbflow.a.d.c<TModel> d;
    g<TModel> e;

    public abstract void a(@NonNull com.raizlabs.android.dbflow.structure.database.c cVar, @NonNull TModel tModel);

    public abstract boolean a(@NonNull TModel tModel, @NonNull b bVar);

    public abstract com.raizlabs.android.dbflow.a.b.g e(@NonNull TModel tModel);

    @NonNull
    public abstract Class<TModel> i();

    public c(@NonNull com.raizlabs.android.dbflow.config.c cVar) {
        e a = FlowManager.a();
        k kVar = (k) a.b.get(cVar.e());
        if (kVar != null) {
            this.e = (g) kVar.e.get(i());
            if (this.e != null) {
                if (this.e.c != null) {
                    this.c = this.e.c;
                }
                if (this.e.d != null) {
                    this.d = this.e.d;
                }
            }
        }
    }

    @NonNull
    public final com.raizlabs.android.dbflow.a.d.c<TModel> j() {
        if (this.d == null) {
            this.d = new com.raizlabs.android.dbflow.a.d.c(i());
        }
        return this.d;
    }

    @NonNull
    public final a<TModel> k() {
        if (this.c == null) {
            this.c = new a(i());
        }
        return this.c;
    }
}
