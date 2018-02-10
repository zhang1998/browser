package com.uc.b.a;

import android.graphics.Paint.Cap;

/* compiled from: ProGuard */
enum i {
    BUTT(Cap.BUTT),
    ROUND(Cap.ROUND),
    SQUARE(Cap.SQUARE);
    
    final Cap d;

    private i(Cap cap) {
        this.d = cap;
    }
}
