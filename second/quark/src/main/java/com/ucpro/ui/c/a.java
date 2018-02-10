package com.ucpro.ui.c;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.uc.framework.resources.f;
import com.uc.framework.resources.r;

/* compiled from: ProGuard */
public final class a {
    public static final ColorFilter a = new LightingColorFilter(-7829368, 0);
    private static boolean b = false;

    public static Drawable a(String str) {
        return r.a().a.a(str, 320);
    }

    public static Drawable b(String str) {
        return r.a().a.a(str, 480);
    }

    public static int c(String str) {
        f fVar = r.a().a;
        return f.c(str);
    }

    public static ColorStateList d(String str) {
        f fVar = r.a().a;
        return f.b(str);
    }

    public static ColorStateList a(String str, String str2) {
        f fVar = r.a().a;
        r1 = new int[2][];
        r1[0] = new int[]{16842919};
        r1[1] = new int[0];
        return new ColorStateList(r1, new int[]{f.c(str), f.c(str2)});
    }

    public static float a(int i) {
        return b(i);
    }

    public static float b(int i) {
        f fVar = r.a().a;
        return f.a(i);
    }

    public static int c(int i) {
        return (int) b(i);
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if (b()) {
            imageView.setColorFilter(a);
        } else {
            imageView.setColorFilter(null);
        }
    }

    public static boolean a() {
        return r.a().a.c == 2;
    }

    public static boolean b() {
        return r.a().a.c == 1;
    }

    public static Drawable a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        r.a().a.a(drawable);
        return drawable;
    }

    public static String d(int i) {
        f fVar = r.a().a;
        return f.b(i);
    }

    public static Drawable c() {
        return com.ucpro.ui.widget.ripple.f.a(c("home_toolbar_item_default_bg_color"), c("home_toolbar_item_pressed_bg_color"));
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean d() {
        return b;
    }
}
