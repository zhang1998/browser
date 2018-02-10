package com.ucpro.ui.widget.tablayout;

import com.ucpro.ui.widget.viewpager.ProViewPager;

/* compiled from: ProGuard */
public final class g implements d {
    private final ProViewPager a;

    public g(ProViewPager proViewPager) {
        this.a = proViewPager;
    }

    public final void onTabSelected(c cVar) {
        this.a.setCurrentItem(cVar.e);
    }

    public final void onTabUnselected(c cVar) {
    }

    public final void onTabReselected(c cVar) {
    }
}
