package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
class p extends o {
    p() {
    }

    public final void b(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public Drawable a(Drawable drawable) {
        return !(drawable instanceof c) ? new h(drawable) : drawable;
    }
}
