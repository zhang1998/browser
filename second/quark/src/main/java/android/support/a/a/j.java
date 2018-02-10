package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.c;
import android.support.v4.b.a.q;
import android.util.AttributeSet;

@TargetApi(21)
/* compiled from: ProGuard */
abstract class j extends Drawable implements c {
    Drawable d;

    j() {
    }

    static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.d != null) {
            this.d.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.d != null) {
            return q.e(this.d);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.d != null) {
            return this.d.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.d != null) {
            q.a(this.d, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.d != null) {
            q.a(this.d, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.d != null) {
            this.d.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.d != null) {
            q.a(this.d);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.d != null) {
            q.a(this.d, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.d != null) {
            q.b(this.d);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.d != null) {
            q.a(this.d, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.d != null) {
            q.h(this.d);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.d != null) {
            this.d.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.d != null) {
            return this.d.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.d != null) {
            return this.d.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.d != null) {
            return this.d.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.d != null) {
            return this.d.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.d != null) {
            return this.d.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.d != null) {
            return this.d.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.d != null) {
            this.d.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.d != null) {
            return this.d.setState(iArr);
        }
        return super.setState(iArr);
    }
}
