package com.ucpro.feature.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
public final class t extends AnimatorListenerAdapter {
    final /* synthetic */ g a;
    final /* synthetic */ u b;

    public t(u uVar, g gVar) {
        this.b = uVar;
        this.a = gVar;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.a != null) {
            this.a.b();
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            this.a.a();
        }
    }
}
