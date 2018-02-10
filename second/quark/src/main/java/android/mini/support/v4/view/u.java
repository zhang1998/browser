package android.mini.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

/* compiled from: ProGuard */
class u implements t {
    u() {
    }

    public void a(LayoutInflater layoutInflater, ac acVar) {
        Factory yVar;
        if (acVar != null) {
            yVar = new y(acVar);
        } else {
            yVar = null;
        }
        layoutInflater.setFactory(yVar);
    }
}
