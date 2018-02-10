package com.ucpro.ui.widget.ripple;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public abstract class g extends Drawable {
    private ColorFilter a;

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a = colorFilter;
    }

    public void setAlpha(int i) {
    }

    public ColorFilter getColorFilter() {
        return this.a;
    }

    public int getAlpha() {
        return 255;
    }

    public boolean canApplyTheme() {
        return false;
    }

    public void applyTheme(Theme theme) {
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
    }

    public void setTintMode(Mode mode) {
    }

    public void setHotspot(float f, float f2) {
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
    }

    public void getHotspotBounds(Rect rect) {
        rect.set(getBounds());
    }
}
