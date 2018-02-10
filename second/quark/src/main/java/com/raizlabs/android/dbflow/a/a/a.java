package com.raizlabs.android.dbflow.a.a;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.n;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.e;

/* compiled from: ProGuard */
public final class a<TModel> {
    public com.raizlabs.android.dbflow.structure.a<TModel> a;

    public final synchronized boolean a(@NonNull TModel tModel) {
        return a(tModel, a(), this.a.a(), this.a.b());
    }

    private synchronized boolean a(@NonNull TModel tModel, @NonNull b bVar, @NonNull com.raizlabs.android.dbflow.structure.database.a aVar, @NonNull com.raizlabs.android.dbflow.structure.database.a aVar2) {
        boolean a;
        a = this.a.a((Object) tModel, bVar);
        if (a) {
            a = a(tModel, aVar2);
        }
        if (!a) {
            a = b(tModel, aVar) > -1;
        }
        if (a) {
            n.a().a(tModel, this.a, e.SAVE);
        }
        return a;
    }

    public final synchronized boolean b(@NonNull TModel tModel) {
        a();
        return a(tModel, this.a.b());
    }

    private synchronized boolean a(@NonNull TModel tModel, com.raizlabs.android.dbflow.structure.database.a aVar) {
        boolean z;
        this.a.b(aVar, tModel);
        z = aVar.a() != 0;
        if (z) {
            n.a().a(tModel, this.a, e.UPDATE);
        }
        return z;
    }

    public final synchronized long c(@NonNull TModel tModel) {
        com.raizlabs.android.dbflow.structure.database.a a;
        a = this.a.a();
        a();
        return b(tModel, a);
    }

    private synchronized long b(@NonNull TModel tModel, @NonNull com.raizlabs.android.dbflow.structure.database.a aVar) {
        long d;
        this.a.a(aVar, tModel);
        d = aVar.d();
        if (d > -1) {
            this.a.a(tModel, Long.valueOf(d));
            n.a().a(tModel, this.a, e.INSERT);
        }
        return d;
    }

    public final synchronized boolean d(@NonNull TModel tModel) {
        com.raizlabs.android.dbflow.structure.database.a aVar;
        com.raizlabs.android.dbflow.structure.a aVar2 = this.a;
        if (aVar2.a == null) {
            aVar2.a = FlowManager.d(aVar2.i()).b(aVar2.g());
        }
        aVar = aVar2.a;
        a();
        return c(tModel, aVar);
    }

    private synchronized boolean c(@NonNull TModel tModel, @NonNull com.raizlabs.android.dbflow.structure.database.a aVar) {
        boolean z = false;
        synchronized (this) {
            this.a.c(aVar, tModel);
            if (aVar.a() != 0) {
                z = true;
            }
            if (z) {
                n.a().a(tModel, this.a, e.DELETE);
            }
            this.a.a(tModel, Integer.valueOf(0));
        }
        return z;
    }

    @NonNull
    private b a() {
        return FlowManager.b(this.a.i()).a();
    }
}
