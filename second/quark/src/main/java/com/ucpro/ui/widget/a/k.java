package com.ucpro.ui.widget.a;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: ProGuard */
final class k implements OnScrollListener {
    OnScrollListener a;
    final /* synthetic */ a b;

    public k(a aVar) {
        this.b = aVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.a != null) {
            this.a.onScrollStateChanged(absListView, i);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.a != null) {
            this.a.onScroll(absListView, i, i2, i3);
        }
    }
}
