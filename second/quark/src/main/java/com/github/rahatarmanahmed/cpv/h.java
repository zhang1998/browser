package com.github.rahatarmanahmed.cpv;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class h implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ CircularProgressView c;

    h(CircularProgressView circularProgressView, float f, float f2) {
        this.c = circularProgressView;
        this.a = f;
        this.b = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.c.h = (this.a - this.c.q) + this.b;
        this.c.invalidate();
    }
}
