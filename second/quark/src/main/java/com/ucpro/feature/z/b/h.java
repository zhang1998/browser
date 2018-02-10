package com.ucpro.feature.z.b;

import android.view.ViewTreeObserver.OnPreDrawListener;
import com.ucpro.ui.edittext.CustomEditText;

/* compiled from: ProGuard */
final class h implements OnPreDrawListener {
    final /* synthetic */ CustomEditText a;
    final /* synthetic */ b b;

    h(b bVar, CustomEditText customEditText) {
        this.b = bVar;
        this.a = customEditText;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.a(this.b.a);
        return false;
    }
}
