package com.ucpro.base.c.b;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
final class aa implements AnimationListener {
    final /* synthetic */ t a;

    aa(t tVar) {
        this.a = tVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        Runnable zVar = new z(this);
        this.a.i.add(zVar);
        this.a.post(zVar);
    }
}
