package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ProGuard */
final class ai implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout a;

    ai(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (!this.a.v) {
            this.a.a(null);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
