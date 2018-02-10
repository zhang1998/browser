package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;

/* compiled from: ProGuard */
final class bt extends db {
    bt() {
    }

    public final void a(LayoutInflater layoutInflater, a aVar) {
        Factory2 jVar;
        if (aVar != null) {
            jVar = new j(aVar);
        } else {
            jVar = null;
        }
        layoutInflater.setFactory2(jVar);
    }
}
