package com.ucpro.feature.g.e.a;

import android.database.Cursor;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.d;
import com.raizlabs.android.dbflow.a.b.k;
import com.raizlabs.android.dbflow.a.b.m;
import com.raizlabs.android.dbflow.a.b.s;
import com.raizlabs.android.dbflow.a.b.u;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.runtime.n;
import com.ucpro.feature.g.e.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class e {
    private ArrayList<Object> a;
    private Object b;

    private e() {
        this.a = new ArrayList();
        this.b = new Object();
    }

    public final void a(c cVar) {
        cVar.a();
        d();
    }

    private void d() {
        synchronized (this.b) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final long a(f fVar) {
        com.raizlabs.android.dbflow.structure.f cVar = new c();
        cVar.d = fVar.m;
        cVar.e = fVar.n;
        cVar.h = fVar.o;
        cVar.i = fVar.p;
        cVar.c = fVar.e;
        long b = cVar.c().b(cVar);
        if (b >= 0) {
            d();
        }
        return b;
    }

    public final void a() {
        k a = z.a(c.class);
        Cursor i = a.i();
        if (i != null) {
            i.close();
        } else {
            n.a().a(a.a, a.j());
        }
        d();
    }

    public static List<c> b() {
        s a = z.a(new b[0]).a(c.class);
        m a2 = m.a(a.m);
        a2.a = true;
        u a3 = a.a(new d[0]);
        a3.c.add(a2);
        return a3.c();
    }

    public static long c() {
        return (long) z.a(new b[0]).a(c.class).c().size();
    }

    public final void b(c cVar) {
        cVar.c().d(cVar);
        d();
    }
}
