package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.d.d;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.config.t;
import com.raizlabs.android.dbflow.structure.database.a;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.database.c;
import com.raizlabs.android.dbflow.structure.database.h;
import com.raizlabs.android.dbflow.structure.e;

/* compiled from: ProGuard */
public abstract class k<TModel> implements l, d {
    public final Class<TModel> a;

    @NonNull
    public abstract e j();

    protected k(Class<TModel> cls) {
        this.a = cls;
    }

    @NonNull
    public final Class<TModel> g() {
        return this.a;
    }

    public long b(@NonNull b bVar) {
        try {
            String a = a();
            t.a(s.a, "Executing query: " + a);
            return com.raizlabs.android.dbflow.a.d.a(bVar, a);
        } catch (Throwable e) {
            t.a(s.d, e);
            return 0;
        }
    }

    public long h() {
        return b(FlowManager.d(this.a));
    }

    public final boolean c(@NonNull b bVar) {
        return b(bVar) > 0;
    }

    public c i() {
        d(FlowManager.d(this.a));
        return null;
    }

    public c d(@NonNull b bVar) {
        String a;
        if (j().equals(e.INSERT)) {
            a = a();
            t.a(s.a, "Compiling Query Into Statement: " + a);
            a hVar = new h(bVar.b(a), this);
            hVar.d();
            hVar.b();
        } else {
            a = a();
            t.a(s.a, "Executing query: " + a);
            bVar.a(a);
        }
        return null;
    }

    public String toString() {
        return a();
    }
}
