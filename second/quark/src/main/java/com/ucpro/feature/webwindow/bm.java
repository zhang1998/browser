package com.ucpro.feature.webwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class bm extends AnimatorListenerAdapter {
    final /* synthetic */ ab a;

    bm(ab abVar) {
        this.a = abVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a.getAddressBarState() == 0) {
            this.a.setWebViewState(1);
            this.a.h();
        }
    }
}
