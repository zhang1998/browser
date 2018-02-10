package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class q {
    static final t a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new r();
        } else if (i >= 21) {
            a = new s();
        } else if (i >= 19) {
            a = new v();
        } else if (i >= 17) {
            a = new u();
        } else if (i >= 11) {
            a = new p();
        } else if (i >= 5) {
            a = new o();
        } else {
            a = new w();
        }
    }

    public static void a(@NonNull Drawable drawable) {
        a.b(drawable);
    }

    public static void a(@NonNull Drawable drawable, boolean z) {
        a.a(drawable, z);
    }

    public static boolean b(@NonNull Drawable drawable) {
        return a.f(drawable);
    }

    public static void a(@NonNull Drawable drawable, float f, float f2) {
        a.a(drawable, f, f2);
    }

    public static void a(@NonNull Drawable drawable, int i, int i2, int i3, int i4) {
        a.a(drawable, i, i2, i3, i4);
    }

    public static void a(@NonNull Drawable drawable, @ColorInt int i) {
        a.b(drawable, i);
    }

    public static void a(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(@NonNull Drawable drawable, @Nullable Mode mode) {
        a.a(drawable, mode);
    }

    public static int c(@NonNull Drawable drawable) {
        return a.g(drawable);
    }

    public static void a(Drawable drawable, Theme theme) {
        a.a(drawable, theme);
    }

    public static boolean d(Drawable drawable) {
        return a.d(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.e(drawable);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable f(@NonNull Drawable drawable) {
        return a.a(drawable);
    }

    public static <T extends Drawable> T g(@NonNull Drawable drawable) {
        if (drawable instanceof d) {
            return ((d) drawable).a();
        }
        return drawable;
    }

    public static void b(@NonNull Drawable drawable, int i) {
        a.a(drawable, i);
    }

    public static int h(@NonNull Drawable drawable) {
        return a.c(drawable);
    }

    private q() {
    }
}
