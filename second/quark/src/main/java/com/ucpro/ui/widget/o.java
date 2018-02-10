package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

/* compiled from: ProGuard */
public final class o extends View {
    private Paint a = new Paint();
    private int b = 0;

    public o(Context context) {
        super(context);
        this.a.setAntiAlias(true);
        this.a.setStyle(Style.FILL);
    }

    public final void setType(int i) {
        this.b = i;
    }

    private int getType() {
        return this.b;
    }

    public final void setColor(int i) {
        this.a.setColor(i);
        invalidate();
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == 0) {
            canvas.drawCircle((float) getWidth(), ((float) getHeight()) / 2.0f, (float) getWidth(), this.a);
        } else {
            canvas.drawCircle(0.0f, ((float) getHeight()) / 2.0f, (float) getWidth(), this.a);
        }
    }
}
