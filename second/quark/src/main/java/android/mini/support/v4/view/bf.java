package android.mini.support.v4.view;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: ProGuard */
class bf extends be {
    bf() {
    }

    public final void d(View view, float f) {
        view.setElevation(f);
    }

    public final void a(View view, an anVar) {
        if (anVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new bj(anVar));
        }
    }

    public final void q(View view) {
        view.stopNestedScroll();
    }

    public final cy a(View view, cy cyVar) {
        if (!(cyVar instanceof cz)) {
            return cyVar;
        }
        WindowInsets windowInsets = ((cz) cyVar).a;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        return onApplyWindowInsets != windowInsets ? new cz(onApplyWindowInsets) : cyVar;
    }

    public final cy b(View view, cy cyVar) {
        if (!(cyVar instanceof cz)) {
            return cyVar;
        }
        WindowInsets windowInsets = ((cz) cyVar).a;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        return dispatchApplyWindowInsets != windowInsets ? new cz(dispatchApplyWindowInsets) : cyVar;
    }
}
