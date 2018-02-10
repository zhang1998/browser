package com.ucpro.feature.y;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class q implements AnimatorUpdateListener {
    final /* synthetic */ j a;

    q(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a.getSearchBar().setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
