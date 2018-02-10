package com.ucpro.feature.inputenhance;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

/* compiled from: ProGuard */
final class ap implements AnimatorListener {
    final /* synthetic */ ValueAnimator a;
    final /* synthetic */ s b;

    ap(s sVar, ValueAnimator valueAnimator) {
        this.b = sVar;
        this.a = valueAnimator;
    }

    public final void onAnimationStart(Animator animator) {
        this.b.I = true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.h.remove(this.a);
        this.b.I = false;
        if (this.b.J) {
            this.b.b(false);
            this.b.J = false;
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
