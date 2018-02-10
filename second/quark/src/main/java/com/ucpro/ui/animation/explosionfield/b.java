package com.ucpro.ui.animation.explosionfield;

import android.content.res.Resources;
import android.graphics.Canvas;

/* compiled from: ProGuard */
public final class b {
    private static final float a = Resources.getSystem().getDisplayMetrics().density;
    private static final Canvas b = new Canvas();

    public static int a(int i) {
        return Math.round(((float) i) * a);
    }
}
