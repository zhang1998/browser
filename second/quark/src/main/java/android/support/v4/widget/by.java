package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: ProGuard */
final class by extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    by(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.a((this.a.a + ((int) (((float) (this.a.b - this.a.a)) * f))) - this.a.z.getTop(), false);
    }
}
