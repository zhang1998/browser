package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.a.d;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class ab extends g {
    ArrayList<ArrayList<bh>> g = new ArrayList();
    ArrayList<ArrayList<bm>> h = new ArrayList();
    ArrayList<ArrayList<al>> i = new ArrayList();
    ArrayList<bh> j = new ArrayList();
    ArrayList<bh> k = new ArrayList();
    ArrayList<bh> l = new ArrayList();
    ArrayList<bh> m = new ArrayList();
    private ArrayList<bh> n = new ArrayList();
    private ArrayList<bh> o = new ArrayList();
    private ArrayList<bm> p = new ArrayList();
    private ArrayList<al> q = new ArrayList();

    public final void a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.n.isEmpty() ? 1 : 0;
        if (this.p.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.q.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.o.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable sVar;
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                bh bhVar = (bh) it.next();
                bo q = ViewCompat.q(bhVar.a);
                this.l.add(bhVar);
                q.a(this.d).a(0.0f).a(new d(this, bhVar, q)).b();
            }
            this.n.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.p);
                this.h.add(arrayList);
                this.p.clear();
                sVar = new s(this, arrayList);
                if (i4 != 0) {
                    ViewCompat.a(((bm) arrayList.get(0)).a.a, sVar, this.d);
                } else {
                    sVar.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.q);
                this.i.add(arrayList);
                this.q.clear();
                sVar = new ae(this, arrayList);
                if (i4 != 0) {
                    ViewCompat.a(((al) arrayList.get(0)).a.a, sVar, this.d);
                } else {
                    sVar.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.o);
                this.g.add(arrayList2);
                this.o.clear();
                Runnable uVar = new u(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    uVar.run();
                    return;
                }
                long j;
                long j2;
                long j3;
                if (i4 != 0) {
                    j = this.d;
                } else {
                    j = 0;
                }
                if (i != 0) {
                    j2 = this.e;
                } else {
                    j2 = 0;
                }
                if (i2 != 0) {
                    j3 = this.f;
                } else {
                    j3 = 0;
                }
                ViewCompat.a(((bh) arrayList2.get(0)).a, uVar, j + Math.max(j2, j3));
            }
        }
    }

    public final boolean b(bh bhVar) {
        h(bhVar);
        this.n.add(bhVar);
        return true;
    }

    public final boolean c(bh bhVar) {
        h(bhVar);
        ViewCompat.c(bhVar.a, 0.0f);
        this.o.add(bhVar);
        return true;
    }

    public final boolean a(bh bhVar, int i, int i2, int i3, int i4) {
        View view = bhVar.a;
        int m = (int) (((float) i) + ViewCompat.m(bhVar.a));
        int n = (int) (((float) i2) + ViewCompat.n(bhVar.a));
        h(bhVar);
        int i5 = i3 - m;
        int i6 = i4 - n;
        if (i5 == 0 && i6 == 0) {
            g(bhVar);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.b(view, (float) (-i6));
        }
        this.p.add(new bm(bhVar, m, n, i3, i4));
        return true;
    }

    public final boolean a(bh bhVar, bh bhVar2, int i, int i2, int i3, int i4) {
        if (bhVar == bhVar2) {
            return a(bhVar, i, i2, i3, i4);
        }
        float m = ViewCompat.m(bhVar.a);
        float n = ViewCompat.n(bhVar.a);
        float f = ViewCompat.f(bhVar.a);
        h(bhVar);
        int i5 = (int) (((float) (i3 - i)) - m);
        int i6 = (int) (((float) (i4 - i2)) - n);
        ViewCompat.a(bhVar.a, m);
        ViewCompat.b(bhVar.a, n);
        ViewCompat.c(bhVar.a, f);
        if (bhVar2 != null) {
            h(bhVar2);
            ViewCompat.a(bhVar2.a, (float) (-i5));
            ViewCompat.b(bhVar2.a, (float) (-i6));
            ViewCompat.c(bhVar2.a, 0.0f);
        }
        this.q.add(new al(bhVar, bhVar2, i, i2, i3, i4));
        return true;
    }

    private void a(List<al> list, bh bhVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            al alVar = (al) list.get(size);
            if (a(alVar, bhVar) && alVar.a == null && alVar.b == null) {
                list.remove(alVar);
            }
        }
    }

    private void a(al alVar) {
        if (alVar.a != null) {
            a(alVar, alVar.a);
        }
        if (alVar.b != null) {
            a(alVar, alVar.b);
        }
    }

    private boolean a(al alVar, bh bhVar) {
        if (alVar.b == bhVar) {
            alVar.b = null;
        } else if (alVar.a != bhVar) {
            return false;
        } else {
            alVar.a = null;
        }
        ViewCompat.c(bhVar.a, (float) IPictureView.DEFAULT_MIN_SCALE);
        ViewCompat.a(bhVar.a, 0.0f);
        ViewCompat.b(bhVar.a, 0.0f);
        g(bhVar);
        return true;
    }

    public final void f(bh bhVar) {
        int size;
        View view = bhVar.a;
        ViewCompat.q(view).a();
        for (size = this.p.size() - 1; size >= 0; size--) {
            if (((bm) this.p.get(size)).a == bhVar) {
                ViewCompat.b(view, 0.0f);
                ViewCompat.a(view, 0.0f);
                g(bhVar);
                this.p.remove(size);
            }
        }
        a(this.q, bhVar);
        if (this.n.remove(bhVar)) {
            ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
            g(bhVar);
        }
        if (this.o.remove(bhVar)) {
            ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
            g(bhVar);
        }
        for (size = this.i.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.i.get(size);
            a(list, bhVar);
            if (list.isEmpty()) {
                this.i.remove(size);
            }
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.h.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((bm) arrayList.get(size3)).a == bhVar) {
                    ViewCompat.b(view, 0.0f);
                    ViewCompat.a(view, 0.0f);
                    g(bhVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.h.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.g.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.g.get(size);
            if (arrayList.remove(bhVar)) {
                ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
                g(bhVar);
                if (arrayList.isEmpty()) {
                    this.g.remove(size);
                }
            }
        }
        this.l.remove(bhVar);
        this.j.remove(bhVar);
        this.m.remove(bhVar);
        this.k.remove(bhVar);
        e();
    }

    private void h(bh bhVar) {
        d.a(bhVar.a);
        f(bhVar);
    }

    public final boolean c() {
        return (this.o.isEmpty() && this.q.isEmpty() && this.p.isEmpty() && this.n.isEmpty() && this.k.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.m.isEmpty() && this.h.isEmpty() && this.g.isEmpty() && this.i.isEmpty()) ? false : true;
    }

    final void e() {
        if (!c()) {
            d();
        }
    }

    public final void b() {
        int size;
        for (size = this.p.size() - 1; size >= 0; size--) {
            bm bmVar = (bm) this.p.get(size);
            View view = bmVar.a.a;
            ViewCompat.b(view, 0.0f);
            ViewCompat.a(view, 0.0f);
            g(bmVar.a);
            this.p.remove(size);
        }
        for (size = this.n.size() - 1; size >= 0; size--) {
            g((bh) this.n.get(size));
            this.n.remove(size);
        }
        for (size = this.o.size() - 1; size >= 0; size--) {
            bh bhVar = (bh) this.o.get(size);
            ViewCompat.c(bhVar.a, (float) IPictureView.DEFAULT_MIN_SCALE);
            g(bhVar);
            this.o.remove(size);
        }
        for (size = this.q.size() - 1; size >= 0; size--) {
            a((al) this.q.get(size));
        }
        this.q.clear();
        if (c()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    bm bmVar2 = (bm) arrayList.get(size3);
                    View view2 = bmVar2.a.a;
                    ViewCompat.b(view2, 0.0f);
                    ViewCompat.a(view2, 0.0f);
                    g(bmVar2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.h.remove(arrayList);
                    }
                }
            }
            for (size2 = this.g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    bh bhVar2 = (bh) arrayList.get(size3);
                    ViewCompat.c(bhVar2.a, (float) IPictureView.DEFAULT_MIN_SCALE);
                    g(bhVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.i.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.i.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((al) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.i.remove(arrayList);
                    }
                }
            }
            a(this.l);
            a(this.k);
            a(this.j);
            a(this.m);
            d();
        }
    }

    private static void a(List<bh> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.q(((bh) list.get(size)).a).a();
        }
    }

    public final boolean a(@NonNull bh bhVar, @NonNull List<Object> list) {
        return !list.isEmpty() || super.a(bhVar, list);
    }
}
