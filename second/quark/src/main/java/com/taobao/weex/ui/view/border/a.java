package com.taobao.weex.ui.view.border;

import android.graphics.PointF;
import android.graphics.RectF;
import android.mini.support.annotation.NonNull;
import com.taobao.weex.c.b.o;

/* compiled from: ProGuard */
abstract class a {
    final float a;
    final float b;
    final float c;
    final RectF d;

    @NonNull
    protected abstract PointF c();

    @NonNull
    protected abstract PointF d();

    @NonNull
    protected abstract PointF f();

    protected abstract float g();

    @NonNull
    protected abstract PointF h();

    @NonNull
    protected abstract PointF i();

    @NonNull
    protected abstract RectF j();

    @NonNull
    protected abstract RectF k();

    a(float f, float f2, float f3, @NonNull RectF rectF) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = rectF;
    }

    final boolean a() {
        return this.a > 0.0f && !o.a(0.0f, this.a);
    }

    @NonNull
    final PointF b() {
        if (a()) {
            return c();
        }
        return d();
    }

    @NonNull
    final PointF e() {
        if (a()) {
            return f();
        }
        return d();
    }
}
