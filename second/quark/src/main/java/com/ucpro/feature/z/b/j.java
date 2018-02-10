package com.ucpro.feature.z.b;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ProGuard */
final class j implements OnPreDrawListener {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    j(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public final boolean onPreDraw() {
        this.b.c.d.getViewTreeObserver().removeOnPreDrawListener(this);
        this.b.c.d.a(this.a);
        return false;
    }
}
