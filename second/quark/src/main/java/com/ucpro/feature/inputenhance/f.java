package com.ucpro.feature.inputenhance;

import android.view.ViewTreeObserver.OnPreDrawListener;
import com.ucpro.ui.edittext.CustomEditText;

/* compiled from: ProGuard */
final class f implements OnPreDrawListener {
    final /* synthetic */ CustomEditText a;
    final /* synthetic */ int b;
    final /* synthetic */ af c;

    f(af afVar, CustomEditText customEditText, int i) {
        this.c = afVar;
        this.a = customEditText;
        this.b = i;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.a(this.b);
        return false;
    }
}
