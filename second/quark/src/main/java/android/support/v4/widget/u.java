package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class u extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    u(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        int j;
        if (this.a.M) {
            j = (int) this.a.I;
        } else {
            j = (int) (this.a.I - ((float) Math.abs(this.a.b)));
        }
        this.a.a((((int) (((float) (j - this.a.a)) * f)) + this.a.a) - this.a.z.getTop(), false);
        this.a.C.a(IPictureView.DEFAULT_MIN_SCALE - f);
    }
}
