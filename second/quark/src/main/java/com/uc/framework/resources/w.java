package com.uc.framework.resources;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;

/* compiled from: ProGuard */
public final class w extends Drawable {
    private v a;
    private Bitmap b;
    private final Rect c;
    private boolean d;
    private boolean e;

    public w(Bitmap bitmap, Rect rect) {
        this(new v(bitmap, rect));
    }

    public final void setFilterBitmap(boolean z) {
        this.a.e.setFilterBitmap(z);
    }

    public final void setDither(boolean z) {
        this.a.e.setDither(z);
    }

    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.c;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.d = true;
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.b;
        if (bitmap != null) {
            v vVar = this.a;
            if (this.d) {
                Gravity.apply(vVar.d, vVar.b.width(), vVar.b.height(), getBounds(), this.c);
                this.d = false;
            }
            canvas.drawBitmap(bitmap, vVar.b, this.c, vVar.e);
        }
    }

    public final void setAlpha(int i) {
        this.a.e.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.e.setColorFilter(colorFilter);
    }

    public final int getIntrinsicWidth() {
        return this.a.b.width();
    }

    public final int getIntrinsicHeight() {
        return this.a.b.height();
    }

    public final int getOpacity() {
        if (this.a.d != 119) {
            return -3;
        }
        Bitmap bitmap = this.b;
        if (bitmap == null || bitmap.hasAlpha() || this.a.e.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public final ConstantState getConstantState() {
        this.a.c = super.getChangingConfigurations();
        return this.a;
    }

    public final Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.a = new v(this.a, this.a.b);
            this.e = true;
        }
        return this;
    }

    private w(v vVar) {
        this.c = new Rect();
        this.a = vVar;
        this.b = vVar.a;
    }
}
