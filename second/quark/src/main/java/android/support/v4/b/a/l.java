package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
class l extends h {
    l(Drawable drawable) {
        super(drawable);
    }

    l(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    @NonNull
    a b() {
        return new k(this.b);
    }
}
