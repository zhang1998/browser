package com.taobao.weex.ui.view.border;

import android.graphics.PointF;
import android.graphics.RectF;
import android.mini.support.annotation.NonNull;

/* compiled from: ProGuard */
final class h extends a {
    h(float f, float f2, float f3, @NonNull RectF rectF) {
        super(f, f2, f3, rectF);
    }

    protected final float g() {
        return 45.0f;
    }

    @NonNull
    protected final RectF j() {
        return new RectF(this.d.width() - ((this.a * 2.0f) - (this.b / 2.0f)), this.d.height() - ((this.a * 2.0f) - (this.c / 2.0f)), this.d.width() - (this.b / 2.0f), this.d.height() - (this.c / 2.0f));
    }

    @NonNull
    protected final RectF k() {
        return new RectF(this.d.width() - (this.a * 1.5f), this.d.height() - (this.a * 1.5f), this.d.width() - (this.a / 2.0f), this.d.height() - (this.a / 2.0f));
    }

    @NonNull
    protected final PointF c() {
        return new PointF(this.d.width() - (this.b / 2.0f), this.d.height() - this.a);
    }

    @NonNull
    protected final PointF d() {
        return new PointF(this.d.width() - (this.b / 2.0f), this.d.height() - (this.c / 2.0f));
    }

    @NonNull
    protected final PointF h() {
        PointF d = d();
        d.x = this.d.right;
        return d;
    }

    @NonNull
    protected final PointF i() {
        PointF d = d();
        d.y = this.d.height();
        return d;
    }

    @NonNull
    protected final PointF f() {
        return new PointF(this.d.width() - this.a, this.d.height() - (this.c / 2.0f));
    }
}
