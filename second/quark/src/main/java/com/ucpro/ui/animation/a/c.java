package com.ucpro.ui.animation.a;

import android.view.animation.Interpolator;

/* compiled from: ProGuard */
public final class c implements Interpolator {
    private float a;
    private float b;

    public c() {
        this.a = -5.0f;
        this.b = 30.0f;
    }

    public c(byte b) {
        this.a = -5.0f;
        this.b = 30.0f;
        this.a = -7.0f;
        this.b = 10.0f;
    }

    public final float getInterpolation(float f) {
        return (float) (1.0d - (Math.pow(2.718281828459045d, (double) (this.a * f)) * Math.cos((double) (this.b * f))));
    }
}
