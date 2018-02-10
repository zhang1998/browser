package com.ucpro.feature.webwindow.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
public final class g extends AnimatorListenerAdapter {
    final /* synthetic */ d a;

    public g(d dVar) {
        this.a = dVar;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.b.b();
    }
}
