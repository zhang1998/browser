package com.ucpro.ui.widget.ripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;

/* compiled from: ProGuard */
final class e extends AnimatorListenerAdapter {
    final /* synthetic */ int a;
    final /* synthetic */ RippleBackground b;

    e(RippleBackground rippleBackground, int i) {
        this.b = rippleBackground;
        this.a = i;
    }

    public final void onAnimationEnd(Animator animator) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "outerOpacity", new float[]{0.0f});
        ofFloat.setDuration((long) this.a);
        ofFloat.setInterpolator(RippleBackground.LINEAR_INTERPOLATOR);
        this.b.mAnimOuterOpacity = ofFloat;
        k.a(ofFloat);
    }

    public final void onAnimationCancel(Animator animator) {
        animator.removeListener(this);
    }
}
