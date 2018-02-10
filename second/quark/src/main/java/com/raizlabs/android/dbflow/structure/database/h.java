package com.raizlabs.android.dbflow.structure.database;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.b.k;
import com.raizlabs.android.dbflow.runtime.n;

/* compiled from: ProGuard */
public final class h<TModel> extends i {
    @NonNull
    private final a a;
    private final k<TModel> b;

    public h(@NonNull a aVar, @NonNull k<TModel> kVar) {
        this.a = aVar;
        this.b = kVar;
    }

    public final long a() {
        long a = this.a.a();
        if (a > 0) {
            n.a().a(this.b.a, this.b.j());
        }
        return a;
    }

    public final void b() {
        this.a.b();
    }

    public final long c() {
        return this.a.c();
    }

    public final long d() {
        long d = this.a.d();
        if (d > 0) {
            n.a().a(this.b.a, this.b.j());
        }
        return d;
    }

    public final void a(int i, String str) {
        this.a.a(i, str);
    }

    public final void a(int i) {
        this.a.a(i);
    }

    public final void a(int i, long j) {
        this.a.a(i, j);
    }
}
