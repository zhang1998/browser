package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ProGuard */
final class y implements AnimatorListener {
    final /* synthetic */ Runnable a = null;
    final /* synthetic */ l b;

    y(l lVar) {
        this.b = lVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.m = null;
        this.b.p.remove(animator);
        if (this.a != null) {
            this.a.run();
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
