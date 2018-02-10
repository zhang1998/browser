package com.ucpro.ui.animation.explosionfield;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: ProGuard */
public final class a extends ValueAnimator {
    static long a = 1024;
    private static final Interpolator e = new AccelerateInterpolator(0.6f);
    private static final float f = ((float) b.a(5));
    private static final float g = ((float) b.a(20));
    private static final float h = ((float) b.a(2));
    private static final float i = ((float) b.a(1));
    Paint b;
    c[] c;
    View d;
    private Rect j;

    public final void start() {
        super.start();
        this.d.invalidate(this.j);
    }
}
