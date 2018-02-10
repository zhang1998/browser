package com.uc.weex.component.richtext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;

/* compiled from: ProGuard */
class j implements LeadingMarginSpan, LineBackgroundSpan {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    final /* synthetic */ HtmlToSpannedConverter e;

    public j(HtmlToSpannedConverter htmlToSpannedConverter, int i, int i2, float f, float f2) {
        this.e = htmlToSpannedConverter;
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
    }

    public j(HtmlToSpannedConverter htmlToSpannedConverter, j jVar) {
        this.e = htmlToSpannedConverter;
        this.a = jVar.a;
        this.b = jVar.b;
        this.c = jVar.c;
        this.d = jVar.d;
    }

    public int getLeadingMargin(boolean z) {
        return (int) (this.c + this.d);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Style.FILL);
        paint.setColor(this.b);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) i, (float) i3, (((float) i2) * this.c) + ((float) i), (float) i5, paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        int color = paint.getColor();
        paint.setColor(this.a);
        canvas.drawRect((float) i, (float) i3, (float) i2, (float) i5, paint);
        paint.setColor(color);
    }
}
