package android.mini.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;

/* compiled from: ProGuard */
final class w extends v {
    w() {
    }

    public final void a(LayoutInflater layoutInflater, ac acVar) {
        Factory2 aaVar;
        if (acVar != null) {
            aaVar = new aa(acVar);
        } else {
            aaVar = null;
        }
        layoutInflater.setFactory2(aaVar);
    }
}
