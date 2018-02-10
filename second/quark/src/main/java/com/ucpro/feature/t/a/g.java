package com.ucpro.feature.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.feature.t.f;

/* compiled from: ProGuard */
final class g extends AnimatorListenerAdapter {
    final /* synthetic */ f a;
    final /* synthetic */ a b;

    g(a aVar, f fVar) {
        this.b = aVar;
        this.a = fVar;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            this.a.b();
        }
        if (!(this.b.q == null || this.b.q.isRecycled())) {
            this.b.q.recycle();
        }
        this.b.setVisibility(8);
    }
}
