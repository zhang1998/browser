package com.ucpro.ui.widget.tablayout;

import android.support.v4.view.a.b;
import android.support.v4.view.a.c;
import android.support.v4.view.a.d;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: ProGuard */
public final class o {
    static final Interpolator a = new LinearInterpolator();
    static final Interpolator b = new b();
    static final Interpolator c = new c();
    static final Interpolator d = new d();
    static final Interpolator e = new DecelerateInterpolator();

    static int a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
