package com.ucpro.feature.inputenhance;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

/* compiled from: ProGuard */
final class i implements AnimatorListener {
    final /* synthetic */ ValueAnimator a;
    final /* synthetic */ boolean b;
    final /* synthetic */ s c;

    i(s sVar, ValueAnimator valueAnimator, boolean z) {
        this.c = sVar;
        this.a = valueAnimator;
        this.b = z;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.c.h.remove(this.a);
        if (this.b) {
            this.c.O.b();
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
