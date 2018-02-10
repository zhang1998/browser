package com.uc.weex.component.h;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class x {
    float a = IPictureView.DEFAULT_MIN_SCALE;
    float b = 0.0f;
    float c = 0.0f;
    float d = 0.0f;
    float e = IPictureView.DEFAULT_MIN_SCALE;
    float f = 0.0f;
    float g = 0.0f;
    float h = 0.0f;
    float i = -1.0f;
    float j = -1.0f;

    public x() {
        a(IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f);
    }

    public final x a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a = f;
        this.b = f2;
        this.d = f3;
        this.e = f4;
        this.c = f5;
        this.f = f6;
        return this;
    }

    public final x a(float f, float f2, float f3, float f4) {
        return a((this.d * 0.0f) + (this.a * f), (this.e * 0.0f) + (this.b * f), (this.d * f2) + (this.a * 0.0f), (this.e * f2) + (this.b * 0.0f), this.c + ((this.a * f3) + (this.d * f4)), this.f + ((this.b * f3) + (this.e * f4)));
    }

    public final x a(float f, float f2) {
        return a(f, f2, 0.0f, 0.0f);
    }

    public final x a(float f, float f2, float f3) {
        float f4 = (float) ((((double) f) * 3.141592653589793d) / 180.0d);
        float sin = (float) Math.sin((double) f4);
        f4 = (float) Math.cos((double) f4);
        a(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE, f2, f3);
        return a((this.a * f4) - (this.b * sin), (this.a * sin) + (this.b * f4), (this.d * f4) - (this.e * sin), (sin * this.d) + (f4 * this.e), this.c, this.f).a(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE, -f2, -f3);
    }
}
