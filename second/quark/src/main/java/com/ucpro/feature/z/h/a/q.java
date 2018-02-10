package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class q implements AnimatorUpdateListener {
    final /* synthetic */ l a;

    q(l lVar) {
        this.a = lVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.y.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.e.setY((float) this.a.n);
        this.a.b.setY((float) this.a.m);
    }
}
