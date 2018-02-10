package com.ucpro.ui.widget;

import android.graphics.Paint.Style;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* compiled from: ProGuard */
public final class i extends ShapeDrawable {
    public i(int i, int i2) {
        setShape(new RoundRectShape(new float[]{(float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i}, null, null));
        if (getPaint() != null) {
            getPaint().setStyle(Style.FILL);
            getPaint().setColor(i2);
        }
    }

    public i(float[] fArr, int i) {
        setShape(new RoundRectShape(fArr, null, null));
        if (getPaint() != null) {
            getPaint().setStyle(Style.FILL);
            getPaint().setColor(i);
        }
    }
}
