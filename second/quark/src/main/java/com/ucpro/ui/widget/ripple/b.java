package com.ucpro.ui.widget.ripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class b extends AnimatorListenerAdapter {
    final /* synthetic */ Ripple a;

    b(Ripple ripple) {
        this.a = ripple;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.removeSelf();
    }
}
