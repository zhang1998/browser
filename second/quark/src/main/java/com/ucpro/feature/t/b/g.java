package com.ucpro.feature.t.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class g extends AnimatorListenerAdapter {
    final /* synthetic */ n a;

    g(n nVar) {
        this.a = nVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.a.k = true;
        this.a.l = this.a.getMeasuredWidth();
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.k = false;
        if (!n.a(this.a, new f(this))) {
            this.a.l = 0;
            this.a.requestLayout();
        }
    }
}
