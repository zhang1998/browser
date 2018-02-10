package com.uc.weex.component.f;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class g implements AnimatorUpdateListener {
    final /* synthetic */ k a;

    g(k kVar) {
        this.a = kVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.a.getMinScrollHeight(), this.a.getMaxScrollHeight());
    }
}
