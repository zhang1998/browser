package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
final class ay extends bo {
    ay(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int a() {
        return this.a.k - this.a.k();
    }

    public final int b() {
        return this.a.k;
    }

    public final void a(int i) {
        this.a.e(i);
    }

    public final int c() {
        return this.a.i();
    }

    public final int a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (LayoutManager.d(view) + layoutParams.topMargin);
    }

    public final int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (LayoutManager.c(view) + layoutParams.leftMargin);
    }

    public final int c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + LayoutManager.h(view);
    }

    public final int d(View view) {
        return LayoutManager.f(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public final int d() {
        return (this.a.k - this.a.i()) - this.a.k();
    }

    public final int e() {
        return this.a.k();
    }

    public final int f() {
        return this.a.i;
    }

    public final int g() {
        return this.a.h;
    }
}
