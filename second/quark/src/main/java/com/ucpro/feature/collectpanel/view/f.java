package com.ucpro.feature.collectpanel.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class f extends AnimatorListenerAdapter {
    final /* synthetic */ c a;

    f(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a.h();
    }
}
