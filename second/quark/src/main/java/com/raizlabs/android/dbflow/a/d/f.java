package com.raizlabs.android.dbflow.a.d;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.c;
import com.raizlabs.android.dbflow.structure.database.transaction.a;
import com.raizlabs.android.dbflow.structure.database.transaction.g;
import com.raizlabs.android.dbflow.structure.database.transaction.i;
import com.raizlabs.android.dbflow.structure.database.transaction.j;
import com.raizlabs.android.dbflow.structure.database.transaction.k;
import com.raizlabs.android.dbflow.structure.database.transaction.o;
import com.raizlabs.android.dbflow.structure.database.transaction.p;

/* compiled from: ProGuard */
public final class f<TModel> extends c<f<TModel>> {
    public j<TModel> a;
    public k<TModel> b;
    private final e<TModel> i;
    private i<TModel> j;

    public f(@NonNull e<TModel> eVar) {
        super(eVar.g());
        this.i = eVar;
    }

    public final void a() {
        o oVar = new o(this.i);
        oVar.b = this.j;
        oVar.c = this.a;
        oVar.d = this.b;
        a pVar = new p(oVar);
        if (this.e != null) {
            g gVar = this.e;
            gVar.d.e.a.b(gVar);
        }
        com.raizlabs.android.dbflow.structure.database.transaction.f a = this.f.a(pVar);
        a.c = this.g;
        a.d = this.h;
        this.e = a.a();
        this.e.b();
    }
}
