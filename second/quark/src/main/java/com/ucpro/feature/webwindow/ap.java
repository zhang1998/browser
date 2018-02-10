package com.ucpro.feature.webwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class ap extends AnimatorListenerAdapter {
    final /* synthetic */ ab a;

    ap(ab abVar) {
        this.a = abVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a.f == 0) {
            this.a.setVisibility(8);
        }
    }
}
