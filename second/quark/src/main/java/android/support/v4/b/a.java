package android.support.v4.b;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class a {
    private static final ThreadLocal<double[]> a = new ThreadLocal();

    public static int a(@ColorInt int i, @ColorInt int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha) * (255 - alpha2)) / 255);
        return Color.argb(i3, a(Color.red(i), alpha2, Color.red(i2), alpha, i3), a(Color.green(i), alpha2, Color.green(i2), alpha, i3), a(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    private static double c(@ColorInt int i, @ColorInt int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        if (Color.alpha(i) < 255) {
            i = a(i, i2);
        }
        double a = a(i) + 0.05d;
        double a2 = a(i2) + 0.05d;
        return Math.max(a, a2) / Math.min(a, a2);
    }

    public static int a(@ColorInt int i, @ColorInt int i2, float f) {
        int i3 = 0;
        int i4 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        } else if (c(b(i, 255), i2) < ((double) f)) {
            return -1;
        } else {
            int i5 = 0;
            while (i5 <= 10 && i4 - i3 > 1) {
                int i6 = (i3 + i4) / 2;
                if (c(b(i, i6), i2) >= ((double) f)) {
                    i4 = i6;
                    i6 = i3;
                }
                i5++;
                i3 = i6;
            }
            return i4;
        }
    }

    public static void a(@IntRange(from = 0, to = 255) int i, @IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @NonNull float[] fArr) {
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float max = Math.max(f, Math.max(f2, f3));
        float min = Math.min(f, Math.min(f2, f3));
        float f4 = max - min;
        float f5 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            f = 0.0f;
        } else {
            if (max == f) {
                f = ((f2 - f3) / f4) % 6.0f;
            } else if (max == f2) {
                f = ((f3 - f) / f4) + 2.0f;
            } else {
                f = ((f - f2) / f4) + 4.0f;
            }
            f2 = f4 / (IPictureView.DEFAULT_MIN_SCALE - Math.abs((2.0f * f5) - IPictureView.DEFAULT_MIN_SCALE));
        }
        f = (f * 60.0f) % 360.0f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        fArr[0] = a(f, 360.0f);
        fArr[1] = a(f2, (float) IPictureView.DEFAULT_MIN_SCALE);
        fArr[2] = a(f5, (float) IPictureView.DEFAULT_MIN_SCALE);
    }

    public static void a(@ColorInt int i, @NonNull float[] fArr) {
        a(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    @ColorInt
    public static int b(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static float a(float f, float f2) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f <= f2 ? f : f2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private static double a(@ColorInt int i) {
        double[] dArr = (double[]) a.get();
        if (dArr == null) {
            dArr = new double[3];
            a.set(dArr);
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) red) / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        d = ((double) green) / 255.0d;
        double pow2 = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        d = ((double) blue) / 255.0d;
        d = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        dArr[0] = 100.0d * (((0.4124d * pow) + (0.3576d * pow2)) + (0.1805d * d));
        dArr[1] = 100.0d * (((0.2126d * pow) + (0.7152d * pow2)) + (0.0722d * d));
        dArr[2] = ((d * 0.9505d) + ((pow2 * 0.1192d) + (pow * 0.0193d))) * 100.0d;
        return dArr[1] / 100.0d;
    }
}
