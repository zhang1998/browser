package com.raizlabs.android.dbflow.structure;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.c;

/* compiled from: ProGuard */
public abstract class a<TModel> extends b<TModel> implements d<TModel> {
    public com.raizlabs.android.dbflow.structure.database.a a;
    public com.raizlabs.android.dbflow.a.a.a<TModel> b;
    private com.raizlabs.android.dbflow.structure.database.a f;
    private com.raizlabs.android.dbflow.structure.database.a g;

    public abstract String c();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public a(@NonNull c cVar) {
        super(cVar);
        if (this.e != null && this.e.b != null) {
            this.b = this.e.b;
            this.b.a = this;
        }
    }

    @NonNull
    public final com.raizlabs.android.dbflow.structure.database.a a() {
        if (this.f == null) {
            this.f = FlowManager.d(i()).b(d());
        }
        return this.f;
    }

    @NonNull
    public final com.raizlabs.android.dbflow.structure.database.a b() {
        if (this.g == null) {
            this.g = FlowManager.d(i()).b(f());
        }
        return this.g;
    }

    public final boolean a(@NonNull TModel tModel) {
        return l().a(tModel);
    }

    public final long b(@NonNull TModel tModel) {
        return l().c(tModel);
    }

    public final boolean c(@NonNull TModel tModel) {
        return l().b(tModel);
    }

    public final boolean d(@NonNull TModel tModel) {
        return l().d(tModel);
    }

    public void a(@NonNull TModel tModel, @NonNull Number number) {
    }

    private com.raizlabs.android.dbflow.a.a.a<TModel> l() {
        if (this.b == null) {
            this.b = new com.raizlabs.android.dbflow.a.a.a();
            this.b.a = this;
        }
        return this.b;
    }

    public String d() {
        return e();
    }
}
