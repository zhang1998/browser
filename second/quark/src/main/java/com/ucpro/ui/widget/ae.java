package com.ucpro.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class ae implements AnimatorUpdateListener {
    final /* synthetic */ AnimateImageView a;

    ae(AnimateImageView animateImageView) {
        this.a = animateImageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.invalidate();
    }
}
