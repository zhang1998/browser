package com.ucpro.feature.g.b;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.h.a;
import com.ucpro.feature.f.e;

/* compiled from: ProGuard */
final class q implements ValueCallback<a> {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.a.b(e.a((a) obj));
    }
}
