package com.ucpro.ui.widget.viewpager;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class k extends DataSetObserver {
    final /* synthetic */ ProViewPager a;

    private k(ProViewPager proViewPager) {
        this.a = proViewPager;
    }

    public final void onChanged() {
        this.a.a();
    }

    public final void onInvalidated() {
        this.a.a();
    }
}
