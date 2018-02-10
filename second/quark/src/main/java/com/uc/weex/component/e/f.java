package com.uc.weex.component.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class f extends AnimatorListenerAdapter {
    boolean a = false;
    final /* synthetic */ q b;
    final /* synthetic */ a c;
    final /* synthetic */ j d;

    f(j jVar, q qVar, a aVar) {
        this.d = jVar;
        this.b = qVar;
        this.c = aVar;
    }

    public final void onAnimationCancel(Animator animator) {
        if (!this.a) {
            this.a = true;
            this.d.post(this.d.l);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.a) {
            Runnable eVar = new e(this);
            this.d.f.add(eVar);
            this.d.post(eVar);
        }
    }
}
