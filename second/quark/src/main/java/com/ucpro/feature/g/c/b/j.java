package com.ucpro.feature.g.c.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
public final class j extends AnimatorListenerAdapter {
    final /* synthetic */ i a;

    public j(i iVar) {
        this.a = iVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a.setVisibility(8);
    }
}
