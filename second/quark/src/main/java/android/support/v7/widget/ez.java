package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class ez extends en {
    private final WeakReference<Context> a;

    public ez(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.a = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) throws NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.a.get();
        if (!(drawable == null || context == null)) {
            fb.a();
            fb.a(context, i, drawable);
        }
        return drawable;
    }
}
