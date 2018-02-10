package com.uc.weex.component.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class a implements AnimatorUpdateListener {
    final /* synthetic */ c a;

    a(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
