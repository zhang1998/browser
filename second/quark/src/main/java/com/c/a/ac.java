package com.c.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.c.a.a.c;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class ac {
    private float[] a = new float[16];
    public float[] b = new float[16];
    public float[] c = new float[16];
    public float d = 0.0f;
    public float e = 0.0f;
    public int f = 2;
    public int g = 1;
    public float h;
    public float i;
    private float[] j = new float[16];
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    private final c p;
    private float[] q = new float[16];
    private float[] r = new float[16];
    private float[] s = new float[16];
    private float t;
    private float u;
    private boolean v = true;

    public ac(a aVar) {
        this.d = aVar.d;
        this.e = aVar.e;
        this.k = aVar.a;
        this.l = aVar.b;
        this.m = aVar.c;
        this.n = aVar.f;
        this.o = aVar.g;
        this.p = aVar.h;
        Matrix.setIdentityM(this.r, 0);
    }

    public void b(float f) {
        this.i = f;
        this.v = true;
    }

    public void a(float f) {
        this.h = f;
        this.v = true;
    }

    public final void a(d dVar) {
        a(dVar, c.a);
    }

    public final void a(d dVar, c cVar) {
        if (this.v) {
            float f = this.k;
            float f2 = this.l;
            float f3 = this.m;
            float f4 = this.n;
            float f5 = this.o;
            Matrix.setIdentityM(this.b, 0);
            Matrix.setLookAtM(this.b, 0, f, f2, f3, f4, f5, -1.0f, 0.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f);
            Matrix.setIdentityM(this.q, 0);
            Matrix.rotateM(this.q, 0, -this.i, IPictureView.DEFAULT_MIN_SCALE, 0.0f, 0.0f);
            Matrix.rotateM(this.q, 0, -this.h, 0.0f, IPictureView.DEFAULT_MIN_SCALE, 0.0f);
            Matrix.multiplyMM(this.s, 0, this.q, 0, this.p.b(), 0);
            System.arraycopy(this.s, 0, this.q, 0, 16);
            Matrix.multiplyMM(this.s, 0, this.r, 0, this.q, 0);
            System.arraycopy(this.s, 0, this.q, 0, 16);
            Matrix.multiplyMM(this.s, 0, this.b, 0, this.q, 0);
            System.arraycopy(this.s, 0, this.b, 0, 16);
            this.v = false;
        }
        Matrix.multiplyMM(this.a, 0, this.b, 0, cVar.b(), 0);
        Matrix.multiplyMM(this.j, 0, this.c, 0, this.a, 0);
        GLES20.glUniformMatrix4fv(dVar.a, 1, false, this.j, 0);
    }

    public final void a(int i, int i2) {
        this.f = i;
        this.g = i2;
        this.d = (((float) i) * IPictureView.DEFAULT_MIN_SCALE) / ((float) i2);
        a();
    }

    public void a() {
        Matrix.frustumM(this.c, 0, (-this.d) / 2.0f, this.d / 2.0f, -0.5f, 0.5f, this.e * 0.7f, 500.0f);
    }

    public void a(float[] fArr) {
        System.arraycopy(fArr, 0, this.r, 0, 16);
        this.v = true;
    }

    public final void b() {
        this.u = 0.0f;
        this.t = 0.0f;
        this.i = 0.0f;
        this.h = 0.0f;
        Matrix.setIdentityM(this.r, 0);
        this.v = true;
    }
}
