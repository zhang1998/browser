package com.ucpro.feature.l.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class b implements AnimatorUpdateListener {
    final /* synthetic */ i a;

    b(i iVar) {
        this.a = iVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
