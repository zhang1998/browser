package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
public final class m implements AnimatorUpdateListener {
    final /* synthetic */ b a;

    public m(b bVar) {
        this.a = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c.setRotation((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
