package com.taobao.weex.c;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.taobao.weex.utils.r;

/* compiled from: ProGuard */
public final class y extends MetricAffectingSpan {
    private final int a;
    private final int b;
    private final String c;

    public y(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final void updateDrawState(TextPaint textPaint) {
        r.a(textPaint, this.a, this.b, this.c);
    }

    public final void updateMeasureState(TextPaint textPaint) {
        r.a(textPaint, this.a, this.b, this.c);
    }
}
