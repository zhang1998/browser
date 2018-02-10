package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.Closeable;

/* compiled from: ProGuard */
final class dn {
    private static final PathMeasure a = new PathMeasure();
    private static final Path b = new Path();
    private static final Path c = new Path();
    private static DisplayMetrics d;
    private static final float[] e = new float[4];
    private static final float f = ((float) Math.sqrt(2.0d));

    static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF3.length() == 0.0f || pointF4 == null || pointF4.length() == 0.0f) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    static int a(Context context) {
        if (d == null) {
            d = new DisplayMetrics();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(d);
        return d.widthPixels;
    }

    static int b(Context context) {
        if (d == null) {
            d = new DisplayMetrics();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(d);
        return d.heightPixels;
    }

    static float a(Matrix matrix) {
        e[0] = 0.0f;
        e[1] = 0.0f;
        e[2] = f;
        e[3] = f;
        matrix.mapPoints(e);
        return ((float) Math.hypot((double) (e[2] - e[0]), (double) (e[3] - e[1]))) / 2.0f;
    }

    static void a(Path path, @Nullable bu buVar) {
        if (buVar != null) {
            a(path, ((Float) buVar.b.a()).floatValue() / 100.0f, ((Float) buVar.c.a()).floatValue() / 100.0f, ((Float) buVar.d.a()).floatValue() / 360.0f);
        }
    }

    static void a(Path path, float f, float f2, float f3) {
        if (f == f2) {
            path.reset();
        }
        a.setPath(path, false);
        float length = a.getLength();
        float f4 = length * f;
        float f5 = length * f2;
        float min = Math.min(f4, f5);
        f5 = Math.max(f4, f5);
        float f6 = f3 * length;
        f4 = min + f6;
        f5 += f6;
        if (f4 > length && f5 > length) {
            f4 %= length;
            f5 %= length;
        }
        if (f4 > f5) {
            f4 -= length;
        }
        b.reset();
        a.getSegment(f4, f5, b, true);
        if (f5 > length) {
            c.reset();
            a.getSegment(0.0f, f5 % length, c, true);
            b.addPath(c);
        } else if (f4 < 0.0f) {
            c.reset();
            a.getSegment(f4 + length, length, c, true);
            b.addPath(c);
        }
        path.set(b);
    }
}
