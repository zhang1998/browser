package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import java.util.List;

/* compiled from: ProGuard */
final class aa {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List<bh> k = null;
    boolean l;

    aa() {
    }

    final boolean a(v vVar) {
        return this.d >= 0 && this.d < vVar.a();
    }

    final View a(az azVar) {
        if (this.k != null) {
            int size = this.k.size();
            int i = 0;
            while (i < size) {
                View view = ((bh) this.k.get(i)).a;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.c.m() || this.d != layoutParams.c.c()) {
                    i++;
                } else {
                    a(view);
                    return view;
                }
            }
            return null;
        }
        View b = azVar.b(this.d);
        this.d += this.e;
        return b;
    }

    public final void a(View view) {
        View view2;
        int size = this.k.size();
        View view3 = null;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            int c;
            View view4;
            view2 = ((bh) this.k.get(i2)).a;
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (!(view2 == view || layoutParams.c.m())) {
                c = (layoutParams.c.c() - this.d) * this.e;
                if (c >= 0 && c < i) {
                    if (c == 0) {
                        break;
                    }
                    view4 = view2;
                    i2++;
                    view3 = view4;
                    i = c;
                }
            }
            c = i;
            view4 = view3;
            i2++;
            view3 = view4;
            i = c;
        }
        view2 = view3;
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((LayoutParams) view2.getLayoutParams()).c.c();
        }
    }
}
