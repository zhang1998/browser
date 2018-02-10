package android.support.v4.view;

import android.view.View;

/* compiled from: ProGuard */
class bd extends ed {
    bd() {
    }

    public final void e(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public final boolean c(View view) {
        return view.isLaidOut();
    }

    public final boolean d(View view) {
        return view.isAttachedToWindow();
    }
}
