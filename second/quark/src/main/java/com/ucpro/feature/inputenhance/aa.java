package com.ucpro.feature.inputenhance;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.EditText;

/* compiled from: ProGuard */
final class aa implements OnPreDrawListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ af b;

    aa(af afVar, EditText editText) {
        this.b = afVar;
        this.a = editText;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.bringPointIntoView(this.b.g);
        return false;
    }
}
