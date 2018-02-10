package com.taobao.weex.ui.view;

import android.mini.support.v4.view.bx;

/* compiled from: ProGuard */
final class i implements bx {
    final /* synthetic */ WXCircleViewPager a;

    i(WXCircleViewPager wXCircleViewPager) {
        this.a = wXCircleViewPager;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void a(int i) {
    }

    public final void b(int i) {
        this.a.v = i;
        h circlePageAdapter = this.a.getCirclePageAdapter();
        int a = super.getCurrentItem();
        if (!this.a.t || i != 0 || circlePageAdapter.a() <= 1) {
            return;
        }
        if (a == circlePageAdapter.a() - 1) {
            this.a.b(1, false);
        } else if (a == 0) {
            this.a.b(circlePageAdapter.a() - 2, false);
        }
    }
}
