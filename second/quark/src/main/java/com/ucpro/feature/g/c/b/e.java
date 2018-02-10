package com.ucpro.feature.g.c.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class e implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ i b;

    public e(i iVar, float f) {
        this.b = iVar;
        this.a = f;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.b.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
