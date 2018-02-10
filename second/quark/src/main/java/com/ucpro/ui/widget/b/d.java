package com.ucpro.ui.widget.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class d implements AnimatorUpdateListener {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
