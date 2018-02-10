package com.taobao.weex.c;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class ak implements LineHeightSpan {
    private int a;

    public ak(int i) {
        this.a = i;
    }

    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
        if (i.c()) {
            WXLogUtils.d("LineHeight", charSequence + " ; start " + i + "; end " + i2 + "; spanstartv " + i3 + "; v " + i4 + "; fm " + fontMetricsInt);
        }
        int i5 = (this.a - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2;
        fontMetricsInt.top -= i5;
        fontMetricsInt.bottom += i5;
        fontMetricsInt.ascent -= i5;
        fontMetricsInt.descent = i5 + fontMetricsInt.descent;
    }
}
