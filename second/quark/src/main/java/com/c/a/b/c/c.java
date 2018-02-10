package com.c.a.b.c;

import android.graphics.RectF;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class c {
    float a;
    float b = IPictureView.DEFAULT_MIN_SCALE;
    float c = IPictureView.DEFAULT_MIN_SCALE;
    public float d = IPictureView.DEFAULT_MIN_SCALE;
    public float e = IPictureView.DEFAULT_MIN_SCALE;
    private RectF f;
    private int g;

    public c(int i, RectF rectF) {
        this.g = i;
        this.f = rectF;
    }

    public final float a() {
        return this.f.width() / this.f.height();
    }

    public final void b() {
        float f = this.a;
        float a = a();
        switch (this.g) {
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY /*208*/:
                if (a > f) {
                    this.b = f * IPictureView.DEFAULT_MIN_SCALE;
                    this.c = IPictureView.DEFAULT_MIN_SCALE;
                    this.d = IPictureView.DEFAULT_MIN_SCALE * a;
                    this.e = IPictureView.DEFAULT_MIN_SCALE;
                    return;
                }
                this.b = IPictureView.DEFAULT_MIN_SCALE;
                this.c = IPictureView.DEFAULT_MIN_SCALE / f;
                this.d = IPictureView.DEFAULT_MIN_SCALE;
                this.e = IPictureView.DEFAULT_MIN_SCALE / a;
                return;
            case 209:
                this.e = IPictureView.DEFAULT_MIN_SCALE;
                this.d = IPictureView.DEFAULT_MIN_SCALE;
                this.c = IPictureView.DEFAULT_MIN_SCALE;
                this.b = IPictureView.DEFAULT_MIN_SCALE;
                return;
            default:
                if (f > a) {
                    this.b = f * IPictureView.DEFAULT_MIN_SCALE;
                    this.c = IPictureView.DEFAULT_MIN_SCALE;
                    this.d = IPictureView.DEFAULT_MIN_SCALE * a;
                    this.e = IPictureView.DEFAULT_MIN_SCALE;
                    return;
                }
                this.b = IPictureView.DEFAULT_MIN_SCALE;
                this.c = IPictureView.DEFAULT_MIN_SCALE / f;
                this.d = IPictureView.DEFAULT_MIN_SCALE;
                this.e = IPictureView.DEFAULT_MIN_SCALE / a;
                return;
        }
    }
}
