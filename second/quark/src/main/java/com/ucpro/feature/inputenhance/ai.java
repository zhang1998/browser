package com.ucpro.feature.inputenhance;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class ai implements AnimatorUpdateListener {
    final /* synthetic */ s a;

    ai(s sVar) {
        this.a = sVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.A.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
