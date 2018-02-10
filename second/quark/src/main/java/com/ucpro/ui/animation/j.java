package com.ucpro.ui.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ProGuard */
public final class j implements AnimatorUpdateListener {
    final /* synthetic */ View a;
    final /* synthetic */ f b;

    public j(f fVar, View view) {
        this.b = fVar;
        this.a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.getLayoutParams() != null) {
            this.a.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.a.setLayoutParams(this.a.getLayoutParams());
        }
    }
}
