package com.ucpro.feature.bookmarkhis.bookmark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class h extends AnimatorListenerAdapter {
    final /* synthetic */ m a;

    h(m mVar) {
        this.a = mVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.g.setVisibility(8);
    }
}
