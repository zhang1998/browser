package com.c.a.c;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.c.a.e.d;
import com.c.a.j;

/* compiled from: ProGuard */
public class a extends b {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
    private Surface c;
    private SurfaceTexture d;
    private j e;

    public a(j jVar) {
        this.e = jVar;
    }

    public final void a() {
        this.e = null;
    }

    public final void b() {
        Object obj;
        super.b();
        int i = this.b;
        if (i == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && this.d == null) {
            this.d = new SurfaceTexture(i);
            this.c = new Surface(this.d);
            if (this.e != null) {
                this.e.onSurfaceReady(this.c);
            }
        }
    }

    public final void c() {
        if (this.d != null) {
            this.d.release();
        }
        this.d = null;
        if (this.c != null) {
            this.c.release();
        }
        this.c = null;
    }

    protected final int d() {
        int[] iArr = new int[1];
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, iArr, 0);
        d.a("Texture generate");
        GLES20.glBindTexture(36197, iArr[0]);
        d.a("Texture bind");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public final boolean a(com.c.a.d dVar) {
        int i = this.b;
        if (i == 0) {
            int i2 = 1;
        } else {
            boolean z = false;
        }
        if (i2 != 0 || this.d == null) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        this.d.updateTexImage();
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(dVar.b, 0);
        float[] fArr = new float[16];
        this.d.getTransformMatrix(fArr);
        if (a || dVar.c != -1) {
            GLES20.glUniformMatrix4fv(dVar.c, 1, false, fArr, 0);
            return true;
        }
        throw new AssertionError();
    }
}
