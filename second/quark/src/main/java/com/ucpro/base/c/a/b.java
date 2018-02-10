package com.ucpro.base.c.a;

import android.content.Context;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.j;
import com.ucpro.base.c.b.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class b implements c {
    private final Context a;
    private final m b;
    private final j c;
    private ArrayList<WeakReference<a>> d = new ArrayList();
    private ArrayList<d> e = new ArrayList();

    public b(Context context, m mVar) {
        this.a = context;
        this.b = mVar;
        this.c = new j(this.b);
    }

    public final void a(a aVar) {
        this.d.add(new WeakReference(aVar));
    }

    private void d() {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            a aVar = (a) ((WeakReference) this.d.get(size)).get();
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private void e() {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            ((WeakReference) this.d.get(size)).get();
        }
    }

    public final int a() {
        return this.c.a();
    }

    public final int b() {
        return this.c.b();
    }

    public final boolean b(g gVar) {
        boolean b = this.c.b(gVar);
        int a = this.c.a() - 1;
        d();
        e();
        a(a, gVar, gVar.j());
        return b;
    }

    public final boolean a(int i) {
        int size;
        g b = this.c.b(i);
        boolean a = this.c.a(i);
        for (size = this.d.size() - 1; size >= 0; size--) {
            a aVar = (a) ((WeakReference) this.d.get(size)).get();
            if (aVar != null) {
                aVar.a(b);
            }
        }
        for (size = this.e.size() - 1; size >= 0; size--) {
            if (((d) this.e.get(size)).a == i) {
                this.e.remove(size);
                break;
            }
        }
        for (size = this.e.size() - 1; size >= 0; size--) {
            d dVar = (d) this.e.get(size);
            j jVar = this.c;
            dVar.a = jVar.a.c(dVar.b);
        }
        return a;
    }

    public final void b(int i) {
        this.c.c(i);
        this.c.b(i);
        e();
        a(i, null, false);
    }

    public final ArrayList<Integer> c() {
        ArrayList<Integer> arrayList = new ArrayList();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((d) it.next()).a));
        }
        return arrayList;
    }

    private void a(int i, g gVar, boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (((d) this.e.get(size)).a == i) {
                this.e.add((d) this.e.remove(size));
                return;
            }
        }
        if (gVar != null) {
            d dVar = new d(this);
            dVar.a = i;
            dVar.b = gVar;
            if (!z || this.e.size() <= 0) {
                this.e.add(dVar);
                return;
            }
            this.e.add(this.e.size() - 1, dVar);
        }
    }

    public final boolean a(g gVar) {
        boolean a = this.c.a(gVar);
        int a2 = this.c.a() - 1;
        d();
        a(a2, gVar, gVar.j());
        return a;
    }
}
