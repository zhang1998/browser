package com.ucpro.feature.webwindow.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
final class h extends AnimatorListenerAdapter {
    final /* synthetic */ g a;
    final /* synthetic */ f b;

    h(f fVar, g gVar) {
        this.b = fVar;
        this.a = gVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            this.a.a();
        }
    }
}
