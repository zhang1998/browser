package com.uc.framework.xml;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.text.style.LineHeightSpan;

/* compiled from: ProGuard */
final class a implements LineHeightSpan {
    private static float b = 0.0f;
    private int a;

    public a(int i) {
        this.a = i;
    }

    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt.bottom - fontMetricsInt.top < this.a) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.a;
            fontMetricsInt.ascent -= this.a;
            return;
        }
        if (b == 0.0f) {
            Paint paint = new Paint();
            paint.setTextSize(100.0f);
            Rect rect = new Rect();
            paint.getTextBounds("ABCDEFG", 0, 7, rect);
            b = ((float) rect.top) / paint.ascent();
        }
        int ceil = (int) Math.ceil((double) (((float) (-fontMetricsInt.top)) * b));
        if (this.a - fontMetricsInt.descent >= ceil) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.a;
            fontMetricsInt.ascent = fontMetricsInt.descent - this.a;
        } else if (this.a >= ceil) {
            ceil = -ceil;
            fontMetricsInt.ascent = ceil;
            fontMetricsInt.top = ceil;
            ceil = fontMetricsInt.top + this.a;
            fontMetricsInt.descent = ceil;
            fontMetricsInt.bottom = ceil;
        } else {
            ceil = -this.a;
            fontMetricsInt.ascent = ceil;
            fontMetricsInt.top = ceil;
            fontMetricsInt.descent = 0;
            fontMetricsInt.bottom = 0;
        }
    }
}
