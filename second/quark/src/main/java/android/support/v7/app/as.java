package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: ProGuard */
final class as extends o {
    private final UiModeManager w;

    as(Context context, Window window, ac acVar) {
        super(context, window, acVar);
        this.w = (UiModeManager) context.getSystemService("uimode");
    }

    final Callback a(Callback callback) {
        return new aw(this, callback);
    }

    final int f(int i) {
        if (i == 0 && this.w.getNightMode() == 0) {
            return -1;
        }
        return super.f(i);
    }
}
