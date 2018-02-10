package com.ucpro.feature.t.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class k implements AnimatorUpdateListener {
    final /* synthetic */ d a;

    k(d dVar) {
        this.a = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.requestLayout();
    }
}
