package com.ucpro.feature.downloadpage.e.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: ProGuard */
final class f extends AnimatorListenerAdapter {
    final /* synthetic */ t a;

    f(t tVar) {
        this.a = tVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.i = true;
        ((LayoutParams) this.a.l.getLayoutParams()).rightMargin = this.a.C;
        this.a.requestLayout();
    }
}
