package com.ucpro.feature.webwindow;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class bh implements AnimatorUpdateListener {
    final /* synthetic */ ab a;

    bh(ab abVar) {
        this.a = abVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAddressBarOffsetY(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
