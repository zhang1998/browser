package android.support.a.a;

import android.graphics.Path;
import android.util.Log;

/* compiled from: ProGuard */
public final class h {
    char a;
    float[] b;

    private h(char c, float[] fArr) {
        this.a = c;
        this.b = fArr;
    }

    private h(h hVar) {
        this.a = hVar.a;
        this.b = a.a(hVar.b, hVar.b.length);
    }

    static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double toRadians;
        double cos;
        double sin;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        Path path2 = path;
        while (true) {
            toRadians = Math.toRadians((double) f7);
            cos = Math.cos(toRadians);
            sin = Math.sin(toRadians);
            d = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
            d2 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
            d3 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
            d4 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
            d5 = d - d3;
            d6 = d2 - d4;
            d7 = (d + d3) / 2.0d;
            double d10 = (d2 + d4) / 2.0d;
            d8 = (d5 * d5) + (d6 * d6);
            if (d8 != 0.0d) {
                d9 = (1.0d / d8) - 0.25d;
                if (d9 >= 0.0d) {
                    break;
                }
                Log.w("PathParser", "Points are too far apart " + d8);
                float sqrt = (float) (Math.sqrt(d8) / 1.99999d);
                f5 *= sqrt;
                f6 *= sqrt;
            } else {
                Log.w("PathParser", " Points are coincident");
                return;
            }
        }
        d8 = Math.sqrt(d9);
        d5 *= d8;
        d6 *= d8;
        if (z == z2) {
            d6 = d7 - d6;
            d5 += d10;
        } else {
            d6 += d7;
            d5 = d10 - d5;
        }
        d7 = Math.atan2(d2 - d5, d - d6);
        d3 = Math.atan2(d4 - d5, d3 - d6) - d7;
        if (z2 != (d3 >= 0.0d)) {
            if (d3 > 0.0d) {
                d3 -= 6.283185307179586d;
            } else {
                d3 += 6.283185307179586d;
            }
        }
        d6 *= (double) f5;
        d = ((double) f6) * d5;
        a(path2, (d6 * cos) - (d * sin), (d6 * sin) + (cos * d), (double) f5, (double) f6, (double) f, (double) f2, toRadians, d7, d3);
    }

    private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
        cos2 = (cos2 * (d4 * cos)) + (sin2 * ((-d3) * sin));
        double d11 = d9 / ((double) ceil);
        int i = 0;
        while (i < ceil) {
            double d12 = d8 + d11;
            sin2 = Math.sin(d12);
            double cos3 = Math.cos(d12);
            double d13 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin2);
            double d14 = ((d4 * cos) * sin2) + (((d3 * sin) * cos3) + d2);
            double d15 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos3);
            cos3 = (cos3 * (d4 * cos)) + (sin2 * ((-d3) * sin));
            sin2 = Math.tan((d12 - d8) / 2.0d);
            sin2 = ((Math.sqrt((sin2 * (3.0d * sin2)) + 4.0d) - 1.0d) * Math.sin(d12 - d8)) / 3.0d;
            Path path2 = path;
            path2.cubicTo((float) ((d10 * sin2) + d5), (float) (d6 + (cos2 * sin2)), (float) (d13 - (sin2 * d15)), (float) (d14 - (sin2 * cos3)), (float) d13, (float) d14);
            d10 = d15;
            d8 = d12;
            i++;
            d6 = d14;
            d5 = d13;
            cos2 = cos3;
        }
    }
}
