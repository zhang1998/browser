package android.mini.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
final class ak implements e {
    final /* synthetic */ RecyclerView a;

    ak(RecyclerView recyclerView) {
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
            this.a.f(childAt);
        }
        this.a.removeViewAt(i);
    }

    public final View b(int i) {
        return this.a.getChildAt(i);
    }

    public final bf b(View view) {
        return RecyclerView.c(view);
    }

    public final void a(View view, int i, LayoutParams layoutParams) {
        bf c = RecyclerView.c(view);
        if (c != null) {
            if (c.n() || c.b()) {
                c.i();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + c);
            }
        }
        this.a.attachViewToParent(view, i, layoutParams);
    }

    public final void c(int i) {
        View b = b(i);
        if (b != null) {
            bf c = RecyclerView.c(b);
            if (c != null) {
                if (!c.n() || c.b()) {
                    c.b((int) LogType.UNEXP);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + c);
                }
            }
        }
        this.a.detachViewFromParent(i);
    }

    public final void c(View view) {
        bf c = RecyclerView.c(view);
        if (c != null) {
            bf.a(c);
        }
    }

    public final void d(View view) {
        bf c = RecyclerView.c(view);
        if (c != null) {
            bf.b(c);
        }
    }

    public final void b() {
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.a.f(b(i));
        }
        this.a.removeAllViews();
    }
}
