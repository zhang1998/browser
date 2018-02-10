package com.ucpro.feature.g.b;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.h.a;
import com.ucpro.feature.f.e;

/* compiled from: ProGuard */
final class i implements ValueCallback<a> {
    final /* synthetic */ m a;

    i(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.c.b(e.a((a) obj));
    }
}
