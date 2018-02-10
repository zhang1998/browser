package com.ucpro.feature.l.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class n implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ d e;

    n(d dVar, int i, int i2, float f, float f2) {
        this.e = dVar;
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i = (int) ((((float) (this.a - this.b)) * floatValue) + ((float) this.b));
        floatValue = (floatValue * (this.c - this.d)) + this.d;
        this.e.a.setRotation((float) i);
        this.e.a.setAlpha(floatValue);
    }
}
