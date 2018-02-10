package com.ucpro.feature.s.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class a extends AnimatorListenerAdapter {
    final /* synthetic */ e a;

    a(e eVar) {
        this.a = eVar;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        e.c(this.a);
    }
}
