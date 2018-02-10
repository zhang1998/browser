package com.ucpro.feature.a;

import com.uc.imagecodec.export.AnimationListener;
import com.uc.weex.component.c;

/* compiled from: ProGuard */
final class n extends AnimationListener {
    final /* synthetic */ c a;
    final /* synthetic */ p b;

    n(p pVar, c cVar) {
        this.b = pVar;
        this.a = cVar;
    }

    public final void onAnimationCompleted(int i) {
        this.a.a();
    }
}
