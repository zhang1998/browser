package com.ucpro.ui.widget.tablayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class m extends AnimatorListenerAdapter {
    final /* synthetic */ t a;
    final /* synthetic */ r b;

    m(r rVar, t tVar) {
        this.b = rVar;
        this.a = tVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a();
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
