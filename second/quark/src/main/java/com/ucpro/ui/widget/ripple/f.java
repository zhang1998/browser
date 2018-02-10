package com.ucpro.ui.widget.ripple;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* compiled from: ProGuard */
public final class f {
    private static boolean a = true;
    private static long b = 150;

    public static Drawable a(int i, int i2) {
        if (a) {
            r2 = new int[2][];
            r2[0] = new int[]{16842919};
            r2[1] = new int[0];
            return new h(new ColorStateList(r2, new int[]{i2, i}), new ColorDrawable(i));
        }
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i2));
        stateListDrawable.addState(new int[0], new ColorDrawable(i));
        return stateListDrawable;
    }
}
