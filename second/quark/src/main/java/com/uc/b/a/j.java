package com.uc.b.a;

import android.graphics.Paint.Join;

/* compiled from: ProGuard */
enum j {
    MITER(Join.MITER),
    ROUND(Join.ROUND),
    BEVEL(Join.BEVEL);
    
    final Join d;

    private j(Join join) {
        this.d = join;
    }
}
