package com.taobao.weex.ui.view.refresh.core;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: ProGuard */
final class e implements AnimatorUpdateListener {
    final /* synthetic */ WXSwipeLayout a;

    e(WXSwipeLayout wXSwipeLayout) {
        this.a = wXSwipeLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LayoutParams layoutParams = (LayoutParams) this.a.b.getLayoutParams();
        layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.b.setLayoutParams(layoutParams);
        this.a.a((float) layoutParams.height);
    }
}
