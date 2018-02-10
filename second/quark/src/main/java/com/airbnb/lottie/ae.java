package com.airbnb.lottie;

import android.graphics.Paint.Join;

/* compiled from: ProGuard */
enum ae {
    Miter,
    Round,
    Bevel;

    final Join a() {
        switch (ck.b[ordinal()]) {
            case 1:
                return Join.BEVEL;
            case 2:
                return Join.MITER;
            case 3:
                return Join.ROUND;
            default:
                return null;
        }
    }
}
