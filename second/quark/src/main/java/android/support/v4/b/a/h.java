package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
class h extends e {
    h(Drawable drawable) {
        super(drawable);
    }

    h(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    @NonNull
    a b() {
        return new i(this.b);
    }
}
