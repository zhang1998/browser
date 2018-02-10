package com.taobao.weex.c;

import android.mini.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* compiled from: ProGuard */
public final class u extends CharacterStyle implements UpdateAppearance {
    private final int a;

    public u(@NonNull int i) {
        this.a = i;
    }

    public final void updateDrawState(TextPaint textPaint) {
        switch (t.a[this.a - 1]) {
            case 1:
                textPaint.setUnderlineText(false);
                textPaint.setStrikeThruText(true);
                return;
            case 2:
                textPaint.setUnderlineText(true);
                textPaint.setStrikeThruText(false);
                return;
            case 3:
                textPaint.setUnderlineText(false);
                textPaint.setStrikeThruText(false);
                return;
            default:
                return;
        }
    }
}
