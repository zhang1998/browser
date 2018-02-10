package android.mini.support.v4.app;

import android.mini.support.annotation.CallSuper;
import android.mini.support.v4.c.a;
import android.mini.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
class z implements AnimationListener {
    private AnimationListener a;
    private boolean b;
    private View c;

    public z(View view, Animation animation) {
        if (view != null && animation != null) {
            this.c = view;
        }
    }

    public z(View view, Animation animation, AnimationListener animationListener) {
        if (view != null && animation != null) {
            this.a = animationListener;
            this.c = view;
            this.b = true;
        }
    }

    @CallSuper
    public void onAnimationStart(Animation animation) {
        if (this.a != null) {
            this.a.onAnimationStart(animation);
        }
    }

    @CallSuper
    public void onAnimationEnd(Animation animation) {
        if (this.c != null && this.b) {
            if (ViewCompat.r(this.c) || a.a()) {
                this.c.post(new y(this));
            } else {
                ViewCompat.a(this.c, 0, null);
            }
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
