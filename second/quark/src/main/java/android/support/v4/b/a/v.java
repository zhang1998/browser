package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
class v extends u {
    v() {
    }

    public final void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public final boolean f(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public Drawable a(Drawable drawable) {
        return !(drawable instanceof c) ? new l(drawable) : drawable;
    }

    public final int g(Drawable drawable) {
        return drawable.getAlpha();
    }
}
