package com.ucpro.feature.z.h.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class p extends AnimatorListenerAdapter {
    final /* synthetic */ float a;
    final /* synthetic */ h b;

    p(h hVar, float f) {
        this.b = hVar;
        this.a = f;
    }

    public final void onAnimationStart(Animator animator) {
        this.b.q = 3;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.b.q == 3) {
            this.b.c.setVisibility(8);
            this.b.b.setY(this.a);
            this.b.b.setVisibility(0);
            this.b.q = 0;
        }
        if (this.b.w != null) {
            this.b.w.a();
            this.b.w = null;
        }
    }
}
