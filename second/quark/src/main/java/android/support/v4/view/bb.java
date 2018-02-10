package android.support.v4.view;

import android.view.View;

/* compiled from: ProGuard */
class bb extends ct {
    bb() {
    }

    public final void a(bo boVar, View view, l lVar) {
        if (lVar != null) {
            view.animate().setListener(new w(lVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
