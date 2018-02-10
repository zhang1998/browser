package android.mini.support.v4.view;

import android.view.View;

/* compiled from: ProGuard */
class co extends cm {
    co() {
    }

    public final void a(cs csVar, View view, cx cxVar) {
        if (cxVar != null) {
            view.animate().setListener(new cv(cxVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
