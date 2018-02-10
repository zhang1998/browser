package com.ucpro.base.c.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class d extends AnimatorListenerAdapter {
    boolean a = false;
    final /* synthetic */ t b;

    d(t tVar) {
        this.b = tVar;
    }

    public final void onAnimationCancel(Animator animator) {
        if (!this.a) {
            this.a = true;
            this.b.post(this.b.k);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.a) {
            Runnable adVar = new ad(this);
            this.b.i.add(adVar);
            this.b.post(adVar);
        }
    }
}
