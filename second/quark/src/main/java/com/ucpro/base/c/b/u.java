package com.ucpro.base.c.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class u extends AnimatorListenerAdapter {
    boolean a = false;
    final /* synthetic */ t b;

    u(t tVar) {
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
            Runnable nVar = new n(this);
            this.b.i.add(nVar);
            this.b.post(nVar);
        }
    }
}
