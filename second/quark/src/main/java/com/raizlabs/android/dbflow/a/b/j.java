package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.d.a;
import com.raizlabs.android.dbflow.a.d.c;
import com.raizlabs.android.dbflow.a.d.e;
import com.raizlabs.android.dbflow.a.f;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.config.t;
import com.raizlabs.android.dbflow.runtime.n;
import com.raizlabs.android.dbflow.structure.b;
import java.util.List;

/* compiled from: ProGuard */
public abstract class j<TModel> extends k<TModel> implements e<TModel>, f {
    private b<TModel> b;
    private boolean c = true;

    protected j(Class<TModel> cls) {
        super(cls);
    }

    private b<TModel> l() {
        if (this.b == null) {
            this.b = FlowManager.f(this.a);
        }
        return this.b;
    }

    @NonNull
    public final n<TModel> b() {
        return new n(l().i(), i());
    }

    @NonNull
    public List<TModel> c() {
        c j;
        String a = a();
        t.a(s.a, "Executing query: " + a);
        if (this.c) {
            j = l().j();
        } else {
            j = new c(l().i());
        }
        return j.b(a);
    }

    @Nullable
    public TModel d() {
        a k;
        String a = a();
        t.a(s.a, "Executing query: " + a);
        if (this.c) {
            k = l().k();
        } else {
            k = new a(l().i());
        }
        return k.a(a);
    }

    public long a(@NonNull com.raizlabs.android.dbflow.structure.database.b bVar) {
        long a = bVar.b(a()).a();
        if (a > 0) {
            n.a().a(this.a, j());
        }
        return a;
    }

    @NonNull
    public final com.raizlabs.android.dbflow.a.d.f<TModel> f() {
        return new com.raizlabs.android.dbflow.a.d.f(this);
    }

    public final long e() {
        return a(FlowManager.d(this.a));
    }
}
