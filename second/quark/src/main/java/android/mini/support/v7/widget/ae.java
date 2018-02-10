package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
final class ae extends af {
    ae(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int a() {
        return this.a.z - this.a.r();
    }

    public final int b() {
        return this.a.z;
    }

    public final void a(int i) {
        this.a.g(i);
    }

    public final int c() {
        return this.a.p();
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

    public final int e(View view) {
        this.a.a(view, this.c);
        return this.c.bottom;
    }

    public final int f(View view) {
        this.a.a(view, this.c);
        return this.c.top;
    }

    public final int d() {
        return (this.a.z - this.a.p()) - this.a.r();
    }

    public final int e() {
        return this.a.r();
    }

    public final int f() {
        return this.a.x;
    }

    public final int g() {
        return this.a.w;
    }
}
