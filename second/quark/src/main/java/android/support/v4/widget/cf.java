package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: ProGuard */
final class cf extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    cf(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(f);
    }
}
