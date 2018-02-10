package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
final class ca implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout a;

    ca(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.f) {
            this.a.C.setAlpha(255);
            this.a.C.start();
            if (this.a.J && this.a.e != null) {
                this.a.e;
            }
            this.a.p = this.a.z.getTop();
            return;
        }
        this.a.a();
    }
}
