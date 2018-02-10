package android.support.v4.widget;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class an {
    int a;
    int b;
    float c;
    float d;
    long e = Long.MIN_VALUE;
    long f = 0;
    int g = 0;
    int h = 0;
    long i = -1;
    float j;
    int k;

    final float a(long j) {
        if (j < this.e) {
            return 0.0f;
        }
        if (this.i < 0 || j < this.i) {
            return au.a(((float) (j - this.e)) / ((float) this.a), 0.0f, IPictureView.DEFAULT_MIN_SCALE) * 0.5f;
        }
        long j2 = j - this.i;
        return (au.a(((float) j2) / ((float) this.k), 0.0f, IPictureView.DEFAULT_MIN_SCALE) * this.j) + (IPictureView.DEFAULT_MIN_SCALE - this.j);
    }
}
