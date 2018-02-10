package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

/* compiled from: ProGuard */
public abstract class a extends ConstantState {
    int a;
    ConstantState b;
    ColorStateList c = null;
    Mode d = e.a;

    public abstract Drawable newDrawable(@Nullable Resources resources);

    a(@Nullable a aVar) {
        if (aVar != null) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
        }
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public int getChangingConfigurations() {
        return (this.b != null ? this.b.getChangingConfigurations() : 0) | this.a;
    }
}
