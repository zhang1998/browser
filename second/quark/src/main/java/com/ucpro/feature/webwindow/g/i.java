package com.ucpro.feature.webwindow.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
public final class i extends AnimatorListenerAdapter {
    final /* synthetic */ d a;

    public i(d dVar) {
        this.a = dVar;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a.getBusinessLayer().removeView(this.a.b);
    }

    public final void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        this.a.a.getBusinessLayer().removeView(this.a.b);
    }
}
