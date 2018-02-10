package com.uc.framework.resources;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
final class ad extends ConstantState {
    int a;
    int b;
    int c;

    ad(ad adVar) {
        if (adVar != null) {
            this.a = adVar.a;
            this.b = adVar.b;
        }
    }

    public final Drawable newDrawable() {
        return new ae();
    }

    public final Drawable newDrawable(Resources resources) {
        return new ae();
    }

    public final int getChangingConfigurations() {
        return this.c;
    }
}
