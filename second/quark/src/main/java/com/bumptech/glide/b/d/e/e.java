package com.bumptech.glide.b.d.e;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.b.b.a.g;

/* compiled from: ProGuard */
final class e extends ConstantState {
    final g a;
    final n b;

    public e(g gVar, n nVar) {
        this.a = gVar;
        this.b = nVar;
    }

    public final Drawable newDrawable(Resources resources) {
        return newDrawable();
    }

    public final Drawable newDrawable() {
        return new f(this);
    }

    public final int getChangingConfigurations() {
        return 0;
    }
}
