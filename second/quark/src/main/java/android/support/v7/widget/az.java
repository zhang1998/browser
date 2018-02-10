package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class az {
    final ArrayList<bh> a = new ArrayList();
    ArrayList<bh> b = null;
    final ArrayList<bh> c = new ArrayList();
    final List<bh> d = Collections.unmodifiableList(this.a);
    int e = 2;
    b f;
    bi g;
    final /* synthetic */ RecyclerView h;

    public az(RecyclerView recyclerView) {
        this.h = recyclerView;
    }

    public final void a() {
        this.a.clear();
        b();
    }

    public final int a(int i) {
        if (i >= 0 && i < this.h.p.a()) {
            return !this.h.p.g ? i : this.h.c.b(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.h.p.a());
        }
    }

    public final View b(int i) {
        boolean z = true;
        if (i < 0 || i >= this.h.p.a()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.h.p.a());
        }
        boolean z2;
        bh bhVar;
        boolean z3;
        boolean z4;
        bh bhVar2;
        LayoutParams layoutParams;
        if (this.h.p.g) {
            bh d = d(i);
            bh bhVar3 = d;
            z2 = d != null;
            bhVar = bhVar3;
        } else {
            bhVar = null;
            z2 = false;
        }
        if (bhVar == null) {
            bhVar = e(i);
            if (bhVar != null) {
                if (bhVar.m()) {
                    z3 = this.h.p.g;
                } else if (bhVar.b < 0 || bhVar.b >= this.h.A.a()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + bhVar);
                } else if (this.h.p.g || this.h.A.a(bhVar.b) == bhVar.e) {
                    if (this.h.A.b) {
                        long j = bhVar.d;
                        this.h.A;
                        int i2 = bhVar.b;
                        if (j != -1) {
                            z3 = false;
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    z2 = true;
                } else {
                    bhVar.b(4);
                    if (bhVar.e()) {
                        this.h.removeDetachedView(bhVar.a, false);
                        bhVar.f();
                    } else if (bhVar.g()) {
                        bhVar.h();
                    }
                    a(bhVar);
                    bhVar = null;
                }
            }
        }
        if (bhVar == null) {
            i2 = this.h.c.b(i);
            if (i2 < 0 || i2 >= this.h.A.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + i2 + ").state:" + this.h.p.a());
            }
            View a;
            ArrayList arrayList;
            bd h;
            ViewGroup viewGroup;
            int a2 = this.h.A.a(i2);
            if (this.h.A.b) {
                this.h.A;
                bhVar = f(a2);
                if (bhVar != null) {
                    bhVar.b = i2;
                    z3 = true;
                    if (bhVar == null && this.g != null) {
                        a = this.g.a();
                        if (a != null) {
                            bhVar = this.h.a(a);
                            if (bhVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (bhVar.b()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (bhVar == null) {
                        arrayList = (ArrayList) c().a.get(a2);
                        if (arrayList != null || arrayList.isEmpty()) {
                            d = null;
                        } else {
                            int size = arrayList.size() - 1;
                            d = (bh) arrayList.get(size);
                            arrayList.remove(size);
                        }
                        if (d != null) {
                            d.q();
                            if (RecyclerView.t && (d.a instanceof ViewGroup)) {
                                a((ViewGroup) d.a, false);
                            }
                        }
                        bhVar = d;
                    }
                    if (bhVar != null) {
                        h = this.h.A;
                        viewGroup = this.h;
                        e.a("RV CreateView");
                        bhVar = h.a(viewGroup, a2);
                        bhVar.e = a2;
                        e.a();
                        z4 = z3;
                        bhVar2 = bhVar;
                    } else {
                        z4 = z3;
                        bhVar2 = bhVar;
                    }
                }
            }
            z3 = z2;
            a = this.g.a();
            if (a != null) {
                bhVar = this.h.a(a);
                if (bhVar == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                } else if (bhVar.b()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
            }
            if (bhVar == null) {
                arrayList = (ArrayList) c().a.get(a2);
                if (arrayList != null) {
                }
                d = null;
                if (d != null) {
                    d.q();
                    a((ViewGroup) d.a, false);
                }
                bhVar = d;
            }
            if (bhVar != null) {
                z4 = z3;
                bhVar2 = bhVar;
            } else {
                h = this.h.A;
                viewGroup = this.h;
                e.a("RV CreateView");
                bhVar = h.a(viewGroup, a2);
                bhVar.e = a2;
                e.a();
                z4 = z3;
                bhVar2 = bhVar;
            }
        } else {
            bhVar2 = bhVar;
            z4 = z2;
        }
        if (z4 && !this.h.p.g && bhVar2.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE)) {
            bhVar2.a(0, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            if (this.h.p.h) {
                ItemAnimator.e(bhVar2);
                ItemAnimator itemAnimator = this.h.n;
                v vVar = this.h.p;
                bhVar2.p();
                this.h.a(bhVar2, ItemAnimator.d(bhVar2));
            }
        }
        int i3;
        if (this.h.p.g && bhVar2.l()) {
            bhVar2.f = i;
            i3 = 0;
        } else if (!bhVar2.l() || bhVar2.k() || bhVar2.j()) {
            int b = this.h.c.b(i);
            bhVar2.k = this.h;
            bd h2 = this.h.A;
            bhVar2.b = b;
            if (h2.b) {
                bhVar2.d = -1;
            }
            bhVar2.a(1, 519);
            e.a("RV OnBindView");
            bhVar2.p();
            h2.a(bhVar2, b);
            bhVar2.o();
            e.a();
            View view = bhVar2.a;
            if (this.h.f()) {
                if (ViewCompat.e(view) == 0) {
                    ViewCompat.c(view, 1);
                }
                if (!ViewCompat.b(view)) {
                    ViewCompat.a(view, this.h.ai.b);
                }
            }
            if (this.h.p.g) {
                bhVar2.f = i;
            }
            z2 = true;
        } else {
            i3 = 0;
        }
        ViewGroup.LayoutParams layoutParams2 = bhVar2.a.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = (LayoutParams) this.h.generateDefaultLayoutParams();
            bhVar2.a.setLayoutParams(layoutParams);
        } else if (this.h.checkLayoutParams(layoutParams2)) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = (LayoutParams) this.h.generateLayoutParams(layoutParams2);
            bhVar2.a.setLayoutParams(layoutParams);
        }
        layoutParams.c = bhVar2;
        if (!z4 || r1 == 0) {
            z = false;
        }
        layoutParams.f = z;
        return bhVar2.a;
    }

    private void a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    public final void a(View view) {
        bh b = RecyclerView.b(view);
        if (b.n()) {
            this.h.removeDetachedView(view, false);
        }
        if (b.e()) {
            b.f();
        } else if (b.g()) {
            b.h();
        }
        a(b);
    }

    final void b() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            c(size);
        }
        this.c.clear();
    }

    final void c(int i) {
        c((bh) this.c.get(i));
        this.c.remove(i);
    }

    final void a(bh bhVar) {
        boolean z = true;
        int i = 0;
        if (bhVar.e() || bhVar.a.getParent() != null) {
            StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(bhVar.e()).append(" isAttached:");
            if (bhVar.a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (bhVar.n()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + bhVar);
        } else if (bhVar.b()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            boolean c = bh.c(bhVar);
            if (this.h.A != null && c) {
                this.h.A;
            }
            if (bhVar.r()) {
                boolean z2;
                if (!bhVar.a(14)) {
                    int size = this.c.size();
                    if (size == this.e && size > 0) {
                        c(0);
                    }
                    if (size < this.e) {
                        this.c.add(bhVar);
                        z2 = true;
                        if (z2) {
                            c(bhVar);
                            i = 1;
                            z = z2;
                        } else {
                            z = z2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    c(bhVar);
                    i = 1;
                    z = z2;
                }
            } else {
                z = false;
            }
            this.h.e.d(bhVar);
            if (!z && r1 == 0 && c) {
                bhVar.k = null;
            }
        }
    }

    private void c(bh bhVar) {
        ViewCompat.a(bhVar.a, null);
        if (this.h.B != null) {
            this.h.B;
        }
        if (this.h.A != null) {
            this.h.A;
        }
        if (this.h.p != null) {
            this.h.e.d(bhVar);
        }
        bhVar.k = null;
        b c = c();
        int i = bhVar.e;
        ArrayList arrayList = (ArrayList) c.a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            c.a.put(i, arrayList);
            if (c.b.indexOfKey(i) < 0) {
                c.b.put(i, 5);
            }
        }
        if (c.b.get(i) > arrayList.size()) {
            bhVar.q();
            arrayList.add(bhVar);
        }
    }

    final void b(View view) {
        bh b = RecyclerView.b(view);
        b.o = null;
        b.p = false;
        b.h();
        a(b);
    }

    final void c(View view) {
        bh b = RecyclerView.b(view);
        if (!b.a(12) && b.s() && !RecyclerView.a(this.h, b)) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            b.a(this, true);
            this.b.add(b);
        } else if (!b.j() || b.m() || this.h.A.b) {
            b.a(this, false);
            this.a.add(b);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    final void b(bh bhVar) {
        if (bhVar.p) {
            this.b.remove(bhVar);
        } else {
            this.a.remove(bhVar);
        }
        bhVar.o = null;
        bhVar.p = false;
        bhVar.h();
    }

    private bh d(int i) {
        int i2 = 0;
        if (this.b != null) {
            int size = this.b.size();
            if (size != 0) {
                bh bhVar;
                int i3 = 0;
                while (i3 < size) {
                    bhVar = (bh) this.b.get(i3);
                    if (bhVar.g() || bhVar.c() != i) {
                        i3++;
                    } else {
                        bhVar.b(32);
                        return bhVar;
                    }
                }
                if (this.h.A.b) {
                    int a = this.h.c.a(i, 0);
                    if (a > 0 && a < this.h.A.a()) {
                        this.h.A;
                        while (i2 < size) {
                            bhVar = (bh) this.b.get(i2);
                            if (bhVar.g() || bhVar.d != -1) {
                                i2++;
                            } else {
                                bhVar.b(32);
                                return bhVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    private bh e(int i) {
        View view;
        int i2 = 0;
        int size = this.a.size();
        int i3 = 0;
        while (i3 < size) {
            bh bhVar = (bh) this.a.get(i3);
            if (bhVar.g() || bhVar.c() != i || bhVar.j() || (!this.h.p.g && bhVar.m())) {
                i3++;
            } else {
                bhVar.b(32);
                return bhVar;
            }
        }
        n nVar = this.h.d;
        int size2 = nVar.c.size();
        for (i3 = 0; i3 < size2; i3++) {
            View view2 = (View) nVar.c.get(i3);
            bh b = nVar.a.b(view2);
            if (b.c() == i && !b.j() && !b.m()) {
                view = view2;
                break;
            }
        }
        view = null;
        if (view != null) {
            bhVar = RecyclerView.b(view);
            n nVar2 = this.h.d;
            i2 = nVar2.a.a(view);
            if (i2 < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            } else if (nVar2.b.c(i2)) {
                nVar2.b.b(i2);
                nVar2.b(view);
                int c = this.h.d.c(view);
                if (c == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + bhVar);
                }
                this.h.d.d(c);
                c(view);
                bhVar.b(8224);
                return bhVar;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        i3 = this.c.size();
        while (i2 < i3) {
            bhVar = (bh) this.c.get(i2);
            if (bhVar.j() || bhVar.c() != i) {
                i2++;
            } else {
                this.c.remove(i2);
                return bhVar;
            }
        }
        return null;
    }

    private bh f(int i) {
        int size;
        for (size = this.a.size() - 1; size >= 0; size--) {
            bh bhVar = (bh) this.a.get(size);
            if (bhVar.d == -1 && !bhVar.g()) {
                if (i == bhVar.e) {
                    bhVar.b(32);
                    if (!bhVar.m() || this.h.p.g) {
                        return bhVar;
                    }
                    bhVar.a(2, 14);
                    return bhVar;
                }
                this.a.remove(size);
                this.h.removeDetachedView(bhVar.a, false);
                b(bhVar.a);
            }
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            bhVar = (bh) this.c.get(size);
            if (bhVar.d == -1) {
                if (i == bhVar.e) {
                    this.c.remove(size);
                    return bhVar;
                }
                c(size);
            }
        }
        return null;
    }

    final b c() {
        if (this.f == null) {
            this.f = new b();
        }
        return this.f;
    }
}
