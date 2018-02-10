package com.uc.b.a;

import android.graphics.Path.Direction;
import android.graphics.RectF;

/* compiled from: ProGuard */
final class u extends d {
    public u(float f, float f2, float f3, float f4) {
        this.c.addOval(new RectF(f - f3, f2 - f4, f + f3, f2 + f4), Direction.CCW);
    }
}
