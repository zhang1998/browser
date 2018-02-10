package com.ucpro.ui.widget.ripple;

import com.uc.imagecodec.export.IPictureView;
import java.util.Random;

/* compiled from: ProGuard */
public final class a {
    private static final Random a = new Random();

    public static float a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f > IPictureView.DEFAULT_MIN_SCALE ? IPictureView.DEFAULT_MIN_SCALE : f;
    }

    public static float a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
