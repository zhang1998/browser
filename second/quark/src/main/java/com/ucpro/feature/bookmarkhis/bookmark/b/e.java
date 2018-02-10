package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class e implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ j b;

    e(j jVar, float f) {
        this.b = jVar;
        this.a = f;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        j.a(this.b, ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a);
        this.b.invalidate();
    }
}
