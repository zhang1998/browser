package com.ucpro.feature.webwindow.k;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class g implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    public g(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
    }
}
