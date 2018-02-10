package com.ucpro.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class p implements AnimatorUpdateListener {
    final /* synthetic */ AnimateImageView a;

    p(AnimateImageView animateImageView) {
        this.a = animateImageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.g = (Float) valueAnimator.getAnimatedValue();
        this.a.invalidate();
    }
}
