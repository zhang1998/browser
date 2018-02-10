package com.taobao.weex.ui.view.refresh.core;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class k implements AnimatorUpdateListener {
    int a = 0;
    final /* synthetic */ WXSwipeLayout b;

    public k(WXSwipeLayout wXSwipeLayout) {
        this.b = wXSwipeLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i = intValue - this.a;
        if (i != 0) {
            this.b.a(i, i);
        }
        this.a = intValue;
    }
}
