package com.ucpro.feature.y;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class k implements AnimatorUpdateListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
