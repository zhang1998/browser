package com.ucpro.feature.inputenhance;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ProGuard */
final class q implements AnimatorListener {
    final /* synthetic */ s a;

    q(s sVar) {
        this.a = sVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.k.setVisibility(8);
        this.a.k.setAlpha(0.0f);
        this.a.l.setVisibility(8);
        this.a.l.setAlpha(0.0f);
        this.a.h.remove(this.a.L);
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
