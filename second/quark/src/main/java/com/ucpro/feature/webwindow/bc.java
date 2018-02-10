package com.ucpro.feature.webwindow;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class bc implements AnimatorUpdateListener {
    final /* synthetic */ ab a;

    bc(ab abVar) {
        this.a = abVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAddressBarOffsetY(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
