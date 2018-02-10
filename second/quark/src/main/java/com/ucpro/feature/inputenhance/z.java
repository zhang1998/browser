package com.ucpro.feature.inputenhance;

import android.view.ViewTreeObserver.OnPreDrawListener;
import com.ui.edittext.EditText;

/* compiled from: ProGuard */
final class z implements OnPreDrawListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ af b;

    z(af afVar, EditText editText) {
        this.b = afVar;
        this.a = editText;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.a(this.b.g);
        return false;
    }
}
