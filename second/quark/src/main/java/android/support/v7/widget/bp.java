package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

/* compiled from: ProGuard */
final class bp {
    int a;
    int b;
    boolean c;
    final /* synthetic */ LinearLayoutManager d;

    bp(LinearLayoutManager linearLayoutManager) {
        this.d = linearLayoutManager;
    }

    final void a() {
        this.b = this.c ? this.d.m.a() : this.d.m.c();
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }

    public final void a(View view) {
        if (this.c) {
            this.b = this.d.m.c(view) + this.d.m.h();
        } else {
            this.b = this.d.m.d(view);
        }
        this.a = LayoutManager.a(view);
    }
}
