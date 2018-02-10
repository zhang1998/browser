package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ProGuard */
final class w extends AnimatorListenerAdapter {
    final /* synthetic */ l a;
    final /* synthetic */ View b;

    w(l lVar, View view) {
        this.a = lVar;
        this.b = view;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.c(this.b);
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.b(this.b);
    }

    public final void onAnimationStart(Animator animator) {
        this.a.a(this.b);
    }
}
