package com.ucpro.base.c.b;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* compiled from: ProGuard */
final class af extends View {
    private boolean a = true;

    public af(Context context) {
        super(context);
    }

    public final void draw(Canvas canvas) {
        if (this.a) {
            super.draw(canvas);
        }
    }
}
