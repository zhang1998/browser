package com.ucpro.base.c.b;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
final class e implements AnimationListener {
    final /* synthetic */ t a;

    e(t tVar) {
        this.a = tVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        Runnable yVar = new y(this);
        this.a.i.add(yVar);
        this.a.post(yVar);
    }
}
