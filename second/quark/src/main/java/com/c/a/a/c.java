package com.c.a.a;

import android.opengl.Matrix;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.imagecodec.export.IPictureView;

@KeepForSdk
/* compiled from: ProGuard */
public final class c {
    public static final c a = new c();
    public float b = 0.0f;
    private float[] c = new float[16];
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;

    private c() {
    }

    public static c a() {
        return new c();
    }

    public final String toString() {
        return "MDPosition{mX=" + this.d + ", mY=" + this.e + ", mZ=" + this.b + ", mAngleX=" + this.f + ", mAngleY=" + this.g + ", mAngleZ=" + this.h + ", mPitch=" + this.i + ", mYaw=" + this.j + ", mRoll=" + this.k + '}';
    }

    public final float[] b() {
        Matrix.setIdentityM(this.c, 0);
        Matrix.rotateM(this.c, 0, this.g, IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f);
        Matrix.rotateM(this.c, 0, this.f, 0.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f);
        Matrix.rotateM(this.c, 0, this.h, 0.0f, 0.0f, IPictureView.DEFAULT_MIN_SCALE);
        Matrix.translateM(this.c, 0, this.d, this.e, this.b);
        Matrix.rotateM(this.c, 0, this.j, IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f);
        Matrix.rotateM(this.c, 0, this.i, 0.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f);
        Matrix.rotateM(this.c, 0, this.k, 0.0f, 0.0f, IPictureView.DEFAULT_MIN_SCALE);
        return this.c;
    }
}
