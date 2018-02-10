package com.ucpro.feature.inputenhance;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.EditText;

/* compiled from: ProGuard */
final class aq implements OnPreDrawListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ int b;
    final /* synthetic */ af c;

    aq(af afVar, EditText editText, int i) {
        this.c = afVar;
        this.a = editText;
        this.b = i;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.bringPointIntoView(this.b);
        return false;
    }
}
