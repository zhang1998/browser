package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

/* compiled from: ProGuard */
class df implements el {
    df() {
    }

    public void a(LayoutInflater layoutInflater, a aVar) {
        Factory dVar;
        if (aVar != null) {
            dVar = new d(aVar);
        } else {
            dVar = null;
        }
        layoutInflater.setFactory(dVar);
    }

    public final a a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof d) {
            return ((d) factory).a;
        }
        return null;
    }
}
