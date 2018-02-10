package com.ucpro.feature.webwindow.g;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: ProGuard */
public final class m implements AnimatorUpdateListener {
    final /* synthetic */ d a;

    public m(d dVar) {
        this.a = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LayoutParams layoutParams = (LayoutParams) this.a.b.getLayoutParams();
        layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.b.setLayoutParams(layoutParams);
    }
}
