package android.mini.support.v4.view;

import android.view.View;

/* compiled from: ProGuard */
class be extends bc {
    be() {
    }

    public final void c(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public final boolean r(View view) {
        return view.isAttachedToWindow();
    }
}
