package com.c.a;

import android.opengl.Matrix;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class i extends ac {
    private i(a aVar) {
        super(aVar);
    }

    public final void a(float f) {
    }

    public final void b(float f) {
    }

    public final void a(float[] fArr) {
    }

    protected final void a() {
        Matrix.orthoM(this.c, 0, -1.0f, IPictureView.DEFAULT_MIN_SCALE, -1.0f, IPictureView.DEFAULT_MIN_SCALE, this.e * 0.7f, 500.0f);
    }
}
