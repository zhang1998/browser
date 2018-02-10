package android.support.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

/* compiled from: ProGuard */
final class l extends ConstantState {
    private final ConstantState a;

    public l(ConstantState constantState) {
        this.a = constantState;
    }

    public final Drawable newDrawable() {
        Drawable cVar = new c();
        cVar.d = (VectorDrawable) this.a.newDrawable();
        return cVar;
    }

    public final Drawable newDrawable(Resources resources) {
        Drawable cVar = new c();
        cVar.d = (VectorDrawable) this.a.newDrawable(resources);
        return cVar;
    }

    public final Drawable newDrawable(Resources resources, Theme theme) {
        Drawable cVar = new c();
        cVar.d = (VectorDrawable) this.a.newDrawable(resources, theme);
        return cVar;
    }

    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public final int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }
}
