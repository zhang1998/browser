package com.ucpro.feature.webwindow.g;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class h implements AnimatorUpdateListener {
    final /* synthetic */ d a;

    public h(d dVar) {
        this.a = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b.offsetTopAndBottom(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
