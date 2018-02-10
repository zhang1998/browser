package com.ucpro.feature.webwindow.k;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class f implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    public f(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.e.setRotation(floatValue);
        d b = this.a.f;
        if (b.d) {
            b.b = floatValue;
            if (b.b >= 360.0f) {
                b.b = 360.0f;
            }
        } else {
            b.c = floatValue - 90.0f;
            b.b = 270.0f - b.c;
            if (b.c >= 270.0f) {
                b.c = -90.0f;
                b.b = 0.0f;
            }
        }
        this.a.f.invalidate();
    }
}
