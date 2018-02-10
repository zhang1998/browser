package android.mini.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

/* compiled from: ProGuard */
class v extends u {
    v() {
    }

    public void a(LayoutInflater layoutInflater, ac acVar) {
        Factory2 aaVar;
        if (acVar != null) {
            aaVar = new aa(acVar);
        } else {
            aaVar = null;
        }
        layoutInflater.setFactory2(aaVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            ab.a(layoutInflater, (Factory2) factory);
        } else {
            ab.a(layoutInflater, aaVar);
        }
    }
}
