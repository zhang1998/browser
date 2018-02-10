package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutParams;
import android.mini.support.v7.widget.RecyclerView.State;
import android.view.View;
import java.util.List;

/* compiled from: ProGuard */
final class y {
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
    List<bf> k = null;
    boolean l;

    y() {
    }

    final boolean a(State state) {
        return this.d >= 0 && this.d < state.a();
    }

    final View a(ax axVar) {
        if (this.k != null) {
            int size = this.k.size();
            int i = 0;
            while (i < size) {
                View view = ((bf) this.k.get(i)).a;
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
        View b = axVar.b(this.d);
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
            view2 = ((bf) this.k.get(i2)).a;
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
