package android.support.v4.view.a;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class a implements Interpolator {
    private final float[] a;
    private final float[] b;

    private a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.a = new float[i];
        this.b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.a[i2] = fArr[0];
            this.b[i2] = fArr[1];
        }
    }

    public a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE);
        this(path);
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= IPictureView.DEFAULT_MIN_SCALE) {
            return IPictureView.DEFAULT_MIN_SCALE;
        }
        int length = this.a.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.a[length] - this.a[i];
        if (f2 == 0.0f) {
            return this.b[i];
        }
        float f3 = (f - this.a[i]) / f2;
        f2 = this.b[i];
        return (f3 * (this.b[length] - f2)) + f2;
    }
}
