package com.ucpro.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
public final class x extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable a;
    final /* synthetic */ v b;

    public x(v vVar, Runnable runnable) {
        this.b = vVar;
        this.a = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            this.a.run();
        }
        this.b.a = null;
    }
}
