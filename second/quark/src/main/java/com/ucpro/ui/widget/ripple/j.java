package com.ucpro.ui.widget.ripple;

import android.animation.TimeInterpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class j implements TimeInterpolator {
    private j() {
    }

    public final float getInterpolation(float f) {
        return IPictureView.DEFAULT_MIN_SCALE - ((float) Math.pow(400.0d, ((double) (-f)) * 1.4d));
    }
}
