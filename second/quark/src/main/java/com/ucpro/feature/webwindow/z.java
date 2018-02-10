package com.ucpro.feature.webwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class z extends AnimatorListenerAdapter {
    final /* synthetic */ w a;

    z(w wVar) {
        this.a = wVar;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a.setTranslationY(0.0f);
    }
}
