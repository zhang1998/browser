package com.uc.weex.component.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ProGuard */
final class b implements AnimatorListener {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    b(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            super.setBackgroundColor(this.a);
            this.b.a = null;
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
