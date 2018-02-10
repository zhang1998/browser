package com.ucpro.ui.animation;

import android.view.animation.Interpolator;

/* compiled from: ProGuard */
final class c implements Interpolator {
    c() {
    }

    public final float getInterpolation(float f) {
        return (float) Math.sin((double) (1.5707964f * f));
    }
}
