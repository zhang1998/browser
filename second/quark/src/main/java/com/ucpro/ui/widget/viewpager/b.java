package com.ucpro.ui.widget.viewpager;

import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class b implements Interpolator {
    b() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - IPictureView.DEFAULT_MIN_SCALE;
        return (f2 * (((f2 * f2) * f2) * f2)) + IPictureView.DEFAULT_MIN_SCALE;
    }
}
