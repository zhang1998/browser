package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: ProGuard */
final class bi {
    static int a(State state, af afVar, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.n() == 0 || state.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max;
        int min = Math.min(LayoutManager.a(view), LayoutManager.a(view2));
        int max2 = Math.max(LayoutManager.a(view), LayoutManager.a(view2));
        if (z2) {
            max = Math.max(0, (state.a() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(afVar.c(view2) - afVar.d(view))) / ((float) (Math.abs(LayoutManager.a(view) - LayoutManager.a(view2)) + 1)))) + ((float) (afVar.c() - afVar.d(view))));
    }

    static int a(State state, af afVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.n() == 0 || state.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(LayoutManager.a(view) - LayoutManager.a(view2)) + 1;
        }
        return Math.min(afVar.d(), afVar.c(view2) - afVar.d(view));
    }

    static int b(State state, af afVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.n() == 0 || state.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.a();
        }
        return (int) ((((float) (afVar.c(view2) - afVar.d(view))) / ((float) (Math.abs(LayoutManager.a(view) - LayoutManager.a(view2)) + 1))) * ((float) state.a()));
    }
}
