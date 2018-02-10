package com.ucpro.feature.downloadpage.e.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class o implements AnimatorUpdateListener {
    final /* synthetic */ t a;

    o(t tVar) {
        this.a = tVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float a = (float) this.a.C;
        float floatValue = (((Float) valueAnimator.getAnimatedValue()).floatValue() * (0.0f - ((float) this.a.C))) + a;
        this.a.j = floatValue;
        t.a(this.a.c, floatValue);
        t.a(this.a.l, floatValue);
    }
}
