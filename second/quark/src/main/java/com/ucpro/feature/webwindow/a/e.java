package com.ucpro.feature.webwindow.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

/* compiled from: ProGuard */
final class e extends AnimatorListenerAdapter {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationEnd(Animator animator) {
        c cVar = this.a;
        if (cVar.a != null && cVar.a.isRunning()) {
            cVar.a.cancel();
        }
        if (this.a.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
    }
}
