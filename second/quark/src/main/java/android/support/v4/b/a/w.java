package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
class w implements t {
    w() {
    }

    public void b(Drawable drawable) {
    }

    public void a(Drawable drawable, boolean z) {
    }

    public boolean f(Drawable drawable) {
        return false;
    }

    public void a(Drawable drawable, float f, float f2) {
    }

    public void a(Drawable drawable, int i, int i2, int i3, int i4) {
    }

    public void a(Drawable drawable, int i) {
    }

    public int c(Drawable drawable) {
        return 0;
    }

    public int g(Drawable drawable) {
        return 0;
    }

    public void a(Drawable drawable, Theme theme) {
    }

    public boolean d(Drawable drawable) {
        return false;
    }

    public ColorFilter e(Drawable drawable) {
        return null;
    }

    public void b(Drawable drawable, int i) {
        if (drawable instanceof c) {
            ((c) drawable).setTint(i);
        }
    }

    public void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof c) {
            ((c) drawable).setTintList(colorStateList);
        }
    }

    public void a(Drawable drawable, Mode mode) {
        if (drawable instanceof c) {
            ((c) drawable).setTintMode(mode);
        }
    }

    public Drawable a(Drawable drawable) {
        return !(drawable instanceof c) ? new e(drawable) : drawable;
    }

    public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
