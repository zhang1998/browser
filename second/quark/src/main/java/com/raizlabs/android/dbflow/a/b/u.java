package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.d.e;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class u<TModel> extends j<TModel> implements e<TModel> {
    public g b;
    public final List<m> c = new ArrayList();
    public int d = -1;
    private final t<TModel> e;
    private final List<i> f = new ArrayList();
    private g g;
    private int h = -1;

    public u(@NonNull t<TModel> tVar, d... dVarArr) {
        super(tVar.g());
        this.e = tVar;
        this.b = g.j();
        this.g = g.j();
        this.b.a(dVarArr);
    }

    @NonNull
    public final u<TModel> a(@NonNull d dVar) {
        this.b.a("AND", dVar);
        return this;
    }

    @NonNull
    public final u<TModel> a(d... dVarArr) {
        this.b.a(dVarArr);
        return this;
    }

    @NonNull
    public final u<TModel> a(@NonNull b bVar) {
        this.c.add(new m(bVar.b(), (byte) 0));
        return this;
    }

    @NonNull
    public final u<TModel> a(@NonNull List<m> list) {
        this.c.addAll(list);
        return this;
    }

    @NonNull
    public final com.raizlabs.android.dbflow.structure.e j() {
        return this.e.j();
    }

    public final String a() {
        com.raizlabs.android.dbflow.a.e a = new com.raizlabs.android.dbflow.a.e().b(this.e.a().trim()).b().a("WHERE", this.b.a()).a("GROUP BY", com.raizlabs.android.dbflow.a.e.a((CharSequence) ",", this.f)).a("HAVING", this.g.a()).a("ORDER BY", com.raizlabs.android.dbflow.a.e.a((CharSequence) ",", this.c));
        if (this.d >= 0) {
            a.a("LIMIT", String.valueOf(this.d));
        }
        if (this.h >= 0) {
            a.a("OFFSET", String.valueOf(this.h));
        }
        return a.a();
    }

    public final c d(@NonNull com.raizlabs.android.dbflow.structure.database.b bVar) {
        if (this.e.k() instanceof o) {
            return bVar.c(a());
        }
        return super.d(bVar);
    }

    @NonNull
    public final List<TModel> c() {
        a("query");
        return super.c();
    }

    public final TModel d() {
        a("query");
        this.d = 1;
        return super.d();
    }

    private void a(String str) {
        if (!(this.e.k() instanceof o)) {
            throw new IllegalArgumentException("Please use " + str + "(). The beginning is not a ISelect");
        }
    }

    public final c i() {
        return d(FlowManager.b(this.a).a());
    }
}
