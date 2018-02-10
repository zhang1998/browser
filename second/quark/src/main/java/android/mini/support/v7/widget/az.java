package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class az extends ao {
    final /* synthetic */ RecyclerView a;

    private az(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a() {
        this.a.a(null);
        this.a.E;
        this.a.p.f = true;
        RecyclerView.n(this.a);
        if (!this.a.c.d()) {
            this.a.requestLayout();
        }
    }

    public final void a(int i, int i2) {
        int i3 = 1;
        this.a.a(null);
        c cVar = this.a.c;
        cVar.a.add(cVar.a(4, i, 1, null));
        cVar.g |= 4;
        if (cVar.a.size() != 1) {
            i3 = 0;
        }
        if (i3 != 0) {
            b();
        }
    }

    public final void a(int i) {
        int i2 = 1;
        this.a.a(null);
        c cVar = this.a.c;
        cVar.a.add(cVar.a(1, i, 1, null));
        cVar.g |= 1;
        if (cVar.a.size() != 1) {
            i2 = 0;
        }
        if (i2 != 0) {
            b();
        }
    }

    public final void b(int i) {
        int i2 = 1;
        this.a.a(null);
        c cVar = this.a.c;
        cVar.a.add(cVar.a(2, i, 1, null));
        cVar.g |= 2;
        if (cVar.a.size() != 1) {
            i2 = 0;
        }
        if (i2 != 0) {
            b();
        }
    }

    private void b() {
        if (this.a.P && this.a.J && this.a.I) {
            ViewCompat.a(this.a, this.a.A);
            return;
        }
        this.a.O = true;
        this.a.requestLayout();
    }
}
