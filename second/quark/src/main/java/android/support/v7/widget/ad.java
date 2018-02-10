package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
final class ad implements z {
    final /* synthetic */ RecyclerView a;

    ad(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final bh a(int i) {
        bh b;
        RecyclerView recyclerView = this.a;
        int b2 = recyclerView.d.b();
        for (int i2 = 0; i2 < b2; i2++) {
            b = RecyclerView.b(recyclerView.d.c(i2));
            if (b != null && !b.m() && b.b == i) {
                break;
            }
        }
        b = null;
        if (b == null || this.a.d.d(b.a)) {
            return null;
        }
        return b;
    }

    public final void a(int i, int i2) {
        this.a.a(i, i2, true);
        this.a.q = true;
        v vVar = this.a.p;
        vVar.e += i2;
    }

    public final void b(int i, int i2) {
        this.a.a(i, i2, false);
        this.a.q = true;
    }

    public final void a(int i, int i2, Object obj) {
        int i3;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.d.b();
        int i4 = i + i2;
        for (i3 = 0; i3 < b; i3++) {
            View c = recyclerView.d.c(i3);
            bh b2 = RecyclerView.b(c);
            if (b2 != null && !b2.b() && b2.b >= i && b2.b < i4) {
                b2.b(2);
                b2.a(obj);
                ((LayoutParams) c.getLayoutParams()).e = true;
            }
        }
        az azVar = recyclerView.b;
        b = i + i2;
        for (i3 = azVar.c.size() - 1; i3 >= 0; i3--) {
            bh bhVar = (bh) azVar.c.get(i3);
            if (bhVar != null) {
                i4 = bhVar.c();
                if (i4 >= i && i4 < b) {
                    bhVar.b(2);
                    azVar.c(i3);
                }
            }
        }
        this.a.r = true;
    }

    public final void a(ai aiVar) {
        c(aiVar);
    }

    private void c(ai aiVar) {
        switch (aiVar.a) {
            case 1:
                this.a.f.c(aiVar.b, aiVar.d);
                return;
            case 2:
                this.a.f.d(aiVar.b, aiVar.d);
                return;
            case 4:
                this.a.f.e(aiVar.b, aiVar.d);
                return;
            case 8:
                this.a.f.f(aiVar.b, aiVar.d);
                return;
            default:
                return;
        }
    }

    public final void b(ai aiVar) {
        c(aiVar);
    }

    public final void c(int i, int i2) {
        int i3;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.d.b();
        for (i3 = 0; i3 < b; i3++) {
            bh b2 = RecyclerView.b(recyclerView.d.c(i3));
            if (!(b2 == null || b2.b() || b2.b < i)) {
                b2.a(i2, false);
                recyclerView.p.f = true;
            }
        }
        az azVar = recyclerView.b;
        int size = azVar.c.size();
        for (i3 = 0; i3 < size; i3++) {
            bh bhVar = (bh) azVar.c.get(i3);
            if (bhVar != null && bhVar.b >= i) {
                bhVar.a(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.a.q = true;
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
            bh b2 = RecyclerView.b(recyclerView.d.c(i6));
            if (b2 != null && b2.b >= r4 && b2.b <= r3) {
                if (b2.b == i) {
                    b2.a(i2 - i, false);
                } else {
                    b2.a(i3, false);
                }
                recyclerView.p.f = true;
            }
        }
        az azVar = recyclerView.b;
        if (i < i2) {
            i4 = i2;
            i5 = i;
        } else {
            i7 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = azVar.c.size();
        for (i6 = 0; i6 < size; i6++) {
            bh bhVar = (bh) azVar.c.get(i6);
            if (bhVar != null && bhVar.b >= r4 && bhVar.b <= r3) {
                if (bhVar.b == i) {
                    bhVar.a(i2 - i, false);
                } else {
                    bhVar.a(i7, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.a.q = true;
    }
}
