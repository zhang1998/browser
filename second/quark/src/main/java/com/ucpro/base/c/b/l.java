package com.ucpro.base.c.b;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
final class l extends FrameLayout {
    private boolean a;

    public l(Context context) {
        super(context);
    }

    protected final void dispatchDraw(Canvas canvas) {
        if (!this.a) {
            super.dispatchDraw(canvas);
        }
    }
}
