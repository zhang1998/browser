package com.ucpro.ui.widget.tablayout;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ProGuard */
final class v implements AnimatorUpdateListener {
    final /* synthetic */ u a;
    final /* synthetic */ r b;

    v(r rVar, u uVar) {
        this.b = rVar;
        this.a = uVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
