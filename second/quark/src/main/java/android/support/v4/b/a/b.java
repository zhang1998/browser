package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/* compiled from: ProGuard */
final class b extends a {
    b(@Nullable a aVar) {
        super(aVar);
    }

    public final Drawable newDrawable(@Nullable Resources resources) {
        return new e(this, resources);
    }
}
