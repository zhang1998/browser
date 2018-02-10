package com.ucpro.feature.s.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class f implements AnimatorUpdateListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setVisibleTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
