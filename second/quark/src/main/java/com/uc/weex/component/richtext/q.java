package com.uc.weex.component.richtext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* compiled from: ProGuard */
final class q extends ImageSpan {
    private Drawable a;

    q(Drawable drawable, String str) {
        super(drawable, str, 1);
        this.a = drawable;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(f, (float) (((((paint.getFontMetricsInt().descent + i4) + i4) + paint.getFontMetricsInt().ascent) / 2) - (this.a.getBounds().bottom / 2)));
        this.a.draw(canvas);
        canvas.restore();
    }
}
