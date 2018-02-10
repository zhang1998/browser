package com.taobao.weex.ui.view.refresh.circlebar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: ProGuard */
final class d implements Callback {
    final /* synthetic */ MaterialProgressDrawable a;

    d(MaterialProgressDrawable materialProgressDrawable) {
        this.a = materialProgressDrawable;
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
