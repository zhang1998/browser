package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

/* compiled from: ProGuard */
final class av {
    static int a(v vVar, bo boVar, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.g() == 0 || vVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (vVar.a() - Math.max(LayoutManager.a(view), LayoutManager.a(view2))) - 1) : Math.max(0, Math.min(LayoutManager.a(view), LayoutManager.a(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(boVar.c(view2) - boVar.d(view))) / ((float) (Math.abs(LayoutManager.a(view) - LayoutManager.a(view2)) + 1)))) + ((float) (boVar.c() - boVar.d(view))));
    }

    static int a(v vVar, bo boVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.g() == 0 || vVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(LayoutManager.a(view) - LayoutManager.a(view2)) + 1;
        }
        return Math.min(boVar.d(), boVar.c(view2) - boVar.d(view));
    }

    static int b(v vVar, bo boVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.g() == 0 || vVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return vVar.a();
        }
        return (int) ((((float) (boVar.c(view2) - boVar.d(view))) / ((float) (Math.abs(LayoutManager.a(view) - LayoutManager.a(view2)) + 1))) * ((float) vVar.a()));
    }
}
