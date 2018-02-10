package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class r implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ s c;

    r(s sVar, float f, float f2) {
        this.c = sVar;
        this.a = f;
        this.b = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = this.a + ((0.0f - this.a) * floatValue);
        this.c.setLeftIconTranX(f);
        s.a(this.c.v, f);
        s.a(this.c.q, f);
        s.a(this.c.r, f);
        s.a(this.c.p, f);
        s.a(this.c.t, f);
        s.a(this.c.u, f);
        floatValue = (floatValue * (0.0f - this.b)) + this.b;
        this.c.setRigtIconTranX(floatValue);
        s.a(this.c.s, floatValue);
    }
}
