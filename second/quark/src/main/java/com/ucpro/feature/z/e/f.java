package com.ucpro.feature.z.e;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: ProGuard */
final class f implements OnScrollListener {
    final /* synthetic */ n a;

    f(n nVar) {
        this.a = nVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 && this.a.d) {
            com.ucweb.common.util.f.a(this.a.h, (View) absListView);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
