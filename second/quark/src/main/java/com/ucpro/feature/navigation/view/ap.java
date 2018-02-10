package com.ucpro.feature.navigation.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class ap implements AnimatorUpdateListener {
    final /* synthetic */ l a;

    ap(l lVar) {
        this.a = lVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b();
    }
}
