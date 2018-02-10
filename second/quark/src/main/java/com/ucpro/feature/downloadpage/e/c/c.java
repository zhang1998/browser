package com.ucpro.feature.downloadpage.e.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class c implements AnimatorUpdateListener {
    final /* synthetic */ t a;

    c(t tVar) {
        this.a = tVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.a.C);
        this.a.j = floatValue;
        t.a(this.a.c, floatValue);
        t.a(this.a.l, floatValue);
    }
}
