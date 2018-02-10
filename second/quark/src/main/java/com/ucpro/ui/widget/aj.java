package com.ucpro.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class aj implements AnimatorUpdateListener {
    final /* synthetic */ v a;

    public aj(v vVar) {
        this.a = vVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.invalidate();
    }
}
