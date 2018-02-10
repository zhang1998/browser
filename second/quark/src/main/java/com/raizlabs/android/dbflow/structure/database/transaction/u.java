package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.b;
import java.util.List;

/* compiled from: ProGuard */
public final class u<TModel> implements a {
    final r<TModel> a;
    final List<TModel> b;
    final q<TModel> c;
    final boolean d;

    public u(t<TModel> tVar) {
        this.a = tVar.b;
        this.b = tVar.c;
        this.c = tVar.a;
        this.d = tVar.d;
    }

    public final void a(b bVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                Object obj = this.b.get(i);
                this.c.a(obj);
                if (!(this.a == null || this.d)) {
                    g.a().post(new s(this, i, size, obj));
                }
            }
        }
    }
}
