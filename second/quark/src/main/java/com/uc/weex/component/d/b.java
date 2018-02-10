package com.uc.weex.component.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class b implements AnimatorUpdateListener {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.i = (int) (((float) this.a.b) * floatValue);
        this.a.j = (int) ((1.6600001f - floatValue) * ((float) this.a.b));
        this.a.invalidate();
    }
}
