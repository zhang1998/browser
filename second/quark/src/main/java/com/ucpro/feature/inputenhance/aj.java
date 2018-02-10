package com.ucpro.feature.inputenhance;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class aj implements AnimatorUpdateListener {
    final /* synthetic */ SliderView a;

    aj(SliderView sliderView) {
        this.a = sliderView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
