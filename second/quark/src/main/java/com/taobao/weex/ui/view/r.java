package com.taobao.weex.ui.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ProGuard */
public final class r extends Scroller {
    private double a = 1.0d;

    public r(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (((double) i5) * this.a));
    }
}
