package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.a.b.n;
import com.raizlabs.android.dbflow.a.d.e;
import com.raizlabs.android.dbflow.structure.database.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class p<TResult> implements a {
    final e<TResult> a;
    final i<TResult> b;
    final j<TResult> c;
    final k<TResult> d;
    final boolean e;

    public p(o<TResult> oVar) {
        this.a = oVar.a;
        this.b = oVar.b;
        this.c = oVar.c;
        this.d = oVar.d;
        this.e = oVar.e;
    }

    public final void a(b bVar) {
        n b = this.a.b();
        if (!(this.b == null || this.e)) {
            g.a().post(new l(this, b));
        }
        if (this.c != null) {
            List b2;
            if (b.b != null) {
                b2 = b.a.j().b(b.b);
            } else {
                b2 = new ArrayList();
            }
            b.close();
            if (this.e) {
                this.c.a(b2);
            } else {
                g.a().post(new m(this, b2));
            }
        }
        if (this.d != null) {
            Object a = b.b != null ? b.a.k().a(b.b) : null;
            b.close();
            if (this.e) {
                this.d.a(a);
            } else {
                g.a().post(new n(this, a));
            }
        }
    }
}
