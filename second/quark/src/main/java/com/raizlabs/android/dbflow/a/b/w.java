package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;

/* compiled from: ProGuard */
public final class w<TModel> extends s<TModel> implements t<TModel> {
    public g b;
    private f c;

    public w(@NonNull f fVar, @NonNull Class<TModel> cls) {
        super(cls);
        this.c = fVar;
        g j = g.j();
        this.b = j;
    }

    public final String a() {
        return new e(this.c.a()).b((Object) "SET ").b(this.b.a()).b().a();
    }

    @NonNull
    public final f k() {
        return this.c;
    }

    @NonNull
    public final com.raizlabs.android.dbflow.structure.e j() {
        return com.raizlabs.android.dbflow.structure.e.UPDATE;
    }
}
