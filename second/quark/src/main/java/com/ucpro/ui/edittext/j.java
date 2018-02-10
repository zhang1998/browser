package com.ucpro.ui.edittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: ProGuard */
public final class j extends CustomEditText {
    private Paint k = new Paint();
    private int l = 1;

    public j(Context context) {
        super(context);
    }

    public final void setBottomLineColor(int i) {
        this.k.setColor(i);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate((float) getScrollX(), (float) getScrollY());
        float height = (float) (getHeight() - this.l);
        Canvas canvas2 = canvas;
        canvas2.drawLine(0.0f, height, (float) getWidth(), height, this.k);
        canvas.restore();
    }
}
