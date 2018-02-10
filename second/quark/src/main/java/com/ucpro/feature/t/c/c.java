package com.ucpro.feature.t.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class c implements AnimatorUpdateListener {
    final /* synthetic */ d a;

    c(d dVar) {
        this.a = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.requestLayout();
    }
}
