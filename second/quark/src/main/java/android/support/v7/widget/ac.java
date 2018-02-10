package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
final class ac implements q {
    final /* synthetic */ RecyclerView a;

    ac(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final int a() {
        return this.a.getChildCount();
    }

    public final void a(View view, int i) {
        this.a.addView(view, i);
        RecyclerView.a(this.a, view);
    }

    public final int a(View view) {
        return this.a.indexOfChild(view);
    }

    public final void a(int i) {
        View childAt = this.a.getChildAt(i);
        if (childAt != null) {
            this.a.e(childAt);
        }
        this.a.removeViewAt(i);
    }

    public final View b(int i) {
        return this.a.getChildAt(i);
    }

    public final bh b(View view) {
        return RecyclerView.b(view);
    }

    public final void a(View view, int i, LayoutParams layoutParams) {
        bh b = RecyclerView.b(view);
        if (b != null) {
            if (b.n() || b.b()) {
                b.i();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + b);
            }
        }
        this.a.attachViewToParent(view, i, layoutParams);
    }

    public final void c(int i) {
        View b = b(i);
        if (b != null) {
            bh b2 = RecyclerView.b(b);
            if (b2 != null) {
                if (!b2.n() || b2.b()) {
                    b2.b((int) LogType.UNEXP);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + b2);
                }
            }
        }
        this.a.detachViewFromParent(i);
    }

    public final void c(View view) {
        bh b = RecyclerView.b(view);
        if (b != null) {
            bh.a(b);
        }
    }

    public final void d(View view) {
        bh b = RecyclerView.b(view);
        if (b != null) {
            bh.b(b);
        }
    }

    public final void b() {
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.a.e(b(i));
        }
        this.a.removeAllViews();
    }
}
