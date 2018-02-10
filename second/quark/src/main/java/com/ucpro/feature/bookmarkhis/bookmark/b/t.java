package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class t implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ s e;

    t(s sVar, float f, float f2, int i, int i2) {
        this.e = sVar;
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = i2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = this.a + ((0.0f - this.a) * floatValue);
        this.e.setLeftIconTranX(f);
        s.a(this.e.v, f);
        s.a(this.e.q, f);
        s.a(this.e.r, f);
        s.a(this.e.p, f);
        s.a(this.e.t, f);
        s.a(this.e.u, f);
        f = this.b + ((0.0f - this.b) * floatValue);
        this.e.setRigtIconTranX(f);
        s.a(this.e.s, f);
        this.e.setTextRightBound(Math.round((floatValue * ((float) (this.d - this.c))) + ((float) this.c)));
        this.e.invalidate();
    }
}
