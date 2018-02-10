package com.ucpro.e;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ProGuard */
final class m implements OnPreDrawListener {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public final boolean onPreDraw() {
        if (this.a.j) {
            this.a.j = false;
            com.ucweb.common.util.h.m.a(2, new p(this.a));
        }
        return true;
    }
}
