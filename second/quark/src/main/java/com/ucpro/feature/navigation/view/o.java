package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ProGuard */
final class o implements AnimatorListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ aj b;
    final /* synthetic */ l c;

    o(l lVar, Runnable runnable, aj ajVar) {
        this.c = lVar;
        this.a = runnable;
        this.b = ajVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.c.b();
        this.c.p.remove(animator);
        if (this.a != null) {
            this.a.run();
        }
        this.b.b = false;
        this.b.invalidate();
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
