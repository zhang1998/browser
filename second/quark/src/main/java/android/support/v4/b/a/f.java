package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
final class f extends e {
    f(Drawable drawable) {
        super(drawable);
    }

    f(a aVar, Resources resources) {
        super(aVar, resources);
    }

    final a b() {
        return new g(this.b);
    }

    protected final Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }
}
