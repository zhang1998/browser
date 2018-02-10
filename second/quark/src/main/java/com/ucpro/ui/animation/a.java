package com.ucpro.ui.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class a implements AnimatorUpdateListener {
    final /* synthetic */ i a;

    a(i iVar) {
        this.a = iVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            this.a.a(((Integer) animatedValue).intValue());
        }
    }
}
