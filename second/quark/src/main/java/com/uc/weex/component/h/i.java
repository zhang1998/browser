package com.uc.weex.component.h;

import android.graphics.Matrix;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class i {
    private static final float[] c = new float[9];
    private static final float[] d = new float[9];
    Matrix a = new Matrix();
    final float b = com.taobao.weex.i.e().getResources().getDisplayMetrics().density;

    public final void a(float[] fArr) {
        if (fArr != null) {
            for (int i = 0; i < fArr.length; i++) {
                c[i] = fArr[i];
            }
            d[0] = c[0];
            d[1] = c[2];
            d[2] = c[4] * this.b;
            d[3] = c[1];
            d[4] = c[3];
            d[5] = c[5] * this.b;
            d[6] = 0.0f;
            d[7] = 0.0f;
            d[8] = IPictureView.DEFAULT_MIN_SCALE;
            if (this.a == null) {
                this.a = new Matrix();
            }
            this.a.setValues(d);
            return;
        }
        this.a = null;
    }
}
