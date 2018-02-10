package com.ucpro.feature.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class p extends AnimatorListenerAdapter {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.setVisibility(8);
    }
}
