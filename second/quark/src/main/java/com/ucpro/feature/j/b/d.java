package com.ucpro.feature.j.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
public final class d extends AnimatorListenerAdapter {
    final /* synthetic */ g a;
    final /* synthetic */ a b;

    public d(a aVar, g gVar) {
        this.b = aVar;
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
