package com.github.rahatarmanahmed.cpv;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class i implements AnimatorUpdateListener {
    final /* synthetic */ CircularProgressView a;

    i(CircularProgressView circularProgressView) {
        this.a = circularProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }
}
