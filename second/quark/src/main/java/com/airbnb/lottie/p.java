package com.airbnb.lottie;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.uc.imagecodec.export.IPictureView;
import java.util.List;

/* compiled from: ProGuard */
class p<T> {
    private static final Interpolator f = new LinearInterpolator();
    @Nullable
    final T a;
    @Nullable
    final T b;
    @Nullable
    final Interpolator c;
    final float d;
    @Nullable
    Float e;
    private final k g;

    static void a(List<? extends p<?>> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            ((p) list.get(i)).e = Float.valueOf(((p) list.get(i + 1)).d);
        }
        p pVar = (p) list.get(size - 1);
        if (pVar.a == null) {
            list.remove(pVar);
        }
    }

    public p(k kVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.g = kVar;
        this.a = t;
        this.b = t2;
        this.c = interpolator;
        this.d = f;
        this.e = f2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    final float a() {
        return this.d / this.g.b();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    final float b() {
        return this.e == null ? IPictureView.DEFAULT_MIN_SCALE : this.e.floatValue() / this.g.b();
    }

    final boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= a() && f <= b();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.a + ", endValue=" + this.b + ", startFrame=" + this.d + ", endFrame=" + this.e + ", interpolator=" + this.c + '}';
    }
}
