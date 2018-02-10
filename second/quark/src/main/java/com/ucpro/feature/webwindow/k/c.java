package com.ucpro.feature.webwindow.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
public final class c extends AnimatorListenerAdapter {
    final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationRepeat(Animator animator) {
        d b = this.a.f;
        if (b.d) {
            b.d = false;
        } else {
            b.d = true;
        }
    }
}
