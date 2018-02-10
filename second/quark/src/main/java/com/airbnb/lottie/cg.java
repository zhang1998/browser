package com.airbnb.lottie;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class cg {
    final float a;
    final float b;

    cg(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    cg() {
        this(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE);
    }

    public final String toString() {
        return this.a + "x" + this.b;
    }
}
