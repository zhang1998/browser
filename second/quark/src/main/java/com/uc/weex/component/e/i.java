package com.uc.weex.component.e;

import android.animation.TimeInterpolator;

/* compiled from: ProGuard */
final class i implements TimeInterpolator {
    final /* synthetic */ j a;

    private i(j jVar) {
        this.a = jVar;
    }

    public final float getInterpolation(float f) {
        return ((f * f) * f) * f;
    }
}
