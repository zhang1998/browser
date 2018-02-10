package com.c.a.a;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class d {
    public float[] a = new float[4];

    public d() {
        this.a[3] = IPictureView.DEFAULT_MIN_SCALE;
    }

    public final d a(float f) {
        this.a[0] = f;
        return this;
    }

    public final d b(float f) {
        this.a[1] = f;
        return this;
    }

    public final d c(float f) {
        this.a[2] = f;
        return this;
    }

    public final String toString() {
        return "MDVector3D{x=" + this.a[0] + ", y=" + this.a[1] + ", z=" + this.a[2] + '}';
    }
}
