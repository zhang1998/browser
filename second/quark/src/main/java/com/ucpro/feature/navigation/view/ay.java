package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ProGuard */
final class ay implements AnimatorListener {
    final /* synthetic */ l a;

    ay(l lVar) {
        this.a = lVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.l = null;
        this.a.p.remove(animator);
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
