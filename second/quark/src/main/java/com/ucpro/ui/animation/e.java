package com.ucpro.ui.animation;

import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class e implements Interpolator {
    private float a = IPictureView.DEFAULT_MIN_SCALE;

    public final float getInterpolation(float f) {
        float f2 = this.a;
        if (((double) f) == 1.0d) {
            return IPictureView.DEFAULT_MIN_SCALE;
        }
        if (((double) f) < 0.36363636363636365d) {
            return IPictureView.DEFAULT_MIN_SCALE * ((7.5625f * f) * f);
        }
        float f3;
        if (((double) f) < 0.7272727272727273d) {
            f3 = (float) (((double) f) - 0.5454545454545454d);
            return IPictureView.DEFAULT_MIN_SCALE + ((-f2) * (IPictureView.DEFAULT_MIN_SCALE - ((f3 * (7.5625f * f3)) + 0.75f)));
        } else if (((double) f) < 0.9090909090909091d) {
            f3 = (float) (((double) f) - 0.8181818181818182d);
            return IPictureView.DEFAULT_MIN_SCALE + ((-f2) * (IPictureView.DEFAULT_MIN_SCALE - ((f3 * (7.5625f * f3)) + 0.9375f)));
        } else {
            f3 = (float) (((double) f) - 0.9545454545454546d);
            return IPictureView.DEFAULT_MIN_SCALE + ((-f2) * (IPictureView.DEFAULT_MIN_SCALE - ((f3 * (7.5625f * f3)) + 0.984375f)));
        }
    }
}
