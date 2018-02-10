package android.mini.support.v7.widget;

import android.mini.support.annotation.NonNull;
import android.mini.support.v4.a.a;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class r extends bj {
    ArrayList<ArrayList<bf>> a = new ArrayList();
    ArrayList<ArrayList<p>> b = new ArrayList();
    ArrayList<ArrayList<o>> c = new ArrayList();
    ArrayList<bf> d = new ArrayList();
    ArrayList<bf> e = new ArrayList();
    ArrayList<bf> f = new ArrayList();
    ArrayList<bf> g = new ArrayList();
    private ArrayList<bf> n = new ArrayList();
    private ArrayList<bf> o = new ArrayList();
    private ArrayList<p> p = new ArrayList();
    private ArrayList<o> q = new ArrayList();

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
            Runnable gVar;
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                bf bfVar = (bf) it.next();
                cs n = ViewCompat.n(bfVar.a);
                this.f.add(bfVar);
                n.a(this.j).a(0.0f).a(new j(this, bfVar, n)).b();
            }
            this.n.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.p);
                this.b.add(arrayList);
                this.p.clear();
                gVar = new g(this, arrayList);
                if (i4 != 0) {
                    ViewCompat.a(((p) arrayList.get(0)).a.a, gVar, this.j);
                } else {
                    gVar.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.q);
                this.c.add(arrayList);
                this.q.clear();
                gVar = new h(this, arrayList);
                if (i4 != 0) {
                    ViewCompat.a(((o) arrayList.get(0)).a.a, gVar, this.j);
                } else {
                    gVar.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.o);
                this.a.add(arrayList2);
                this.o.clear();
                Runnable iVar = new i(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    iVar.run();
                    return;
                }
                long j;
                long j2;
                long j3;
                if (i4 != 0) {
                    j = this.j;
                } else {
                    j = 0;
                }
                if (i != 0) {
                    j2 = this.k;
                } else {
                    j2 = 0;
                }
                if (i2 != 0) {
                    j3 = this.l;
                } else {
                    j3 = 0;
                }
                ViewCompat.a(((bf) arrayList2.get(0)).a, iVar, j + Math.max(j2, j3));
            }
        }
    }

    public final boolean a(bf bfVar) {
        h(bfVar);
        this.n.add(bfVar);
        return true;
    }

    public final boolean b(bf bfVar) {
        h(bfVar);
        ViewCompat.c(bfVar.a, 0.0f);
        this.o.add(bfVar);
        return true;
    }

    public final boolean a(bf bfVar, int i, int i2, int i3, int i4) {
        View view = bfVar.a;
        int i5 = (int) (((float) i) + ViewCompat.i(bfVar.a));
        int j = (int) (((float) i2) + ViewCompat.j(bfVar.a));
        h(bfVar);
        int i6 = i3 - i5;
        int i7 = i4 - j;
        if (i6 == 0 && i7 == 0) {
            f(bfVar);
            return false;
        }
        if (i6 != 0) {
            ViewCompat.a(view, (float) (-i6));
        }
        if (i7 != 0) {
            ViewCompat.b(view, (float) (-i7));
        }
        this.p.add(new p(bfVar, i5, j, i3, i4));
        return true;
    }

    public final boolean a(bf bfVar, bf bfVar2, int i, int i2, int i3, int i4) {
        if (bfVar == bfVar2) {
            return a(bfVar, i, i2, i3, i4);
        }
        float i5 = ViewCompat.i(bfVar.a);
        float j = ViewCompat.j(bfVar.a);
        float f = ViewCompat.f(bfVar.a);
        h(bfVar);
        int i6 = (int) (((float) (i3 - i)) - i5);
        int i7 = (int) (((float) (i4 - i2)) - j);
        ViewCompat.a(bfVar.a, i5);
        ViewCompat.b(bfVar.a, j);
        ViewCompat.c(bfVar.a, f);
        if (bfVar2 != null) {
            h(bfVar2);
            ViewCompat.a(bfVar2.a, (float) (-i6));
            ViewCompat.b(bfVar2.a, (float) (-i7));
            ViewCompat.c(bfVar2.a, 0.0f);
        }
        this.q.add(new o(bfVar, bfVar2, i, i2, i3, i4));
        return true;
    }

    private void a(List<o> list, bf bfVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            o oVar = (o) list.get(size);
            if (a(oVar, bfVar) && oVar.a == null && oVar.b == null) {
                list.remove(oVar);
            }
        }
    }

    private void a(o oVar) {
        if (oVar.a != null) {
            a(oVar, oVar.a);
        }
        if (oVar.b != null) {
            a(oVar, oVar.b);
        }
    }

    private boolean a(o oVar, bf bfVar) {
        if (oVar.b == bfVar) {
            oVar.b = null;
        } else if (oVar.a != bfVar) {
            return false;
        } else {
            oVar.a = null;
        }
        ViewCompat.c(bfVar.a, (float) IPictureView.DEFAULT_MIN_SCALE);
        ViewCompat.a(bfVar.a, 0.0f);
        ViewCompat.b(bfVar.a, 0.0f);
        f(bfVar);
        return true;
    }

    public final void c(bf bfVar) {
        int size;
        View view = bfVar.a;
        ViewCompat.n(view).a();
        for (size = this.p.size() - 1; size >= 0; size--) {
            if (((p) this.p.get(size)).a == bfVar) {
                ViewCompat.b(view, 0.0f);
                ViewCompat.a(view, 0.0f);
                f(bfVar);
                this.p.remove(size);
            }
        }
        a(this.q, bfVar);
        if (this.n.remove(bfVar)) {
            ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
            f(bfVar);
        }
        if (this.o.remove(bfVar)) {
            ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
            f(bfVar);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.c.get(size);
            a(list, bfVar);
            if (list.isEmpty()) {
                this.c.remove(size);
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.b.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((p) arrayList.get(size3)).a == bfVar) {
                    ViewCompat.b(view, 0.0f);
                    ViewCompat.a(view, 0.0f);
                    f(bfVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.a.get(size);
            if (arrayList.remove(bfVar)) {
                ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
                f(bfVar);
                if (arrayList.isEmpty()) {
                    this.a.remove(size);
                }
            }
        }
        this.f.remove(bfVar);
        this.d.remove(bfVar);
        this.g.remove(bfVar);
        this.e.remove(bfVar);
        c();
    }

    private void h(bf bfVar) {
        a.a(bfVar.a);
        c(bfVar);
    }

    public final boolean b() {
        return (this.o.isEmpty() && this.q.isEmpty() && this.p.isEmpty() && this.n.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    final void c() {
        if (!b()) {
            e();
        }
    }

    public final void d() {
        int size;
        for (size = this.p.size() - 1; size >= 0; size--) {
            p pVar = (p) this.p.get(size);
            View view = pVar.a.a;
            ViewCompat.b(view, 0.0f);
            ViewCompat.a(view, 0.0f);
            f(pVar.a);
            this.p.remove(size);
        }
        for (size = this.n.size() - 1; size >= 0; size--) {
            f((bf) this.n.get(size));
            this.n.remove(size);
        }
        for (size = this.o.size() - 1; size >= 0; size--) {
            bf bfVar = (bf) this.o.get(size);
            ViewCompat.c(bfVar.a, (float) IPictureView.DEFAULT_MIN_SCALE);
            f(bfVar);
            this.o.remove(size);
        }
        for (size = this.q.size() - 1; size >= 0; size--) {
            a((o) this.q.get(size));
        }
        this.q.clear();
        if (b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.b.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.b.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    p pVar2 = (p) arrayList.get(size3);
                    View view2 = pVar2.a.a;
                    ViewCompat.b(view2, 0.0f);
                    ViewCompat.a(view2, 0.0f);
                    f(pVar2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                }
            }
            for (size2 = this.a.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.a.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    bf bfVar2 = (bf) arrayList.get(size3);
                    ViewCompat.c(bfVar2.a, (float) IPictureView.DEFAULT_MIN_SCALE);
                    f(bfVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.a.remove(arrayList);
                    }
                }
            }
            for (size2 = this.c.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.c.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((o) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.c.remove(arrayList);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            e();
        }
    }

    private static void a(List<bf> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.n(((bf) list.get(size)).a).a();
        }
    }

    public final boolean a(@NonNull bf bfVar, @NonNull List<Object> list) {
        return !list.isEmpty() || super.a(bfVar, list);
    }
}
