package com.ucpro.feature.t.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class o implements AnimatorUpdateListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i = 0; i < this.a.getChildCount(); i++) {
            k kVar = (k) this.a.getChildAt(i);
            int[] a = this.a.b(kVar.getIndex());
            int animStartX = (int) (((((float) a[0]) - kVar.getAnimStartX()) * floatValue) + kVar.getAnimStartX());
            int animStartY = (int) (((((float) a[1]) - kVar.getAnimStartY()) * floatValue) + kVar.getAnimStartY());
            kVar.setTranslationX((float) animStartX);
            kVar.setTranslationY((float) animStartY);
        }
    }
}
