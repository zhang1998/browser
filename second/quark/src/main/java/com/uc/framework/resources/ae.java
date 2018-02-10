package com.uc.framework.resources;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
public final class ae extends ColorDrawable {
    private ad a;
    private final Paint b;

    public ae() {
        this(null);
    }

    public ae(int i) {
        this(null);
        setColor(i);
    }

    private ae(ad adVar) {
        this.b = new Paint();
        this.a = new ad(adVar);
    }

    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.c;
    }

    public final void draw(Canvas canvas) {
        if ((this.a.b >>> 24) != 0) {
            this.b.setColor(this.a.b);
            canvas.drawRect(getBounds(), this.b);
        }
    }

    public final int getColor() {
        return this.a.b;
    }

    public final void setColor(int i) {
        if (this.a.a != i || this.a.b != i) {
            invalidateSelf();
            ad adVar = this.a;
            this.a.b = i;
            adVar.a = i;
        }
    }

    public final int getAlpha() {
        return this.a.b >>> 24;
    }

    public final void setAlpha(int i) {
        int i2 = (((i >> 7) + i) * (this.a.a >>> 24)) >> 8;
        int i3 = this.a.b;
        this.a.b = (i2 << 24) | ((this.a.a << 8) >>> 8);
        if (i3 != this.a.b) {
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        switch (this.a.b >>> 24) {
            case 0:
                return -2;
            case 255:
                return -1;
            default:
                return -3;
        }
    }

    public final ConstantState getConstantState() {
        this.a.c = getChangingConfigurations();
        return this.a;
    }
}
