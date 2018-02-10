package com.c.a.b.a;

import android.opengl.Matrix;
import com.b.a.a.a.a.a;
import com.b.a.a.a.a.c;
import com.b.a.a.a.a.d;
import com.c.a.ac;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        if (this.a.g) {
            float f;
            synchronized (this.a.i) {
                int i;
                double toSeconds = ((double) TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - this.a.k)) + 0.016666666666666666d;
                c b = this.a.i;
                a aVar = b.f;
                aVar.a(b.c);
                aVar.a(-toSeconds);
                d dVar = b.d;
                com.b.a.a.a.a.b.a(aVar, dVar);
                d dVar2 = b.e;
                d.a(dVar, b.b, dVar2);
                for (i = 0; i < 3; i++) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        b.a[(i2 * 4) + i] = dVar2.a(i, i2);
                    }
                }
                b.a[3] = 0.0d;
                b.a[7] = 0.0d;
                b.a[11] = 0.0d;
                b.a[12] = 0.0d;
                b.a[13] = 0.0d;
                b.a[14] = 0.0d;
                b.a[15] = 1.0d;
                double[] dArr = b.a;
                for (i = 0; i < dArr.length; i++) {
                    this.a.d[i] = (float) dArr[i];
                }
            }
            switch (this.a.b) {
                case 0:
                    f = 0.0f;
                    break;
                case 1:
                    f = 90.0f;
                    break;
                case 2:
                    f = 180.0f;
                    break;
                case 3:
                    f = 270.0f;
                    break;
                default:
                    f = 0.0f;
                    break;
            }
            Matrix.setRotateEulerM(this.a.e, 0, 0.0f, 0.0f, -f);
            Matrix.setRotateEulerM(this.a.f, 0, -90.0f, 0.0f, f);
            Matrix.multiplyMM(this.a.c, 0, this.a.e, 0, this.a.d, 0);
            Matrix.multiplyMM(this.a.d, 0, this.a.c, 0, this.a.f, 0);
            for (ac a : this.a.a()) {
                a.a(this.a.d);
            }
        }
    }
}
