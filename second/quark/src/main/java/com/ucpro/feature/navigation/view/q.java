package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ProGuard */
final class q implements AnimatorListener {
    final /* synthetic */ l a;

    q(l lVar) {
        this.a = lVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.r = null;
        this.a.p.remove(animator);
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
