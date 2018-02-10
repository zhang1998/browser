package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class ag extends AnimatorListenerAdapter {
    final /* synthetic */ j a;

    ag(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.getAnimatorList().remove(animator);
    }
}
