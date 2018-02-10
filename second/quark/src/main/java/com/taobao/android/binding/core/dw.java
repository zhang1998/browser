package com.taobao.android.binding.core;

import android.mini.support.v4.view.b.c;
import android.view.animation.Interpolator;

/* compiled from: ProGuard */
final class dw implements Interpolator {
    float a;
    float b;
    float c;
    float d;
    private Interpolator e;

    dw(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = c.a(f, f2, f3, f4);
    }

    public final float getInterpolation(float f) {
        return this.e.getInterpolation(f);
    }
}
