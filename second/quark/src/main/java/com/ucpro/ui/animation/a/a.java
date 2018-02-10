package com.ucpro.ui.animation.a;

import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class a implements Interpolator {
    public final float getInterpolation(float f) {
        float f2 = f - IPictureView.DEFAULT_MIN_SCALE;
        float f3 = f2 * f2;
        return ((f2 * f3) * f3) + IPictureView.DEFAULT_MIN_SCALE;
    }
}
