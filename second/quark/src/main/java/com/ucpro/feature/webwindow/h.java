package com.ucpro.feature.webwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class h extends AnimatorListenerAdapter {
    final /* synthetic */ x a;

    h(x xVar) {
        this.a = xVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a.e == 0) {
            this.a.setVisibility(8);
        }
    }
}
