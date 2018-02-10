package com.ucpro.ui.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
public final class s extends Drawable {
    public Paint a = new Paint();
    private RectF b = new RectF();

    public s() {
        this.a.setStyle(Style.FILL);
        this.a.setAntiAlias(true);
    }

    public final void draw(Canvas canvas) {
        canvas.save();
        if (getBounds().width() <= getBounds().height()) {
            this.b.set(getBounds());
            canvas.drawOval(this.b, this.a);
        } else {
            int i = getBounds().left;
            int height = getBounds().height() + i;
            int i2 = getBounds().top;
            int i3 = getBounds().bottom;
            canvas.save();
            canvas.clipRect(i, i2, Math.round(((float) height) - (((float) getBounds().height()) / 2.0f)), i3);
            this.b.set((float) i, (float) i2, (float) height, (float) i3);
            canvas.drawOval(this.b, this.a);
            canvas.restore();
            i = getBounds().right;
            height = i - getBounds().height();
            i2 = getBounds().top;
            i3 = getBounds().bottom;
            canvas.save();
            canvas.clipRect(Math.round(((float) height) + (((float) getBounds().height()) / 2.0f)), i2, i, i3);
            this.b.set((float) height, (float) i2, (float) i, (float) i3);
            canvas.drawOval(this.b, this.a);
            canvas.restore();
            i = Math.round(((float) getBounds().left) + (((float) getBounds().height()) / 2.0f));
            i3 = Math.round(((float) getBounds().right) - (((float) getBounds().height()) / 2.0f));
            if (i <= i3) {
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) i, (float) getBounds().top, (float) i3, (float) getBounds().bottom, this.a);
            }
        }
        canvas.restore();
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
