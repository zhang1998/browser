package com.uc.weex.component.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class h extends AnimatorListenerAdapter {
    boolean a = false;
    final /* synthetic */ j b;

    h(j jVar) {
        this.b = jVar;
    }

    public final void onAnimationCancel(Animator animator) {
        if (!this.a) {
            this.a = true;
            this.b.post(this.b.l);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.a) {
            Runnable gVar = new g(this);
            this.b.f.add(gVar);
            this.b.post(gVar);
        }
    }
}
