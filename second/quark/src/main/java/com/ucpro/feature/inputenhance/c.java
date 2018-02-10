package com.ucpro.feature.inputenhance;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class c implements AnimatorUpdateListener {
    final /* synthetic */ s a;

    c(s sVar) {
        this.a = sVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.k.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.l.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
