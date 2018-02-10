package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class bl extends at {
    final /* synthetic */ RecyclerView a;

    private bl(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a() {
        this.a.a(null);
        this.a.A;
        this.a.p.f = true;
        RecyclerView.n(this.a);
        if (!this.a.c.d()) {
            this.a.requestLayout();
        }
    }

    public final void a(int i, int i2) {
        Object obj = 1;
        this.a.a(null);
        an anVar = this.a.c;
        anVar.a.add(anVar.a(4, i, i2, null));
        anVar.g |= 4;
        if (anVar.a.size() != 1) {
            obj = null;
        }
        if (obj != null) {
            b();
        }
    }

    public final void a(int i) {
        int i2 = 1;
        this.a.a(null);
        an anVar = this.a.c;
        anVar.a.add(anVar.a(2, i, 1, null));
        anVar.g |= 2;
        if (anVar.a.size() != 1) {
            i2 = 0;
        }
        if (i2 != 0) {
            b();
        }
    }

    private void b() {
        if (this.a.M && this.a.G && this.a.F) {
            ViewCompat.a(this.a, this.a.y);
            return;
        }
        this.a.L = true;
        this.a.requestLayout();
    }
}
