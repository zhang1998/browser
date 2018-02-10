package android.support.v7.app;

import android.view.ActionMode;
import android.view.Window.Callback;

/* compiled from: ProGuard */
final class aw extends ab {
    final /* synthetic */ as d;

    aw(as asVar, Callback callback) {
        this.d = asVar;
        super(asVar, callback);
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.d.g) {
            switch (i) {
                case 0:
                    return a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
