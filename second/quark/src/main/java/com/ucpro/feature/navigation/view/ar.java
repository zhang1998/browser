package com.ucpro.feature.navigation.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
final class ar implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ v c;

    ar(v vVar, Animation animation, Runnable runnable) {
        this.c = vVar;
        this.a = animation;
        this.b = runnable;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.c.b.remove(this.a);
        v vVar = this.c;
        Runnable runnable = this.b;
        if (vVar.b.size() == 0 && runnable != null) {
            runnable.run();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
