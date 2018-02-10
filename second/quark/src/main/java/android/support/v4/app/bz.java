package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
class bz implements AnimationListener {
    private AnimationListener a = null;
    private boolean b = false;
    private View c = null;

    public bz(View view, Animation animation) {
        if (view != null && animation != null) {
            this.c = view;
        }
    }

    public bz(View view, Animation animation, AnimationListener animationListener) {
        if (view != null && animation != null) {
            this.a = animationListener;
            this.c = view;
        }
    }

    @CallSuper
    public void onAnimationStart(Animation animation) {
        if (this.c != null) {
            this.b = ah.a(this.c, animation);
            if (this.b) {
                this.c.post(new ca(this));
            }
        }
        if (this.a != null) {
            this.a.onAnimationStart(animation);
        }
    }

    @CallSuper
    public void onAnimationEnd(Animation animation) {
        if (this.c != null && this.b) {
            this.c.post(new bh(this));
        }
        if (this.a != null) {
            this.a.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.a != null) {
            this.a.onAnimationRepeat(animation);
        }
    }
}
