package com.ucpro.feature.l.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class l implements AnimatorUpdateListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ i b;

    l(i iVar, boolean z) {
        this.b = iVar;
        this.a = z;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.a, 0);
    }
}
