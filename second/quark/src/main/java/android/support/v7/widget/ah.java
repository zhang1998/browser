package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
final class ah extends bo {
    ah(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int a() {
        return this.a.j - this.a.j();
    }

    public final int b() {
        return this.a.j;
    }

    public final void a(int i) {
        this.a.d(i);
    }

    public final int c() {
        return this.a.h();
    }

    public final int a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (LayoutManager.c(view) + layoutParams.leftMargin);
    }

    public final int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (LayoutManager.d(view) + layoutParams.topMargin);
    }

    public final int c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + LayoutManager.g(view);
    }

    public final int d(View view) {
        return LayoutManager.e(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public final int d() {
        return (this.a.j - this.a.h()) - this.a.j();
    }

    public final int e() {
        return this.a.j();
    }

    public final int f() {
        return this.a.h;
    }

    public final int g() {
        return this.a.i;
    }
}
