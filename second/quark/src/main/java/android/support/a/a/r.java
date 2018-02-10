package android.support.a.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: ProGuard */
final class r implements Callback {
    final /* synthetic */ p a;

    r(p pVar) {
        this.a = pVar;
    }

    public final void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.a.scheduleSelf(runnable, j);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.a.unscheduleSelf(runnable);
    }
}
