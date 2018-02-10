package com.ucpro.ui.widget.ripple;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* compiled from: ProGuard */
final class l extends c {
    TypedValue[] j;
    ColorStateList k = ColorStateList.valueOf(-65281);
    int l = -1;

    public l(c cVar, h hVar, Resources resources) {
        super(cVar, hVar, resources);
        if (cVar != null && (cVar instanceof l)) {
            l lVar = (l) cVar;
            this.j = lVar.j;
            this.k = lVar.k;
            this.l = lVar.l;
        }
    }

    public final Drawable newDrawable() {
        return new h(this, null);
    }

    public final Drawable newDrawable(Resources resources) {
        return new h(this, resources);
    }
}
