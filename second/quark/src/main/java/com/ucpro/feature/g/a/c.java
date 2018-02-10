package com.ucpro.feature.g.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* compiled from: ProGuard */
public final class c {
    public static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }
}
