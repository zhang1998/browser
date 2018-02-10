package com.ucpro.feature.downloadpage.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class a implements AnimatorUpdateListener {
    final /* synthetic */ o a;

    a(o oVar) {
        this.a = oVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.l.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
