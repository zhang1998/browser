package com.ucpro.feature.t.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
final class e extends AnimatorListenerAdapter {
    final /* synthetic */ g a;
    final /* synthetic */ n b;

    e(n nVar, g gVar) {
        this.b = nVar;
        this.a = gVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a();
    }
}
