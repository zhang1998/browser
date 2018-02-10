package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class e extends AnimatorListenerAdapter {
    boolean a = false;
    final /* synthetic */ CircularProgressView b;

    e(CircularProgressView circularProgressView) {
        this.b = circularProgressView;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.a) {
            this.b.a();
        }
    }
}
