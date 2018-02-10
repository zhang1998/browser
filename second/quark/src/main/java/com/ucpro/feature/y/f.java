package com.ucpro.feature.y;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* compiled from: ProGuard */
public final class f extends View {
    final /* synthetic */ l a;

    public f(l lVar, Context context) {
        this.a = lVar;
        super(context);
    }

    protected final void onDraw(Canvas canvas) {
        if (this.a.b != null) {
            canvas.save();
            canvas.translate((float) this.a.b.getScrollX(), (float) this.a.b.getScrollY());
            this.a.b.draw(canvas);
            canvas.restore();
        }
    }
}
