package com.uc.framework.resources;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
public class ac extends Drawable implements Callback {
    private Drawable a;
    private int b = 255;
    private ColorFilter c;
    ab d;
    private boolean e;
    private int f = -1;
    private boolean g;

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
        }
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.d.c) | this.d.d;
    }

    public boolean getPadding(Rect rect) {
        Rect rect2;
        int i = 0;
        ab abVar = this.d;
        if (abVar.g) {
            rect2 = null;
        } else if (abVar.h != null) {
            rect2 = abVar.h;
        } else {
            rect2 = new Rect(0, 0, 0, 0);
            Rect rect3 = new Rect();
            int i2 = abVar.f;
            while (i < i2) {
                if (abVar.e[i].getPadding(rect3)) {
                    if (rect3.left > rect2.left) {
                        rect2.left = rect3.left;
                    }
                    if (rect3.top > rect2.top) {
                        rect2.top = rect3.top;
                    }
                    if (rect3.right > rect2.right) {
                        rect2.right = rect3.right;
                    }
                    if (rect3.bottom > rect2.bottom) {
                        rect2.bottom = rect3.bottom;
                    }
                }
                i++;
            }
            abVar.h = rect2;
        }
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        } else if (this.a != null) {
            return this.a.getPadding(rect);
        } else {
            return super.getPadding(rect);
        }
    }

    public void setAlpha(int i) {
        if (this.b != i) {
            this.b = i;
            if (this.a != null) {
                this.a.setAlpha(i);
            }
        }
    }

    public void setDither(boolean z) {
        if (this.e != z) {
            this.e = z;
            if (this.a != null) {
                this.a.setDither(this.e);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c != colorFilter) {
            this.c = colorFilter;
            if (this.a != null) {
                this.a.setColorFilter(colorFilter);
            }
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    public boolean isStateful() {
        boolean z = false;
        ab abVar = this.d;
        if (abVar.q) {
            return abVar.r;
        }
        int i = abVar.f;
        for (int i2 = 0; i2 < i; i2++) {
            if (abVar.e[i2].isStateful()) {
                z = true;
                break;
            }
        }
        abVar.r = z;
        abVar.q = true;
        return z;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return false;
    }

    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return false;
    }

    public int getIntrinsicWidth() {
        if (!this.d.i) {
            return this.a != null ? this.a.getIntrinsicWidth() : -1;
        } else {
            ab abVar = this.d;
            if (!abVar.j) {
                abVar.a();
            }
            return abVar.k;
        }
    }

    public int getIntrinsicHeight() {
        if (!this.d.i) {
            return this.a != null ? this.a.getIntrinsicHeight() : -1;
        } else {
            ab abVar = this.d;
            if (!abVar.j) {
                abVar.a();
            }
            return abVar.l;
        }
    }

    public int getMinimumWidth() {
        if (!this.d.i) {
            return this.a != null ? this.a.getMinimumWidth() : 0;
        } else {
            ab abVar = this.d;
            if (!abVar.j) {
                abVar.a();
            }
            return abVar.m;
        }
    }

    public int getMinimumHeight() {
        if (!this.d.i) {
            return this.a != null ? this.a.getMinimumHeight() : 0;
        } else {
            ab abVar = this.d;
            if (!abVar.j) {
                abVar.a();
            }
            return abVar.n;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.a != null) {
            this.a.setVisible(z, z2);
        }
        return visible;
    }

    public int getOpacity() {
        ab abVar = this.d;
        if (abVar.o) {
            return abVar.p;
        }
        int i = abVar.f;
        int opacity = i > 0 ? abVar.e[0].getOpacity() : -2;
        int i2 = 1;
        while (i2 < i) {
            int resolveOpacity = Drawable.resolveOpacity(opacity, abVar.e[i2].getOpacity());
            i2++;
            opacity = resolveOpacity;
        }
        abVar.p = opacity;
        abVar.o = true;
        return opacity;
    }

    boolean a(int i) {
        if (i == this.f) {
            return false;
        }
        if (i < 0 || i >= this.d.f) {
            if (this.a != null) {
                this.a.setVisible(false, false);
            }
            this.a = null;
            this.f = -1;
        } else {
            Drawable drawable = this.d.e[i];
            if (this.a != null) {
                this.a.setVisible(false, false);
            }
            this.a = drawable;
            this.f = i;
            if (drawable != null) {
                drawable.setVisible(isVisible(), true);
                drawable.setAlpha(this.b);
                drawable.setDither(this.e);
                drawable.setColorFilter(this.c);
                drawable.setState(getState());
                drawable.setLevel(getLevel());
                drawable.setBounds(getBounds());
            }
        }
        invalidateSelf();
        return true;
    }

    public Drawable getCurrent() {
        return this.a;
    }

    public ConstantState getConstantState() {
        if (!this.d.b()) {
            return null;
        }
        this.d.c = super.getChangingConfigurations();
        return this.d;
    }

    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            for (Drawable drawable : this.d.e) {
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.g = true;
        }
        return this;
    }

    public void invalidateDrawable(Drawable drawable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}
