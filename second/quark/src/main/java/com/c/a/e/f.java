package com.c.a.e;

import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.c.a.a.d;
import com.c.a.ac;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class f {
    private static float[] a = new float[16];

    public static void a(SensorEvent sensorEvent, int i, float[] fArr) {
        float[] fArr2 = sensorEvent.values;
        switch (i) {
            case 0:
            case 2:
                SensorManager.getRotationMatrixFromVector(fArr, fArr2);
                break;
            case 1:
                SensorManager.getRotationMatrixFromVector(a, fArr2);
                SensorManager.remapCoordinateSystem(a, 2, 129, fArr);
                break;
            case 3:
                SensorManager.getRotationMatrixFromVector(a, fArr2);
                SensorManager.remapCoordinateSystem(a, 130, 1, fArr);
                break;
        }
        Matrix.rotateM(fArr, 0, 90.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new RuntimeException(str);
        }
    }

    public static void a(double d, double d2, double d3, PointF pointF) {
        double d4 = ((1.0d - d) - d2) - d3;
        if (((double) pointF.x) != 0.0d || ((double) pointF.y) != 0.0d) {
            double d5 = (((double) pointF.x) - 0.0d) / 1.0d;
            double d6 = (((double) pointF.y) - 0.0d) / 1.0d;
            double sqrt = Math.sqrt((d5 * d5) + (d6 * d6));
            d4 = Math.abs(sqrt / ((d4 + (((((d * sqrt) * sqrt) * sqrt) + ((d2 * sqrt) * sqrt)) + (d3 * sqrt))) * sqrt));
            pointF.set((float) (((d5 * d4) * 1.0d) + 0.0d), (float) (((d4 * d6) * 1.0d) + 0.0d));
        }
    }

    public static com.c.a.a.f a(float f, float f2, ac acVar) {
        d dVar = new d();
        float[] fArr = acVar.c;
        dVar.a((-(((2.0f * f) / ((float) acVar.f)) - IPictureView.DEFAULT_MIN_SCALE)) / fArr[0]);
        dVar.b((((2.0f * f2) / ((float) acVar.g)) - IPictureView.DEFAULT_MIN_SCALE) / fArr[5]);
        dVar.c(IPictureView.DEFAULT_MIN_SCALE);
        float[] fArr2 = new float[16];
        if (!Matrix.invertM(fArr2, 0, acVar.b, 0)) {
            return null;
        }
        d dVar2 = new d();
        d dVar3 = new d();
        dVar2.a(((dVar.a[0] * fArr2[0]) + (dVar.a[1] * fArr2[4])) + (dVar.a[2] * fArr2[8]));
        dVar2.b(((dVar.a[0] * fArr2[1]) + (dVar.a[1] * fArr2[5])) + (dVar.a[2] * fArr2[9]));
        dVar2.c((dVar.a[2] * fArr2[10]) + ((dVar.a[0] * fArr2[2]) + (dVar.a[1] * fArr2[6])));
        dVar3.a(fArr2[12]);
        dVar3.b(fArr2[13]);
        dVar3.c(fArr2[14]);
        return new com.c.a.a.f(dVar3, dVar2);
    }
}
