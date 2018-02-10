package com.ucpro.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class ab implements AnimatorUpdateListener {
    final /* synthetic */ AnimateImageView a;

    ab(AnimateImageView animateImageView) {
        this.a = animateImageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.invalidate();
    }
}
