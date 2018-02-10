package com.ucpro.feature.z.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class k implements AnimatorUpdateListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.f.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.invalidate();
    }
}
