package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
final class ad extends af {
    ad(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int a() {
        return this.a.y - this.a.q();
    }

    public final int b() {
        return this.a.y;
    }

    public final void a(int i) {
        this.a.f(i);
    }

    public final int c() {
        return this.a.o();
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

    public final int e(View view) {
        this.a.a(view, this.c);
        return this.c.right;
    }

    public final int f(View view) {
        this.a.a(view, this.c);
        return this.c.left;
    }

    public final int d() {
        return (this.a.y - this.a.o()) - this.a.q();
    }

    public final int e() {
        return this.a.q();
    }

    public final int f() {
        return this.a.w;
    }

    public final int g() {
        return this.a.x;
    }
}
