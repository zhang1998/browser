package com.ucpro.feature.navigation.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class an implements AnimatorUpdateListener {
    final /* synthetic */ j a;

    an(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.invalidate();
    }
}
