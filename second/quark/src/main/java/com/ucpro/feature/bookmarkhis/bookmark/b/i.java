package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class i extends AnimatorListenerAdapter {
    final /* synthetic */ j a;

    i(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.setVisibility(8);
    }
}
