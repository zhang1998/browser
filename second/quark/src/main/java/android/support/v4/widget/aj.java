package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class aj extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    aj(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(IPictureView.DEFAULT_MIN_SCALE - f);
    }
}
