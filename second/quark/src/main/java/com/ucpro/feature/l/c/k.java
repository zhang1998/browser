package com.ucpro.feature.l.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
final class k extends AnimatorListenerAdapter {
    final /* synthetic */ g a;
    final /* synthetic */ i b;

    k(i iVar, g gVar) {
        this.b = iVar;
        this.a = gVar;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void onAnimationStart(Animator animator) {
        if (this.a != null) {
            this.a.b();
        }
    }
}
