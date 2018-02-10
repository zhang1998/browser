package com.ucpro.feature.t.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class r implements AnimatorUpdateListener {
    final /* synthetic */ n a;

    r(n nVar) {
        this.a = nVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.requestLayout();
    }
}
