package com.taobao.weex.ui.view.border;

import android.graphics.PointF;
import android.graphics.RectF;
import android.mini.support.annotation.NonNull;

/* compiled from: ProGuard */
final class i extends a {
    i(float f, float f2, float f3, @NonNull RectF rectF) {
        super(f, f2, f3, rectF);
    }

    protected final float g() {
        return 225.0f;
    }

    @NonNull
    protected final RectF j() {
        return new RectF(this.b / 2.0f, this.c / 2.0f, (this.a * 2.0f) - (this.b / 2.0f), (this.a * 2.0f) - (this.c / 2.0f));
    }

    @NonNull
    protected final RectF k() {
        return new RectF(this.a / 2.0f, this.a / 2.0f, this.a * 1.5f, this.a * 1.5f);
    }

    @NonNull
    protected final PointF c() {
        return new PointF(this.b / 2.0f, this.a);
    }

    @NonNull
    protected final PointF d() {
        return new PointF(this.b / 2.0f, this.c / 2.0f);
    }

    @NonNull
    protected final PointF h() {
        PointF d = d();
        d.x = 0.0f;
        return d;
    }

    @NonNull
    protected final PointF i() {
        PointF d = d();
        d.y = 0.0f;
        return d;
    }

    @NonNull
    protected final PointF f() {
        return new PointF(this.a, this.c / 2.0f);
    }
}
