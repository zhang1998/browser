package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.mini.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: ProGuard */
final class al implements a {
    final /* synthetic */ RecyclerView a;

    al(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final bf a(int i) {
        bf c;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.d.b();
        int i2 = 0;
        bf bfVar = null;
        while (i2 < b) {
            c = RecyclerView.c(recyclerView.d.c(i2));
            if (c != null && !c.m() && c.b == i) {
                if (!recyclerView.d.d(c.a)) {
                    break;
                }
            } else {
                c = bfVar;
            }
            i2++;
            bfVar = c;
        }
        c = bfVar;
        if (c == null) {
            return null;
        }
        if (this.a.d.d(c.a)) {
            return null;
        }
        return c;
    }

    public final void a(int i, int i2) {
        this.a.a(i, i2, true);
        this.a.r = true;
        State state = this.a.p;
        state.e += i2;
    }

    public final void b(int i, int i2) {
        this.a.a(i, i2, false);
        this.a.r = true;
    }

    public final void a(int i, int i2, Object obj) {
        int i3;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.d.b();
        int i4 = i + i2;
        for (i3 = 0; i3 < b; i3++) {
            View c = recyclerView.d.c(i3);
            bf c2 = RecyclerView.c(c);
            if (c2 != null && !c2.b() && c2.b >= i && c2.b < i4) {
                c2.b(2);
                c2.a(obj);
                ((LayoutParams) c.getLayoutParams()).e = true;
            }
        }
        ax axVar = recyclerView.b;
        b = i + i2;
        for (i3 = axVar.c.size() - 1; i3 >= 0; i3--) {
            bf bfVar = (bf) axVar.c.get(i3);
            if (bfVar != null) {
                i4 = bfVar.c();
                if (i4 >= i && i4 < b) {
                    bfVar.b(2);
                    axVar.c(i3);
                }
            }
        }
        this.a.s = true;
    }

    public final void a(b bVar) {
        c(bVar);
    }

    private void c(b bVar) {
        switch (bVar.a) {
            case 1:
                this.a.f.a(bVar.b, bVar.d);
                return;
            case 2:
                this.a.f.b(bVar.b, bVar.d);
                return;
            case 4:
                this.a.f.c(bVar.b, bVar.d);
                return;
            case 8:
                this.a.f.d(bVar.b, bVar.d);
                return;
            default:
                return;
        }
    }

    public final void b(b bVar) {
        c(bVar);
    }

    public final void c(int i, int i2) {
        int i3;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.d.b();
        for (i3 = 0; i3 < b; i3++) {
            bf c = RecyclerView.c(recyclerView.d.c(i3));
            if (!(c == null || c.b() || c.b < i)) {
                c.a(i2, false);
                recyclerView.p.f = true;
            }
        }
        ax axVar = recyclerView.b;
        int size = axVar.c.size();
        for (i3 = 0; i3 < size; i3++) {
            bf bfVar = (bf) axVar.c.get(i3);
            if (bfVar != null && bfVar.b >= i) {
                bfVar.a(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.a.r = true;
    }

    public final void d(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.d.b();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (i6 = 0; i6 < b; i6++) {
            bf c = RecyclerView.c(recyclerView.d.c(i6));
            if (c != null && c.b >= r4 && c.b <= r3) {
                if (c.b == i) {
                    c.a(i2 - i, false);
                } else {
                    c.a(i3, false);
                }
                recyclerView.p.f = true;
            }
        }
        ax axVar = recyclerView.b;
        if (i < i2) {
            i4 = i2;
            i5 = i;
        } else {
            i7 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = axVar.c.size();
        for (i6 = 0; i6 < size; i6++) {
            bf bfVar = (bf) axVar.c.get(i6);
            if (bfVar != null && bfVar.b >= r4 && bfVar.b <= r3) {
                if (bfVar.b == i) {
                    bfVar.a(i2 - i, false);
                } else {
                    bfVar.a(i7, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.a.r = true;
    }
}
