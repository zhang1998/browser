package com.airbnb.lottie;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class cj {
    final bl<?, Integer> a;
    private final Matrix b = new Matrix();
    private final bl<?, PointF> c;
    private final bl<?, PointF> d;
    private final bl<?, cg> e;
    private final bl<?, Float> f;

    cj(du duVar) {
        this.c = duVar.a.a();
        this.d = duVar.b.a();
        this.e = duVar.c.b();
        this.f = duVar.d.b();
        this.a = duVar.e.b();
    }

    final void a(cz czVar) {
        czVar.a(this.c);
        czVar.a(this.d);
        czVar.a(this.e);
        czVar.a(this.f);
        czVar.a(this.a);
    }

    final void a(bq bqVar) {
        this.c.a(bqVar);
        this.d.a(bqVar);
        this.e.a(bqVar);
        this.f.a(bqVar);
        this.a.a(bqVar);
    }

    final Matrix a() {
        this.b.reset();
        PointF pointF = (PointF) this.d.a();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.b.preTranslate(pointF.x, pointF.y);
        }
        float floatValue = ((Float) this.f.a()).floatValue();
        if (floatValue != 0.0f) {
            this.b.preRotate(floatValue);
        }
        cg cgVar = (cg) this.e.a();
        if (!(cgVar.a == IPictureView.DEFAULT_MIN_SCALE && cgVar.b == IPictureView.DEFAULT_MIN_SCALE)) {
            this.b.preScale(cgVar.a, cgVar.b);
        }
        pointF = (PointF) this.c.a();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.b.preTranslate(-pointF.x, -pointF.y);
        }
        return this.b;
    }
}
