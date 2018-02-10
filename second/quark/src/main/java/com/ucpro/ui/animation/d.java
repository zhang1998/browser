package com.ucpro.ui.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
public final class d extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable a;
    final /* synthetic */ f b;

    public d(f fVar, Runnable runnable) {
        this.b = fVar;
        this.a = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.a != null) {
            this.a.run();
        }
    }
}
