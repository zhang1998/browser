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
interface t {
    Drawable a(Drawable drawable);

    void a(Drawable drawable, float f, float f2);

    void a(Drawable drawable, int i);

    void a(Drawable drawable, int i, int i2, int i3, int i4);

    void a(Drawable drawable, ColorStateList colorStateList);

    void a(Drawable drawable, Theme theme);

    void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException;

    void a(Drawable drawable, Mode mode);

    void a(Drawable drawable, boolean z);

    void b(Drawable drawable);

    void b(Drawable drawable, int i);

    int c(Drawable drawable);

    boolean d(Drawable drawable);

    ColorFilter e(Drawable drawable);

    boolean f(Drawable drawable);

    int g(Drawable drawable);
}
