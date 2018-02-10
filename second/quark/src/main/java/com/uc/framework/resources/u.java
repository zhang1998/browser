package com.uc.framework.resources;

import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
public final class u {
    private static final ColorFilter b = new LightingColorFilter(-7829368, 0);
    int a = 1;

    public final void a(Drawable drawable) {
        a(drawable, this.a);
    }

    public static void a(Drawable drawable, int i) {
        if (drawable != null) {
            if (i == 2) {
                drawable.setColorFilter(b);
            } else {
                drawable.setColorFilter(null);
            }
        }
    }
}
