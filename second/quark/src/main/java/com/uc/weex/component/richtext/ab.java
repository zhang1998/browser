package com.uc.weex.component.richtext;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
final class ab extends Drawable implements x {
    private Drawable a;
    private ColorFilter b;

    public ab(int i, int i2) {
        setBounds(0, 0, i, i2);
    }

    public final void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
        }
    }

    public final void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.b = colorFilter;
        }
    }

    public final int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return 0;
    }

    public final void a(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
    }
}
