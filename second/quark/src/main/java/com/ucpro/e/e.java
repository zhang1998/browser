package com.ucpro.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class e extends AnimatorListenerAdapter {
    final /* synthetic */ l a;

    e(l lVar) {
        this.a = lVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.b.f.b().b(this.a.a);
    }
}
