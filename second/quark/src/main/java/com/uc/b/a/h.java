package com.uc.b.a;

import android.graphics.Path.FillType;

/* compiled from: ProGuard */
enum h {
    NONZERO(FillType.WINDING),
    EVENODD(FillType.EVEN_ODD),
    INHERIT(null);
    
    final FillType d;

    private h(FillType fillType) {
        this.d = fillType;
    }
}
