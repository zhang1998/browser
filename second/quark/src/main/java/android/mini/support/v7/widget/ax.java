package android.mini.support.v7.widget;

import android.mini.support.v4.c.f;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v7.widget.RecyclerView.ItemAnimator;
import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.mini.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class ax {
    final ArrayList<bf> a = new ArrayList();
    ArrayList<bf> b = null;
    final ArrayList<bf> c = new ArrayList();
    final List<bf> d = Collections.unmodifiableList(this.a);
    int e = 2;
    aw f;
    bd g;
    final /* synthetic */ RecyclerView h;

    public ax(RecyclerView recyclerView) {
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
        bf bfVar;
        boolean z3;
        boolean z4;
        bf bfVar2;
        LayoutParams layoutParams;
        if (this.h.p.g) {
            bf d = d(i);
            bf bfVar3 = d;
            z2 = d != null;
            bfVar = bfVar3;
        } else {
            bfVar = null;
            z2 = false;
        }
        if (bfVar == null) {
            bfVar = e(i);
            if (bfVar != null) {
                if (bfVar.m()) {
                    z3 = this.h.p.g;
                } else if (bfVar.b < 0 || bfVar.b >= this.h.E.a()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + bfVar);
                } else {
                    z3 = (this.h.p.g || this.h.E.b(bfVar.b) == bfVar.e) ? !this.h.E.b || bfVar.d == this.h.E.c(bfVar.b) : false;
                }
                if (z3) {
                    z2 = true;
                } else {
                    bfVar.b(4);
                    if (bfVar.e()) {
                        this.h.removeDetachedView(bfVar.a, false);
                        bfVar.f();
                    } else if (bfVar.g()) {
                        bfVar.h();
                    }
                    a(bfVar);
                    bfVar = null;
                }
            }
        }
        if (bfVar == null) {
            int b = this.h.c.b(i);
            if (b < 0 || b >= this.h.E.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ").state:" + this.h.p.a());
            }
            View a;
            ArrayList arrayList;
            am h;
            int b2 = this.h.E.b(b);
            if (this.h.E.b) {
                bfVar = a(this.h.E.c(b), b2);
                if (bfVar != null) {
                    bfVar.b = b;
                    z3 = true;
                    if (bfVar == null && this.g != null) {
                        a = this.g.a();
                        if (a != null) {
                            bfVar = this.h.a(a);
                            if (bfVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (bfVar.b()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (bfVar == null) {
                        arrayList = (ArrayList) c().a.get(b2);
                        if (arrayList != null || arrayList.isEmpty()) {
                            d = null;
                        } else {
                            int size = arrayList.size() - 1;
                            d = (bf) arrayList.get(size);
                            arrayList.remove(size);
                        }
                        if (d != null) {
                            d.q();
                            if (RecyclerView.v && (d.a instanceof ViewGroup)) {
                                a((ViewGroup) d.a, false);
                            }
                        }
                        bfVar = d;
                    }
                    if (bfVar != null) {
                        h = this.h.E;
                        f.a("RV CreateView");
                        bfVar = h.a(b2);
                        bfVar.e = b2;
                        f.a();
                        z4 = z3;
                        bfVar2 = bfVar;
                    } else {
                        z4 = z3;
                        bfVar2 = bfVar;
                    }
                }
            }
            z3 = z2;
            a = this.g.a();
            if (a != null) {
                bfVar = this.h.a(a);
                if (bfVar == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                } else if (bfVar.b()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
            }
            if (bfVar == null) {
                arrayList = (ArrayList) c().a.get(b2);
                if (arrayList != null) {
                }
                d = null;
                if (d != null) {
                    d.q();
                    a((ViewGroup) d.a, false);
                }
                bfVar = d;
            }
            if (bfVar != null) {
                z4 = z3;
                bfVar2 = bfVar;
            } else {
                h = this.h.E;
                f.a("RV CreateView");
                bfVar = h.a(b2);
                bfVar.e = b2;
                f.a();
                z4 = z3;
                bfVar2 = bfVar;
            }
        } else {
            bfVar2 = bfVar;
            z4 = z2;
        }
        if (z4 && !this.h.p.g && bfVar2.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE)) {
            bfVar2.a(0, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            if (this.h.p.h) {
                ItemAnimator.e(bfVar2);
                ItemAnimator itemAnimator = this.h.o;
                State state = this.h.p;
                bfVar2.p();
                this.h.a(bfVar2, ItemAnimator.d(bfVar2));
            }
        }
        int i2;
        if (this.h.p.g && bfVar2.l()) {
            bfVar2.f = i;
            i2 = 0;
        } else if (!bfVar2.l() || bfVar2.k() || bfVar2.j()) {
            int b3 = this.h.c.b(i);
            bfVar2.k = this.h;
            am h2 = this.h.E;
            bfVar2.b = b3;
            if (h2.b) {
                bfVar2.d = h2.c(b3);
            }
            bfVar2.a(1, 519);
            f.a("RV OnBindView");
            bfVar2.p();
            h2.a(bfVar2, b3);
            bfVar2.o();
            f.a();
            View view = bfVar2.a;
            if (this.h.f()) {
                if (ViewCompat.e(view) == 0) {
                    ViewCompat.c(view, 1);
                }
                if (!ViewCompat.b(view)) {
                    ViewCompat.a(view, this.h.am.c);
                }
            }
            if (this.h.p.g) {
                bfVar2.f = i;
            }
            z2 = true;
        } else {
            i2 = 0;
        }
        ViewGroup.LayoutParams layoutParams2 = bfVar2.a.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = (LayoutParams) this.h.generateDefaultLayoutParams();
            bfVar2.a.setLayoutParams(layoutParams);
        } else if (this.h.checkLayoutParams(layoutParams2)) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = (LayoutParams) this.h.generateLayoutParams(layoutParams2);
            bfVar2.a.setLayoutParams(layoutParams);
        }
        layoutParams.c = bfVar2;
        if (!z4 || r1 == 0) {
            z = false;
        }
        layoutParams.f = z;
        return bfVar2.a;
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
        bf c = RecyclerView.c(view);
        if (c.n()) {
            this.h.removeDetachedView(view, false);
        }
        if (c.e()) {
            c.f();
        } else if (c.g()) {
            c.h();
        }
        a(c);
    }

    final void b() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            c(size);
        }
        this.c.clear();
    }

    final void c(int i) {
        c((bf) this.c.get(i));
        this.c.remove(i);
    }

    final void a(bf bfVar) {
        boolean z = true;
        int i = 0;
        if (bfVar.e() || bfVar.a.getParent() != null) {
            StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(bfVar.e()).append(" isAttached:");
            if (bfVar.a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (bfVar.n()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + bfVar);
        } else if (bfVar.b()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            int i2;
            boolean c = bf.c(bfVar);
            boolean z2 = this.h.E != null && c && this.h.E.b(bfVar);
            if (z2 || bfVar.r()) {
                if (!bfVar.a(14)) {
                    int size = this.c.size();
                    if (size >= this.e && size > 0) {
                        c(0);
                        size--;
                    }
                    if (size < this.e) {
                        this.c.add(bfVar);
                        z2 = true;
                        if (z2) {
                            c(bfVar);
                            i = 1;
                            i2 = z2;
                        } else {
                            z = z2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    c(bfVar);
                    i = 1;
                    i2 = z2;
                }
            } else {
                i2 = 0;
            }
            this.h.e.d(bfVar);
            if (i2 == 0 && r1 == 0 && c) {
                bfVar.k = null;
            }
        }
    }

    private void c(bf bfVar) {
        ViewCompat.a(bfVar.a, null);
        if (this.h.F != null) {
            this.h.F;
        }
        if (this.h.E != null) {
            this.h.E.a(bfVar);
        }
        if (this.h.p != null) {
            this.h.e.d(bfVar);
        }
        bfVar.k = null;
        aw c = c();
        int i = bfVar.e;
        ArrayList arrayList = (ArrayList) c.a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            c.a.put(i, arrayList);
            if (c.b.indexOfKey(i) < 0) {
                c.b.put(i, 5);
            }
        }
        if (c.b.get(i) > arrayList.size()) {
            bfVar.q();
            arrayList.add(bfVar);
        }
    }

    final void b(View view) {
        bf c = RecyclerView.c(view);
        c.o = null;
        c.p = false;
        c.h();
        a(c);
    }

    final void c(View view) {
        bf c = RecyclerView.c(view);
        if (!c.a(12) && c.s() && !RecyclerView.a(this.h, c)) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            c.a(this, true);
            this.b.add(c);
        } else if (!c.j() || c.m() || this.h.E.b) {
            c.a(this, false);
            this.a.add(c);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    final void b(bf bfVar) {
        if (bfVar.p) {
            this.b.remove(bfVar);
        } else {
            this.a.remove(bfVar);
        }
        bfVar.o = null;
        bfVar.p = false;
        bfVar.h();
    }

    private bf d(int i) {
        int i2 = 0;
        if (this.b != null) {
            int size = this.b.size();
            if (size != 0) {
                bf bfVar;
                int i3 = 0;
                while (i3 < size) {
                    bfVar = (bf) this.b.get(i3);
                    if (bfVar.g() || bfVar.c() != i) {
                        i3++;
                    } else {
                        bfVar.b(32);
                        return bfVar;
                    }
                }
                if (this.h.E.b) {
                    int a = this.h.c.a(i, 0);
                    if (a > 0 && a < this.h.E.a()) {
                        long c = this.h.E.c(a);
                        while (i2 < size) {
                            bfVar = (bf) this.b.get(i2);
                            if (bfVar.g() || bfVar.d != c) {
                                i2++;
                            } else {
                                bfVar.b(32);
                                return bfVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    private bf e(int i) {
        View view;
        int i2 = 0;
        int size = this.a.size();
        int i3 = 0;
        while (i3 < size) {
            bf bfVar = (bf) this.a.get(i3);
            if (bfVar.g() || bfVar.c() != i || bfVar.j() || (!this.h.p.g && bfVar.m())) {
                i3++;
            } else {
                bfVar.b(32);
                return bfVar;
            }
        }
        f fVar = this.h.d;
        int size2 = fVar.c.size();
        for (i3 = 0; i3 < size2; i3++) {
            View view2 = (View) fVar.c.get(i3);
            bf b = fVar.a.b(view2);
            if (b.c() == i && !b.j() && !b.m()) {
                view = view2;
                break;
            }
        }
        view = null;
        if (view != null) {
            bfVar = RecyclerView.c(view);
            f fVar2 = this.h.d;
            i2 = fVar2.a.a(view);
            if (i2 < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            } else if (fVar2.b.c(i2)) {
                fVar2.b.b(i2);
                fVar2.b(view);
                int c = this.h.d.c(view);
                if (c == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + bfVar);
                }
                this.h.d.d(c);
                c(view);
                bfVar.b(8224);
                return bfVar;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        i3 = this.c.size();
        while (i2 < i3) {
            bfVar = (bf) this.c.get(i2);
            if (bfVar.j() || bfVar.c() != i) {
                i2++;
            } else {
                this.c.remove(i2);
                return bfVar;
            }
        }
        return null;
    }

    private bf a(long j, int i) {
        int size;
        for (size = this.a.size() - 1; size >= 0; size--) {
            bf bfVar = (bf) this.a.get(size);
            if (bfVar.d == j && !bfVar.g()) {
                if (i == bfVar.e) {
                    bfVar.b(32);
                    if (!bfVar.m() || this.h.p.g) {
                        return bfVar;
                    }
                    bfVar.a(2, 14);
                    return bfVar;
                }
                this.a.remove(size);
                this.h.removeDetachedView(bfVar.a, false);
                b(bfVar.a);
            }
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            bfVar = (bf) this.c.get(size);
            if (bfVar.d == j) {
                if (i == bfVar.e) {
                    this.c.remove(size);
                    return bfVar;
                }
                c(size);
            }
        }
        return null;
    }

    final aw c() {
        if (this.f == null) {
            this.f = new aw();
        }
        return this.f;
    }
}
