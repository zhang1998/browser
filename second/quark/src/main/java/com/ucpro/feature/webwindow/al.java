package com.ucpro.feature.webwindow;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class al implements AnimatorUpdateListener {
    final /* synthetic */ ab a;

    al(ab abVar) {
        this.a = abVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
