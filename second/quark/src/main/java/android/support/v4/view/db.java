package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

/* compiled from: ProGuard */
class db extends df {
    db() {
    }

    public void a(LayoutInflater layoutInflater, a aVar) {
        Factory2 jVar;
        if (aVar != null) {
            jVar = new j(aVar);
        } else {
            jVar = null;
        }
        layoutInflater.setFactory2(jVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            k.a(layoutInflater, (Factory2) factory);
        } else {
            k.a(layoutInflater, jVar);
        }
    }
}
