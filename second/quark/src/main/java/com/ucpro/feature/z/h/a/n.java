package com.ucpro.feature.z.h.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class n extends AnimatorListenerAdapter {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a.w != null) {
            this.a.w.a();
        }
    }
}
