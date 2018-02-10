package com.airbnb.lottie;

import android.graphics.Paint.Cap;

/* compiled from: ProGuard */
enum bg {
    Butt,
    Round,
    Unknown;

    final Cap a() {
        switch (ck.a[ordinal()]) {
            case 1:
                return Cap.BUTT;
            case 2:
                return Cap.ROUND;
            default:
                return Cap.SQUARE;
        }
    }
}
