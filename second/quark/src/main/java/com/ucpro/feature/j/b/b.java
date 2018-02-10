package com.ucpro.feature.j.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class b implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setStretchProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
