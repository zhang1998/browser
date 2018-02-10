package android.support.v7.widget;

import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class bq implements Interpolator {
    bq() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - IPictureView.DEFAULT_MIN_SCALE;
        return (f2 * (((f2 * f2) * f2) * f2)) + IPictureView.DEFAULT_MIN_SCALE;
    }
}
