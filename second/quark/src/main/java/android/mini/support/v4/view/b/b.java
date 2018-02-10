package android.mini.support.v4.view.b;

import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
abstract class b implements Interpolator {
    private final float[] a;
    private final float b = (IPictureView.DEFAULT_MIN_SCALE / ((float) (this.a.length - 1)));

    public b(float[] fArr) {
        this.a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= IPictureView.DEFAULT_MIN_SCALE) {
            return IPictureView.DEFAULT_MIN_SCALE;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.a.length - 1)) * f), this.a.length - 2);
        float f2 = (f - (((float) min) * this.b)) / this.b;
        return ((this.a[min + 1] - this.a[min]) * f2) + this.a[min];
    }
}
