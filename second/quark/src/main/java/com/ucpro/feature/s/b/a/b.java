package com.ucpro.feature.s.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class b extends AnimatorListenerAdapter {
    final /* synthetic */ e a;

    b(e eVar) {
        this.a = eVar;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.a.g != null) {
            this.a.g.b();
        }
    }
}
