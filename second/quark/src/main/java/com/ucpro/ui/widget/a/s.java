package com.ucpro.ui.widget.a;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class s {
    int a;
    float b;
    float c;
    long d;
    long e;
    int f;
    int g;
    long h;
    float i;
    int j;
    private int k;

    final float a(long j) {
        if (j < this.d) {
            return 0.0f;
        }
        if (this.h < 0 || j < this.h) {
            return e.a(((float) (j - this.d)) / ((float) this.k), 0.0f, IPictureView.DEFAULT_MIN_SCALE) * 0.5f;
        }
        long j2 = j - this.h;
        return (e.a(((float) j2) / ((float) this.j), 0.0f, IPictureView.DEFAULT_MIN_SCALE) * this.i) + (IPictureView.DEFAULT_MIN_SCALE - this.i);
    }
}
