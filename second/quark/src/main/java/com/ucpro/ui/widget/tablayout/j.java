package com.ucpro.ui.widget.tablayout;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class j extends DataSetObserver {
    final /* synthetic */ ProTabLayout a;

    private j(ProTabLayout proTabLayout) {
        this.a = proTabLayout;
    }

    public final void onChanged() {
        this.a.c();
    }

    public final void onInvalidated() {
        this.a.c();
    }
}
