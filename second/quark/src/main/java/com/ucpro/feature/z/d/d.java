package com.ucpro.feature.z.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class d implements AnimatorUpdateListener {
    final /* synthetic */ j a;

    d(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.g.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.invalidate();
    }
}
