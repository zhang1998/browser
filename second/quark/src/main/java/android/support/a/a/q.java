package android.support.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
final class q extends ConstantState {
    private final ConstantState a;

    public q(ConstantState constantState) {
        this.a = constantState;
    }

    public final Drawable newDrawable() {
        p pVar = new p();
        pVar.d = this.a.newDrawable();
        pVar.d.setCallback(pVar.e);
        return pVar;
    }

    public final Drawable newDrawable(Resources resources) {
        p pVar = new p();
        pVar.d = this.a.newDrawable(resources);
        pVar.d.setCallback(pVar.e);
        return pVar;
    }

    public final Drawable newDrawable(Resources resources, Theme theme) {
        p pVar = new p();
        pVar.d = this.a.newDrawable(resources, theme);
        pVar.d.setCallback(pVar.e);
        return pVar;
    }

    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public final int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }
}
